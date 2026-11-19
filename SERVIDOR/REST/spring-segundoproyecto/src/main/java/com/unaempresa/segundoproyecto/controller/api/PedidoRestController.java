package com.unaempresa.segundoproyecto.controller.api;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.unaempresa.segundoproyecto.dto.PedidoRequestDto;
import com.unaempresa.segundoproyecto.dto.PedidoResponseDto;
import com.unaempresa.segundoproyecto.entity.Pedido;
import com.unaempresa.segundoproyecto.service.IPedidoService;

import jakarta.validation.Valid;

@RestController
public class PedidoRestController {

    private final IPedidoService pedidoService;

    public PedidoRestController(IPedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    private PedidoResponseDto toDto(Pedido p) {
        return PedidoResponseDto.builder()
            .id(p.getId())
            .fecha(p.getFecha())
            .estado(p.getEstado())
            .total(p.getTotal())
            .clienteId(p.getCliente().getId())
            .nombreCliente(p.getCliente().getNombre() + " " + p.getCliente().getApellido())
            .productoIds(p.getProductos().stream()
                .map(prod -> prod.getId())
                .collect(Collectors.toList()))
            .build();
    }

    @GetMapping("/api/pedidos")
    public ResponseEntity<List<PedidoResponseDto>> listar() {
        return ResponseEntity.ok(
            pedidoService.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList())
        );
    }

    @GetMapping("/api/pedidos/{id}")
    public ResponseEntity<PedidoResponseDto> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(toDto(pedidoService.findById(id)));
    }

    @GetMapping("/api/clientes/{clienteId}/pedidos")
    public ResponseEntity<List<PedidoResponseDto>> listarPorCliente(
            @PathVariable Long clienteId) {
        return ResponseEntity.ok(
            pedidoService.findByClienteId(clienteId).stream()
                .map(this::toDto)
                .collect(Collectors.toList())
        );
    }

    @PostMapping("/api/pedidos")
    public ResponseEntity<PedidoResponseDto> crear(
            @Valid @RequestBody PedidoRequestDto dto) {

        Pedido guardado = pedidoService.crearPedidoConProductos(
            dto.getClienteId(),
            dto.getProductoIds(),
            dto.getEstado(),
            dto.getTotal(),
            dto.getFecha()
        );

        URI location = ServletUriComponentsBuilder
            .fromCurrentContextPath()
            .path("/api/pedidos/{id}")
            .buildAndExpand(guardado.getId())
            .toUri();

        return ResponseEntity.created(location).body(toDto(guardado));
    }
}
