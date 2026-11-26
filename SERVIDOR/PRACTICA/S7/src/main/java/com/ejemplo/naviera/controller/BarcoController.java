package com.ejemplo.naviera.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ejemplo.naviera.model.Barco;
import com.ejemplo.naviera.model.TipoBarco;
import com.ejemplo.naviera.service.IBarcoService;

import jakarta.validation.Valid;

@Controller
public class BarcoController {

	@Autowired
	@Qualifier("barcoServiceImpl")
	private IBarcoService barcoService;

	@GetMapping("/barcos")
	public String tablaBarcos(Model m,
			@RequestParam(defaultValue = "false") boolean soloEnServicio,
			@RequestParam(required = false) TipoBarco tipo) {
		m.addAttribute("listaBarcos", barcoService.dameFiltrados(tipo, soloEnServicio));
		m.addAttribute("tipos", TipoBarco.values());
		m.addAttribute("tipoElegido", tipo);
		m.addAttribute("soloEnServicio", soloEnServicio);
		return "barco/lista";
	}

	@GetMapping("/barcos/{id}")
	public String tablaBarcos(Model m, @PathVariable int id) {
		m.addAttribute("barco", barcoService.damePorId(id));
		return "barco/ficha";
	}

	@PostMapping("/barcos/borrar/{id}")
	public String borrarBarcoPorId(@PathVariable int id) {
		barcoService.borrarPorId(id);
		return "redirect:/barcos";
	}

	@GetMapping("/barcos/nuevo")
	public String nuevoBarco(Model m) {
		m.addAttribute("barco", new Barco());
		m.addAttribute("tipos", TipoBarco.values());
		return "barco/form";
	}

	@PostMapping("/barcos/guardar")
	public String guardarBarco(@Valid @ModelAttribute Barco barco, BindingResult resultado, Model m) {
		if (resultado.hasErrors()) {
			m.addAttribute("tipos", TipoBarco.values());
			return "barco/form";
		}
		barcoService.guardar(barco);
		return "redirect:/barcos";
	}

	@GetMapping("/barcos/editar/{id}")
	public String editarBarco(@PathVariable int id, Model m) {
		m.addAttribute("barco", barcoService.damePorId(id));
		m.addAttribute("tipos", TipoBarco.values());

		return "barco/form";
	}
}
