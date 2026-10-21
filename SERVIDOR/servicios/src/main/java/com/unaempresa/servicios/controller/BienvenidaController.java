package com.unaempresa.servicios.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unaempresa.servicios.services.BienvenidaService;

@RequestMapping("/bienvenida")
@Controller
public class BienvenidaController {
/* 
	/bienvenida/saludo/hola
    /bienvenida/saludo/adios
	/bienvenida/saludo/hola/{nombre}
	/bienvenida/saludo/adios/{nombre}
*/	
	@Autowired
	private BienvenidaService bienvenidaService;
	
	@GetMapping("/saludo/adios/{nombre}")
	public String m(Model model,
			@PathVariable String nombre) {
		model.addAttribute("adios", bienvenidaService.dimeAdios(nombre));
		return "bienvenida/home";
	}
	
	@GetMapping("/saludo/hola/{nombre}")
	public String hola (Model model,
			@PathVariable String nombre) {
		model.addAttribute("hola", bienvenidaService.dimeHola(nombre));
		;
		return "bienvenida/home";
	}
	

	
	
}
