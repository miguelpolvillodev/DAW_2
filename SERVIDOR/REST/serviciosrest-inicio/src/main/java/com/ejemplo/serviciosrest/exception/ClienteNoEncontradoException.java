package com.ejemplo.serviciosrest.exception;

public class ClienteNoEncontradoException extends RuntimeException {

    public ClienteNoEncontradoException(Long id) {
        super("No existe el cliente " + id);
    }
}
