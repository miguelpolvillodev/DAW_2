package com.unaempresa.segundoproyecto.model;

public class Libro {

	private Integer id;
	private String titulo;
	private String autor;
	private Integer n_ejemplares;
	private String genero;
	private static int nextId = 1; 
	
	public Libro(String titulo, String autor, Integer n_ejemplares, String genero) {
		id = nextId++;
		this.titulo = titulo;
		this.autor = autor;
		this.n_ejemplares = n_ejemplares;
		this.genero = genero;
	}

	public Integer getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getAutor() {
		return autor;
	}

	public Integer getN_ejemplares() {
		return n_ejemplares;
	}

	public String getGenero() {
		return genero;
	}
	
	
	
	
}
