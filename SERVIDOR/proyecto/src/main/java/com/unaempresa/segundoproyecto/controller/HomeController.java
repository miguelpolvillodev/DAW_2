package com.unaempresa.segundoproyecto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
@Controller
public class HomeController {

	List<String> proverbios = importarProverbios();

	private List<String> importarProverbios() {
		List<String> ts = new ArrayList<>();

		ts.add("A cada cerdo le llega su San Martín");
		ts.add("De tal palo, tal astilla");
		ts.add("Más vale pájaro en mano que ciento volando");
		ts.add("No hay mal que dure 100 años");
		ts.add("Al mal tiempo, buena cara");
		ts.add("A la tercera va la vencida");
		ts.add("El tiempo todo lo cura");
		ts.add("Donde fueres, haz lo que vieres");
		ts.add("Obras son amores, que no buenas razones");
		ts.add("En boca cerrada no entra mosca");

		return ts;
	}

	public String randomProverbio(List<String> proverbios) {
		String proverbioElegido;
		Random random = new Random();

		proverbioElegido = proverbios.get(random.nextInt(0, 11));

		return proverbioElegido;
	}

	@GetMapping("/home")
	public String mostrarProverbios(Model model) {
		model.addAttribute("proverbio", randomProverbio(proverbios));
		return "home";
	}

}
