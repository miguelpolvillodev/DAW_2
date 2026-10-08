package com.unaempresa.segundoproyecto.model;

public class Loto {

	private String pais;
	private Integer max;
	private Integer total;
	
	public Loto(String pais, Integer max, Integer total) {
		this.pais = pais;
		this.max = max;
		this.total = total;
	}

	public String getNombre() {
		return pais;
	}

	public Integer getMax() {
		return max;
	}

	public Integer getTotal() {
		return total;
	}
	
	
	
	
}
