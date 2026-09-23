package com.unaempresa.primerproyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/home","/h"})
public class HomeController {
	
	@ModelAttribute(name = "titulo")
	public String m() {
		return "Home things";
	}

	@GetMapping({"/hola-mundo","/holamundo"})
	public String holaMundo(Model model) {
		return "hola";
	}
	
	@GetMapping("/adios-mundo")
	public String adiosMundo(Model model) {
		return "adios";
	}
}
