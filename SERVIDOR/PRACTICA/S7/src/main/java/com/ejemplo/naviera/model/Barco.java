package com.ejemplo.naviera.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

@Entity
public class Barco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotBlank
	@Size(min = 2, max = 60)
	private String nombre;

	@Min(value = 1)
	private int capacidad;

	@PositiveOrZero
	private long precio;

	@Column(name = "en_servicio")
	private boolean enServicio;

	@Enumerated(EnumType.STRING)
	@NotNull
	private TipoBarco tipo;

	public Barco() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public long getPrecio() {
		return precio;
	}

	public void setPrecio(long precio) {
		this.precio = precio;
	}

	public boolean isEnServicio() {
		return enServicio;
	}

	public void setEnServicio(boolean enServicio) {
		this.enServicio = enServicio;
	}

	public TipoBarco getTipo() {
		return tipo;
	}

	public void setTipo(TipoBarco tipo) {
		this.tipo = tipo;
	}

}
