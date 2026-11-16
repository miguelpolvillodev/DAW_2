package com.ejemplo.cine.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pelicula {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	private String titulo;
	private Integer anio;
	@Enumerated(EnumType.STRING)
	private Genero genero;
	private long recaudacion;
	private boolean en_cartelera;
	
	public Pelicula() {
		
	}
	
	public Pelicula( String titulo, Integer anio, Genero genero, long recaudacion, boolean en_cartelera) {
		this.titulo = titulo;
		this.anio = anio;
		this.genero = genero;
		this.recaudacion = recaudacion;
		this.en_cartelera = en_cartelera;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public long getRecaudacion() {
		return recaudacion;
	}

	public void setRecaudacion(long recaudacion) {
		this.recaudacion = recaudacion;
	}

	public boolean isEn_cartelera() {
		return en_cartelera;
	}

	public void setEn_cartelera(boolean en_cartelera) {
		this.en_cartelera = en_cartelera;
	}
	
	
	
	
	
}
