package com.unaempresa.segundoproyecto.exception;

public class CategoriaNoEncontradoException extends RuntimeException {

    public CategoriaNoEncontradoException(Long id) {
        super("No se encontró ninguna categoría con id: " + id);
    }
}
