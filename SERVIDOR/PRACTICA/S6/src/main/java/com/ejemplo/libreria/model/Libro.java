package com.ejemplo.libreria.model;

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
public class Libro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank @Size(min = 2, max = 60)
	private String titulo;
	
	@Min(value = 1)
	private int paginas;
	
	@PositiveOrZero
	private Long ventas;
	
	@Column(name = "es_novedad")
	private boolean esNovedad;
	
	@Enumerated(EnumType.STRING)
	@NotNull
	private Categoria categoria;
	
	public Libro() {
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

	public int getPaginas() {
		return paginas;
	}

	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}

	public Long getVentas() {
		return ventas;
	}

	public void setVentas(Long ventas) {
		this.ventas = ventas;
	}

	public boolean isEsNovedad() {
		return esNovedad;
	}

	public void setEsNovedad(boolean esNovedad) {
		this.esNovedad = esNovedad;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
	
	
}
