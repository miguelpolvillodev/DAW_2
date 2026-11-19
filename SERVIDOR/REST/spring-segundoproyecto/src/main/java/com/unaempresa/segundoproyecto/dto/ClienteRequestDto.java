package com.unaempresa.segundoproyecto.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClienteRequestDto {

    @NotBlank(message = "{cliente.nombre.notblank}")
    @Size(min = 2, max = 50, message = "{cliente.nombre.size}")
    private String nombre;

    @NotBlank(message = "{cliente.apellido.notblank}")
    @Size(min = 2, max = 50, message = "{cliente.apellido.size}")
    private String apellido;

    @NotBlank(message = "{cliente.email.notblank}")
    @Email(message = "{cliente.email.email}")
    private String email;
}
