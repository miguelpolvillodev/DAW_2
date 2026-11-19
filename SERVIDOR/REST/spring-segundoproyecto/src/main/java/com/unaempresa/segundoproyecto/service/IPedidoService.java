package com.unaempresa.segundoproyecto.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.unaempresa.segundoproyecto.entity.Pedido;

public interface IPedidoService {
    List<Pedido> findAll();
    Pedido findById(Long id);
    void deleteById(Long id);
    Pedido save(Pedido pedido);
    List<Pedido> findByClienteId(Long clienteId);
    List<Pedido> findByEstado(String estado);
    Pedido crearPedidoConProductos(Long clienteId, List<Long> productosIds, String estado, BigDecimal total, LocalDate fecha);
}
