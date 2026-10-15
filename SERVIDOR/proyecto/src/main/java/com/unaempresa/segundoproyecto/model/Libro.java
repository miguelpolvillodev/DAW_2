package com.unaempresa.segundoproyecto.model;

public class Libro {

	private Integer id;
	private String titulo;
	private String autor;
	private Integer n_ejemplares;
	private String genero;
	private static int nextId = 1; 
	
	
	public Libro() {
		id = nextId++;
	}
	public Libro(String titulo, String autor, Integer n_ejemplares, String genero) {
		id = nextId++;
		this.titulo = titulo;
		this.autor = autor;
		this.n_ejemplares = n_ejemplares;
		this.genero = genero;
	}
	

	public static int getNextId() {
		return nextId;
	}
	public static void setNextId(int nextId) {
		Libro.nextId = nextId;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public void setN_ejemplares(Integer n_ejemplares) {
		this.n_ejemplares = n_ejemplares;
	}
	public void setGenero(String genero) {
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
	@Override
	public String toString() {
		return "Libro [id=" + id + ", titulo=" + titulo + ", autor=" + autor + ", n_ejemplares=" + n_ejemplares
				+ ", genero=" + genero + "]";
	}
	
	
	
	
	
	
}
