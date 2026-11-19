package com.unaempresa.segundoproyecto.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unaempresa.segundoproyecto.entity.Cliente;
import com.unaempresa.segundoproyecto.entity.Pedido;
import com.unaempresa.segundoproyecto.entity.Producto;
import com.unaempresa.segundoproyecto.exception.ClienteNoEncontradoException;
import com.unaempresa.segundoproyecto.exception.PedidoNoEncontradoException;
import com.unaempresa.segundoproyecto.repository.IClienteRepository;
import com.unaempresa.segundoproyecto.repository.IPedidoRepository;
import com.unaempresa.segundoproyecto.repository.IProductoRepository;


@Service
public class PedidoServiceImpl implements IPedidoService {

    private final IPedidoRepository pedidoRepository;
    private final IClienteRepository clienteRepository;
    private final IProductoRepository productoRepository;

    public PedidoServiceImpl(IPedidoRepository pedidoRepository,
                             IClienteRepository clienteRepository,
                             IProductoRepository productoRepository) {
        this.pedidoRepository = pedidoRepository;
        this.clienteRepository = clienteRepository;
        this.productoRepository = productoRepository;
    }

    @Override
    public List<Pedido> findAll() {
        return pedidoRepository.findAll();
    }

    @Override
    public Pedido findById(Long id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new PedidoNoEncontradoException(id));
    }

    @Override
    public void deleteById(Long id) {
        pedidoRepository.deleteById(id);
    }

    @Override
    public Pedido save(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Pedido> findByClienteId(Long clienteId) {
        return pedidoRepository.findByClienteId(clienteId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Pedido> findByEstado(String estado) {
        return pedidoRepository.findByEstado(estado);
    }

    @Override
    @Transactional
    public Pedido crearPedidoConProductos(Long clienteId, List<Long> productosIds, String estado, BigDecimal total, LocalDate fecha) {
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new ClienteNoEncontradoException(clienteId));
        List<Producto> productos = productoRepository.findAllById(productosIds);

        Pedido pedido = Pedido.builder()
                .cliente(cliente)
                .productos(productos)
                .fecha(fecha)
                .estado(estado)
                .total(total)
                .build();

        return pedidoRepository.save(pedido);
    }
}
