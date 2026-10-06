package com.unaempresa.segundoproyecto.model;

public class Loto {

	private String nombre;
	private Integer max;
	private Integer total;
	
	public Loto(String nombre, Integer max, Integer total) {
		this.nombre = nombre;
		this.max = max;
		this.total = total;
	}

	public String getNombre() {
		return nombre;
	}

	public Integer getMax() {
		return max;
	}

	public Integer getTotal() {
		return total;
	}
	
	
	
	
}
