package com.unaempresa.servicios.services;

import org.springframework.stereotype.Service;

@Service("bienvenidaService1")
public class BienvenidaServiceImpl implements IBienvenidaService {

	@Override
	public String dimeHola() {
		return "Hola";
	}

	@Override
	public String dimeAdios() {
		return "adios";
	}

	@Override
	public String dimeHola(String nombre) {
		return "Hola " + nombre;
	}

	@Override
	public String dimeAdios(String nombre) {
		return "Adios " + nombre;
		
	}
}
