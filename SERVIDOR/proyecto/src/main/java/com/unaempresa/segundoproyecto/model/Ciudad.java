package com.unaempresa.segundoproyecto.model;

public class Ciudad {

	private Integer id;
	private String url;
	private String nombre;
	private static int nextId = 1;
	
	public Ciudad( String nombre, String url) {
		id = nextId++;
		this.url = url;
		this.nombre = nombre;
	}

	public Integer getId() {
		return id;
	}

	public String getUrl() {
		return url;
	}

	public String getNombre() {
		return nombre;
	} 
	
	
	
	
}
