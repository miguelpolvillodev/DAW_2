package com.unaempresa.servicios.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unaempresa.servicios.services.IBienvenidaService;

@RequestMapping("/bienvenida/saludo")
@Controller
public class BienvenidaController{

	@Autowired
	@Qualifier("bienvenidaService1")
	private IBienvenidaService bienvenidaService;
	
	@GetMapping("/adios/{nombre}")
	public String m(Model model,
			@PathVariable String nombre) {
		model.addAttribute("adios", bienvenidaService.dimeAdios(nombre));
		return "bienvenida/home";
	}
	
	@GetMapping("/hola/{nombre}")
	public String hola (Model model,
			@PathVariable String nombre) {
		model.addAttribute("hola", bienvenidaService.dimeHola(nombre));
		;
		return "bienvenida/home";
	}
	

	
	
}
