package com.unaempresa.segundoproyecto.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PedidoResponseDto {
    private Long id;
    private LocalDate fecha;
    private String estado;
    private BigDecimal total;
    private Long clienteId;
    private String nombreCliente;
    private List<Long> productoIds;
}
