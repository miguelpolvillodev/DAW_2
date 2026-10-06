package com.unaempresa.segundoproyecto.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unaempresa.segundoproyecto.model.Taller;

@Controller
@RequestMapping("/taller")
public class TallerController {

	private final List<Taller> listaTaller = crearTaller();

	private List<Taller> crearTaller() {
		List<Taller> ts = new ArrayList<>();

		ts.add(new Taller("Taller 1", 10, "Normal"));
		ts.add(new Taller("Taller 2", 15, "Normal"));
		ts.add(new Taller("Taller 3", 3, "Premium"));
		ts.add(new Taller("Taller 4", 12, "Premium"));
		ts.add(new Taller("Taller 5", 100, "Normal"));

		return ts;
	}

	private Taller dameIdTaller(int id) {
		for (Taller t : listaTaller) {
			if (t.getId() == id) {
				return t;
			}
		}
		return null;
	}

	private List<Taller> talleresFiltrados(String tipo) {
		List<Taller> talleresFiltro = new ArrayList<>();

		for (Taller t : listaTaller) {
			if (t.getTipo().equals(tipo)) {
				talleresFiltro.add(t);
			}
		}
		return talleresFiltro;
	}

	@GetMapping("/uno/{id}")
	public String unTallerPorId(Model model, @PathVariable int id) {
		model.addAttribute("taller", dameIdTaller(id));
		return "taller/un-taller";
	}

	@GetMapping("/todos")
	public String todosLosTalleres(Model model) {
		model.addAttribute("listaTalleres", listaTaller);
		return "/taller/todos";
	}

	@GetMapping("/tipo/{tipo}")
	public String filtroTalleres(Model model, @PathVariable String tipo) {
		model.addAttribute("listaTalleres", talleresFiltrados(tipo));
		model.addAttribute("tipo", tipo);
		return "/taller/todos";
	}
}
