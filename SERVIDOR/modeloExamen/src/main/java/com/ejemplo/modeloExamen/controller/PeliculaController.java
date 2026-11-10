package com.ejemplo.modeloExamen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ejemplo.modeloExamen.service.IPeliculaService;

@RequestMapping("/peliculas")
@Controller
public class PeliculaController {
	
	@Autowired
	@Qualifier("peliculaServiceImpl")
	IPeliculaService peliculaService;

	@GetMapping
	public String motrarPeliculas(Model m) {
		m.addAttribute("listaPelis", peliculaService.dameTodas());
		return "pelicula/peliculas";
	}
	
	@GetMapping("/{id}")
	public String dameUnaPeli(Model m, @PathVariable Integer id) {
		m.addAttribute("peli", peliculaService.damePorId(id));
		return "pelicula/ficha-peli";
	}
}
