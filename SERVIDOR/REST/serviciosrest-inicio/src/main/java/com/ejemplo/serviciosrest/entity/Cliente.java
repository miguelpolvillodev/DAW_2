package com.ejemplo.serviciosrest.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Entidad JPA: solo @Getter/@Setter, nunca @Data (con relaciones bidireccionales
// @Data arrastra @EqualsAndHashCode/@ToString y puede acabar en StackOverflowError;
// aquí no hay relaciones, pero es la norma a seguir siempre).
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String email;
    private String telefono;
}
