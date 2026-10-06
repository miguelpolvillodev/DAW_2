package com.unaempresa.segundoproyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CalculadoraController {

	@GetMapping("/{operacion}/{a}/{b}")
	public String m(Model m, @PathVariable String operacion, @PathVariable int num1, @PathVariable int num2) {

		if (operacion.equals("multiplicar")) {
			m.addAttribute("resultado", ""+num1+"x"+num2+"="+num1*num2);
			String txt = "<p>Hola, esto es un párrafo</p>";
			m.addAttribute("textoHtml", txt);
			return "calcular";
		}

		if (operacion.equals("sumar")) {
			m.addAttribute("resultado", ""+num1+"+"+num2+"="+num1*num2);
			String txt = "<p>Hola, esto es un párrafo</p>";
			m.addAttribute("textoHtml", txt);
			return "calcular";
		}
		return null;

	}
	
}
