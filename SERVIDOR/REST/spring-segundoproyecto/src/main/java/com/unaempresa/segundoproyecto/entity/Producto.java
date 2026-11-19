package com.unaempresa.segundoproyecto.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "productos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "{producto.nombre.notblank}")
    @Size(min = 2, max = 100, message = "{producto.nombre.size}")
    private String nombre;

    @NotNull(message = "{producto.precio.notnull}")
    @DecimalMin(value = "0.0", message = "{producto.precio.min}")
    private BigDecimal precio;

    @ManyToMany(mappedBy = "productos", fetch = FetchType.LAZY)
    @Builder.Default
    private List<Pedido> pedidos = new ArrayList<>();

    @ManyToMany(mappedBy = "productos", fetch = FetchType.LAZY)
    @Builder.Default
    private List<Categoria> categorias = new ArrayList<>();
}
