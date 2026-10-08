package com.unaempresa.segundoproyecto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unaempresa.segundoproyecto.model.Loto;

@Controller
@RequestMapping("/loto")
public class LotoController {

	List<Loto> listaLotos = importarLotos();

	private List<Loto> importarLotos() {
		List<Loto> ts = new ArrayList<>();

		ts.add(new Loto("España", 49, 6));
		ts.add(new Loto("Alemania", 49, 6));
		ts.add(new Loto("Francia", 90, 6));
		ts.add(new Loto("Italia", 49, 5));

		return ts;
	}

	private List<Integer> generarCombinacion(int max, int cantidad) {
		Random random = new Random();
		List<Integer> combinacion = new ArrayList<>();

		while (combinacion.size() < cantidad) {
			int numero = random.nextInt(max) + 1;
			if (!combinacion.contains(numero)) {
				combinacion.add(numero);
			}
		}
		combinacion.sort(null);
		return combinacion;
	}

	@GetMapping("/menu")
	public String mostrarLotos(Model model) {
		model.addAttribute("listaLotos", listaLotos);
		return "lotos";
	}

	@GetMapping("/genera/{max}/{total}/{pais}")
	public String combinacion(Model model, @PathVariable Integer max, @PathVariable Integer total,
			@PathVariable String pais) {

		model.addAttribute("pais", pais);
		model.addAttribute("combinacion", generarCombinacion(max, total));
		return "generador";
	}

}
