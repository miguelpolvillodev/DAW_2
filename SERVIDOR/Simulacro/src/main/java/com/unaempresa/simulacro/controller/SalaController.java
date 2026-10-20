package com.unaempresa.simulacro.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.unaempresa.simulacro.model.Sala;

@RequestMapping("/salas")
@Controller
public class SalaController {

	private final List<Sala> salas = Sala.importarSalas();

	private Set<Integer> salasPlanta(Integer planta) {
		Set<Integer> salasFiltro = new HashSet<>();

		for (Sala s : salas) {
			if (s.getPlanta().equals(planta)) {
				salasFiltro.add(s.getPlanta());
			}
		}
		return salasFiltro;
	}


	private Sala salaId(Integer id) {
		for (Sala s : salas) {
			if (s.getId().equals(id)) {
				return s;
			}
		}
		return null;
	}

	@GetMapping
	public String salasListado(Model model) {
		model.addAttribute("listaSalas", salas);
		return "salas";
	}


	@GetMapping("/{planta}")
	public String filtroPlanta(Model model, @RequestParam Integer planta) {
		model.addAttribute("listaPlantas", salasPlanta(planta));
		model.addAttribute("listaSalas", salas);
		return "salas";
	}


	@GetMapping("/{id}")
	public String filtroId(Model model, @PathVariable Integer id) {
		model.addAttribute("sala", salaId(id));
		return "una-sala";
	}
}