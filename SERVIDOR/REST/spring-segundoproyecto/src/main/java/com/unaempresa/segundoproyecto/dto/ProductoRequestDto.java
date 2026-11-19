package com.unaempresa.segundoproyecto.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductoRequestDto {

    @NotBlank(message = "{producto.nombre.notblank}")
    @Size(min = 2, max = 100, message = "{producto.nombre.size}")
    private String nombre;

    @NotNull(message = "{producto.precio.notnull}")
    @DecimalMin(value = "0.0", message = "{producto.precio.min}")
    private BigDecimal precio;
}
