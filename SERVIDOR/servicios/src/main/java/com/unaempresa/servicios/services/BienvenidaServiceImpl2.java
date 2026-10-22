package com.unaempresa.servicios.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("bienvenidaService2")
@Primary
public class BienvenidaServiceImpl2 implements IBienvenidaService{

	@Override
	public String dimeHola() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String dimeAdios() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String dimeHola(String nombre) {
		// TODO Auto-generated method stub
		return "Hola impl2 " +  nombre;
	}

	@Override
	public String dimeAdios(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

}
