package com.unaempresa.servicios.model;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class Animal {

	private static int nextId;
	private int id;
	
	@NotBlank(message = "{animal.especie.obligatoria}")
	@Size(min=2, max=30, message = "{animal.especie.longitud}")
	private String especie;
	
	@Min(value = 0, message = "{animal.cantidad.minimo}") 
	@Max(value = 1000, message = "{animal.cantidad.maximo}")
	private int cantidad;
	
	@Positive(message = "{animal.precio.positivo}")
	@DecimalMax(value = "100000", message = "{animal.precio.maximo}")
	private double precio;
	
	@Pattern(regexp = "Mamífero|Ave|Pez|Reptil|Anfibio",
			message = "{animal.tipo.lista}")
	private String tipo;
	
	private boolean oferta;
	
	public Animal() {
		
	}
	
	public Animal( String especie, int cantidad, double precio, String tipo, boolean oferta) {
		id = nextId++;
		this.especie = especie;
		this.cantidad = cantidad;
		this.precio = precio;
		this.tipo = tipo;
		this.oferta = oferta;
	}

	public static int getNextId() {
		return nextId;
	}

	public static void setNextId(int nextId) {
		Animal.nextId = nextId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public boolean isOferta() {
		return oferta;
	}

	public void setOferta(boolean oferta) {
		this.oferta = oferta;
	}
	
	
	
	
}
