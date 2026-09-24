package com.unaempresa.segundoproyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/saludo")
public class SaludoController {

	@GetMapping("/saludo1/{nombre}/{apellido}")
	public String m(@PathVariable String nombre,
			@PathVariable String apellido) { 
		//model.addAttribute("nombre",nombre );
		//model.addAttribute("apellido", apellido);
		return "saludo/hola";
	}
}
