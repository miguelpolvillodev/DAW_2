package com.unaempresa.segundoproyecto.model;


public class Taller {

	
	private Integer id;
	private String nombre;
	private String tipo;
	private int plazas;
	private static int nextId = 1; 
	
	public Taller( String nombre, int plazas, String tipo) {
		id = nextId++;
		this.tipo = tipo;
		this.nombre = nombre;
		this.plazas = plazas;
	}

	public Integer getId() {
		return id;
	}


	public String getNombre() {
		return nombre;
	}


	public int getPlazas() {
		return plazas;
	}

	

	public String getTipo() {
		return tipo;
	}

	@Override
	public String toString() {
		return "Taller [id=" + id + ", nombre=" + nombre + ", plazas=" + plazas + "]";
	}
	
	
	
	
	
	

	
}
