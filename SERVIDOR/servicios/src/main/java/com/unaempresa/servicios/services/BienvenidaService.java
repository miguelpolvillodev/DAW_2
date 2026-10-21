package com.unaempresa.servicios.services;

import org.springframework.stereotype.Service;

@Service
public class BienvenidaService {

	public String dimeHola() {
		return "Hola";
	}

	public String dimeAdios() {
		return "adios";
	}

	public String dimeHola(String nombre) {
		return "Hola " + nombre;
	}
	
	public String dimeAdios(String nombre) {
		return "Adios " + nombre;
	}
}
