package com.ejemplo.modeloExamen.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pelicula {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String titulo;
	private Integer anio;
	private long recaudacion;
	private boolean en_cartelera;
	@Enumerated(EnumType.STRING)
	private Genero genero;
	
	public Pelicula() {
		
	}
	
	
	public Pelicula(String titulo, Integer anio, long recaudacion, boolean en_cartelera, Genero genero) {
		this.titulo = titulo;
		this.anio = anio;
		this.recaudacion = recaudacion;
		this.en_cartelera = en_cartelera;
		this.genero = genero;
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


	public long getRecaudacion() {
		return recaudacion;
	}


	public void setRecaudacion(long recaudacion) {
		this.recaudacion = recaudacion;
	}


	public boolean isEnCartelera() {
		return en_cartelera;
	}


	public void setEnCartelera(boolean enCartelera) {
		this.en_cartelera = enCartelera;
	}


	public Genero getGenero() {
		return genero;
	}


	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	
	
	
	
}
