package com.ejemplo.serviciosrest.controller.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplo.serviciosrest.dto.ClienteResponseDto;
import com.ejemplo.serviciosrest.entity.Cliente;
import com.ejemplo.serviciosrest.service.ClienteService;

@RequestMapping("/api/clientes")
@RestController
public class ClienteRestController {

	private final ClienteService clienteService;

	ClienteRestController (ClienteService clienteService) {
		this.clienteService = clienteService;
	}
	
	private ClienteResponseDto aDto(Cliente c) {
		return new ClienteResponseDto(c.getId(), c.getNombre(),
				c.getEmail(), c.getTelefono());
	}
	
	@GetMapping
	public List<ClienteResponseDto> listar() {
        return clienteService.listaClientes().stream()
                .map(this::aDto)
                .toList();
    }
	
	@GetMapping("/{id}")
	public ClienteResponseDto obtener (@PathVariable Long id) {
		return aDto(clienteService.buscaPorId(id));
	}
	
	@PostMapping("/borrar/{id}")
	public void borrarPorId( @PathVariable Long id) {
		 clienteService.borra(id);
	}
}
