package com.ejemplo.demo.model;

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
public class Pelicula {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank @Size(min=2 , max=60)
	private String titulo;
	@Min(1888)
	private int anio;
	@PositiveOrZero
	private long recaudacion;
	@Column(name = "en_cartelera")
	private boolean enCartelera;
	@Enumerated(EnumType.STRING) @NotNull
	private Genero genero;
	
	public Pelicula() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public long getRecaudacion() {
		return recaudacion;
	}

	public void setRecaudacion(long recaudacion) {
		this.recaudacion = recaudacion;
	}

	public boolean isEnCartelera() {
		return enCartelera;
	}

	public void setEnCartelera(boolean enCartelera) {
		this.enCartelera = enCartelera;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	
	
	
	
}
