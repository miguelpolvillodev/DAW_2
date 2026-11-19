package com.unaempresa.segundoproyecto.exception;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ApiErrorResponse {
    private int status;
    private String error;
    private String mensaje;
    private String ruta;
    private String timestamp;
}
