package com.ejemplo.serviciosrest.service;

import com.ejemplo.serviciosrest.exception.ClienteNoEncontradoException;
import com.ejemplo.serviciosrest.entity.Cliente;
import com.ejemplo.serviciosrest.repository.ClienteRepository;
import java.util.List;
import org.springframework.stereotype.Service;

// La capa de servicio no cambia por tener encima una API REST además de las vistas
// MVC: es la misma capa, con la misma interfaz, reutilizada por los dos controladores.
@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<Cliente> listaClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscaPorId(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new ClienteNoEncontradoException(id));
    }

    @Override
    public Cliente guarda(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public void borra(Long id) {
        clienteRepository.deleteById(id);
    }
}
