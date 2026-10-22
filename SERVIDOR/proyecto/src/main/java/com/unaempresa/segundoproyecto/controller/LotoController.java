package com.unaempresa.segundoproyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unaempresa.segundoproyecto.services.LotoServiceImpl;

@Controller
@RequestMapping("/loto")
public class LotoController {

	@Autowired
	@Qualifier("lotoService")
	private LotoServiceImpl lotoService;

	@GetMapping("/menu")
	public String mostrarLotos(Model model) {
		model.addAttribute("listaLotos", lotoService.importarLotos());
		return "lotos";
	}

	@GetMapping("/genera/{max}/{total}/{pais}")
	public String combinacion(Model model, @PathVariable Integer max, @PathVariable Integer total,
			@PathVariable String pais) {

		model.addAttribute("pais", pais);
		model.addAttribute("combinacion",lotoService.generarCombinacion(max, total));
		return "generador";
	}

}
