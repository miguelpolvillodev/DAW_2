package com.unaempresa.segundoproyecto.exception;

public class ProductoNoEncontradoException extends RuntimeException {

    public ProductoNoEncontradoException(Long id) {
        super("No se encontró ningún producto con id: " + id);
    }
}
