package com.unaempresa.segundoproyecto.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PedidoRequestDto {

    @NotNull(message = "{pedido.fecha.notnull}")
    private LocalDate fecha;

    @NotBlank(message = "{pedido.estado.notblank}")
    private String estado;

    @NotNull(message = "{pedido.total.notnull}")
    @DecimalMin(value = "0.0", message = "{pedido.total.min}")
    private BigDecimal total;

    @NotNull(message = "El clienteId es obligatorio")
    private Long clienteId;

    private List<Long> productoIds = List.of();
}
