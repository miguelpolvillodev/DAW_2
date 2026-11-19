package com.unaempresa.segundoproyecto.controller.api;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.unaempresa.segundoproyecto.dto.ClienteRequestDto;
import com.unaempresa.segundoproyecto.dto.ClienteResponseDto;
import com.unaempresa.segundoproyecto.entity.Cliente;
import com.unaempresa.segundoproyecto.service.IClienteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/clientes")
public class ClienteRestController {

    private final IClienteService clienteService;

    public ClienteRestController(IClienteService clienteService) {
        this.clienteService = clienteService;
    }

    private ClienteResponseDto toDto(Cliente c) {
        return ClienteResponseDto.builder()
            .id(c.getId())
            .nombre(c.getNombre())
            .apellido(c.getApellido())
            .email(c.getEmail())
            .numeroPedidos(c.getPedidos().size())
            .build();
    }

    @GetMapping
    public ResponseEntity<List<ClienteResponseDto>> listar() {
        List<ClienteResponseDto> dtos = clienteService.findAll().stream()
            .map(this::toDto)
            .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDto> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(toDto(clienteService.findById(id)));
    }

    @PostMapping
    public ResponseEntity<ClienteResponseDto> crear(@Valid @RequestBody ClienteRequestDto dto) {

        Cliente nuevo = Cliente.builder()
            .nombre(dto.getNombre())
            .apellido(dto.getApellido())
            .email(dto.getEmail())
            .build();

        Cliente guardado = clienteService.save(nuevo);

        URI location = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(guardado.getId())
            .toUri();

        return ResponseEntity.created(location).body(toDto(guardado));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponseDto> actualizar(
            @PathVariable Long id,
            @Valid @RequestBody ClienteRequestDto dto) {

        Cliente existente = clienteService.findById(id);
        existente.setNombre(dto.getNombre());
        existente.setApellido(dto.getApellido());
        existente.setEmail(dto.getEmail());

        return ResponseEntity.ok(toDto(clienteService.save(existente)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        clienteService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
