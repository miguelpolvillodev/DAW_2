package com.unaempresa.primerproyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.unaempresa.primerproyecto.model.Persona;

@Controller
public class PersonaController {

	@GetMapping("/persona/form")
	public String mostrarFormBlanco(Model model){
	model.addAttribute("persona", new Persona());
		return "persona/form";
	}
	
	@PostMapping("/persona/form")
	public String enviarDatos(Model model, Persona p) {
		p.toString();
		return "persona/ok";
	}

}
