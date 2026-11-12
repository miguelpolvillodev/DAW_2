package com.ejemplo.modeloExamen.model;


import jakarta.persistence.Column;
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
	@Column(name = "en_cartelera")
	private boolean enCartelera;
	@Enumerated(EnumType.STRING)
	private Genero genero;
	
	public Pelicula() {
		
	}
	
	
	public Pelicula(String titulo, Integer anio, long recaudacion, boolean enCartelera, Genero genero) {
		this.titulo = titulo;
		this.anio = anio;
		this.recaudacion = recaudacion;
		this.enCartelera = enCartelera;
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

	

	@Override
	public String toString() {
		return "Pelicula [id=" + id + ", titulo=" + titulo + ", anio=" + anio + ", recaudacion=" + recaudacion
				+ ", en_cartelera=" + enCartelera + ", genero=" + genero + "]";
	}
	
	
	
	
}
