package com.unaempresa.simulacro.model;

import java.util.ArrayList;
import java.util.List;

public class Sala {
	
	private Integer id;
	private String nombre;
	private Integer planta;
	private Integer aforo;
	private String email;
	private String estado;
	private static int nextId = 1;
	
	public Sala() {
		this.id = nextId++;
	}
	
	public Sala(Integer id, String nombre, Integer planta, Integer aforo, String email, String estado) {
		this.id = id;
		this.nombre = nombre;
		this.planta = planta;
		this.aforo = aforo;
		this.email = email;
		this.estado = estado;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getPlanta() {
		return planta;
	}

	public void setPlanta(Integer planta) {
		this.planta = planta;
	}

	public Integer getAforo() {
		return aforo;
	}

	public void setAforo(Integer aforo) {
		this.aforo = aforo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String isLibre) {
		this.estado = isLibre;
	}

	public static int getNextId() {
		return nextId;
	}

	public static void setNextId(int nextId) {
		Sala.nextId = nextId;
	}
	
	public static List<Sala> importarSalas(){
		List<Sala> listaSalas = new ArrayList<>();
		
		listaSalas.add(new Sala(1,"Sala Cervantes",0,12,"cervantes@centro.es","libre"));
		listaSalas.add(new Sala(2,"Sala Picaso",1,8,"picasso@centro.es","ocupada"));
		listaSalas.add(new Sala(3,"Sala Lorca",1,20,"lorca@centro.es","libre"));
		listaSalas.add(new Sala(4,"Sala Turing",2,6,"turing@centro.es","ocupada"));
		
		
		return listaSalas;
	
	}

	@Override
	public String toString() {
		return id + " - " + nombre + " - planta " + planta + " - aforo " + aforo + " - " + email
				+ " - " + estado;
	}
	
	
	
	

}
