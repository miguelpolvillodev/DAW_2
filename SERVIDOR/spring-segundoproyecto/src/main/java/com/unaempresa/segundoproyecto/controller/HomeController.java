package com.unaempresa.segundoproyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/home")
@Controller
public class HomeController {
	
	@ModelAttribute(name = "titulo")
	public String m() {
		return "Esto se cambia :)";
	}

	@GetMapping({"/hola-mundo"})
	public String holaMundo() {
		return "hola";
	}
	
	@GetMapping({"/adios-mundo"})
	public String adiosMundo() {
		return "adios";
	}

}
