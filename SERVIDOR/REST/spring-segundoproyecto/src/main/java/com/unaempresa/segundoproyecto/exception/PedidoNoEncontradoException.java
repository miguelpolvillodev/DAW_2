package com.unaempresa.segundoproyecto.exception;

public class PedidoNoEncontradoException extends RuntimeException {

    public PedidoNoEncontradoException(Long id) {
        super("No se encontró ningún pedido con id: " + id);
    }
}
