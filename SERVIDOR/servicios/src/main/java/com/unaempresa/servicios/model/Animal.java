package com.unaempresa.servicios.model;

public class Animal {

	// Contador compartido por la clase (static): da un id distinto a cada animal nuevo.
	private static int nextId = 1;

	// Todos los atributos son privados: solo se accede a ellos con getters y setters.
	private int id;
	private String especie;
	private int cantidad;
	private double precio;
	private String tipo;
	private boolean oferta;

	// Constructor en blanco: crea un animal vacío, con id = 0, para rellenarlo con los setters.
	// Spring lo usa para recoger los datos del formulario.
	public Animal() {
	}

	// El id no se recibe por parámetro: lo asigna la propia clase con nextId++.
	public Animal(String especie, int cantidad, double precio, String tipo, boolean oferta) {
		this.id = nextId++;
		this.especie = especie;
		this.cantidad = cantidad;
		this.precio = precio;
		this.tipo = tipo;
		this.oferta = oferta;
	}

	// Getter: permite leer una propiedad privada desde fuera de la clase.
	public int getId() {
		return id;
	}

	// Setter: permite modificar una propiedad privada desde fuera de la clase.
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

	// En un boolean el getter se llama isXxx en lugar de getXxx.
	public boolean isOferta() {
		return oferta;
	}

	public void setOferta(boolean oferta) {
		this.oferta = oferta;
	}

	@Override
	public String toString() {
		return "Animal [id=" + id + ", especie=" + especie + ", cantidad=" + cantidad
				+ ", precio=" + precio + ", tipo=" + tipo + ", oferta=" + oferta + "]";
	}
}
