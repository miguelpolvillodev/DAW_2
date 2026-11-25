package com.ejemplo.serviciosrest.service;

import com.ejemplo.serviciosrest.entity.Cliente;
import java.util.List;

public interface ClienteService {
    List<Cliente> listaClientes();
    Cliente buscaPorId(Long id);
    Cliente guarda(Cliente cliente);
    void borra(Long id);
}
