package com.unaempresa.segundoproyecto.exception;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice(basePackages = "com.unaempresa.segundoproyecto.controller.api")
public class ApiExceptionHandler {

    private static final DateTimeFormatter FMT =
        DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

    private String ahora() {
        return LocalDateTime.now().format(FMT);
    }

    @ExceptionHandler(ClienteNoEncontradoException.class)
    public ResponseEntity<ApiErrorResponse> handleClienteNoEncontrado(
            ClienteNoEncontradoException ex, HttpServletRequest req) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
            ApiErrorResponse.builder()
                .status(404).error("Not Found")
                .mensaje(ex.getMessage())
                .ruta(req.getRequestURI())
                .timestamp(ahora())
                .build()
        );
    }

    @ExceptionHandler(PedidoNoEncontradoException.class)
    public ResponseEntity<ApiErrorResponse> handlePedidoNoEncontrado(
            PedidoNoEncontradoException ex, HttpServletRequest req) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
            ApiErrorResponse.builder()
                .status(404).error("Not Found")
                .mensaje(ex.getMessage())
                .ruta(req.getRequestURI())
                .timestamp(ahora())
                .build()
        );
    }

    @ExceptionHandler(ProductoNoEncontradoException.class)
    public ResponseEntity<ApiErrorResponse> handleProductoNoEncontrado(
            ProductoNoEncontradoException ex, HttpServletRequest req) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
            ApiErrorResponse.builder()
                .status(404).error("Not Found")
                .mensaje(ex.getMessage())
                .ruta(req.getRequestURI())
                .timestamp(ahora())
                .build()
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiErrorResponse> handleValidacion(
            MethodArgumentNotValidException ex, HttpServletRequest req) {

        String errores = ex.getBindingResult().getFieldErrors().stream()
            .map(fe -> fe.getField() + ": " + fe.getDefaultMessage())
            .collect(Collectors.joining(", "));

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
            ApiErrorResponse.builder()
                .status(400).error("Bad Request")
                .mensaje(errores)
                .ruta(req.getRequestURI())
                .timestamp(ahora())
                .build()
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorResponse> handleGenerico(
            Exception ex, HttpServletRequest req) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
            ApiErrorResponse.builder()
                .status(500).error("Internal Server Error")
                .mensaje("Error interno del servidor: " + ex.getMessage())
                .ruta(req.getRequestURI())
                .timestamp(ahora())
                .build()
        );
    }
}
