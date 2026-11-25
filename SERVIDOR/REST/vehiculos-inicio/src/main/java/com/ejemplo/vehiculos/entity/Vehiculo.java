package com.ejemplo.vehiculos.entity;

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
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String marca;
    private String modelo;
    private String matricula;
    private int anio;
    private double precio;
}
