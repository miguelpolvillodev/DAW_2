package com.unaempresa.segundoproyecto.controller;

import java.util.random.RandomGenerator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/lanzar-dado")
public class DadoController {

	@GetMapping("/dado")
	public String dadoHandler(Model model) {
		model.addAttribute("caraDado", RandomGenerator.getDefault().nextInt(1,7));
		return "/dado";
	}
}
