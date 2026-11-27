package com.ejemplo.puerto.model;

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
	
	@Min(value = 3)
	private int eslora;
	
	@PositiveOrZero
	private long precio;
	
	@Column(name = "en_puerto")
	private boolean enPuerto;
	
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

	public int getEslora() {
		return eslora;
	}

	public void setEslora(int eslora) {
		this.eslora = eslora;
	}

	public long getPrecio() {
		return precio;
	}

	public void setPrecio(long precio) {
		this.precio = precio;
	}

	public boolean isEnPuerto() {
		return enPuerto;
	}

	public void setEnPuerto(boolean enPuerto) {
		this.enPuerto = enPuerto;
	}

	public TipoBarco getTipo() {
		return tipo;
	}

	public void setTipo(TipoBarco tipo) {
		this.tipo = tipo;
	}
	
	
	
	
}
