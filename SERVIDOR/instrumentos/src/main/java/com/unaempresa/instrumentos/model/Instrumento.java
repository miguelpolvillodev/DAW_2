package com.unaempresa.instrumentos.model;

public class Instrumento {

	private static int nextId = 1;
	
	private long id;
	private String modelo;
	private Integer existencias;
	private Double precio;
	private Familia familia;
	private boolean usado;
	
	public Instrumento() {
		
	}
	
	public Instrumento(String modelo, Integer existencias, Double precio, Familia familia, boolean usado) {
		
		this.id = nextId++;
		this.modelo = modelo;
		this.existencias = existencias;
		this.precio = precio;
		this.familia = familia;
		this.usado = usado;
	}

	public static int getNextId() {
		return nextId;
	}

	public static void setNextId(int nextId) {
		Instrumento.nextId = nextId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Integer getExistencias() {
		return existencias;
	}

	public void setExistencias(Integer existencias) {
		this.existencias = existencias;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Familia getFamilia() {
		return familia;
	}

	public void setFamilia(Familia familia) {
		this.familia = familia;
	}

	public boolean isUsado() {
		return usado;
	}

	public void setUsado(boolean usado) {
		this.usado = usado;
	}
	
	
	
	
}
