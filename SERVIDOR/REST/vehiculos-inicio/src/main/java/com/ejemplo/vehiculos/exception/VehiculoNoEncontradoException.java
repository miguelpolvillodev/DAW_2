package com.ejemplo.vehiculos.exception;

public class VehiculoNoEncontradoException extends RuntimeException {

    public VehiculoNoEncontradoException(Long id) {
        super("No existe el vehículo " + id);
    }
}
