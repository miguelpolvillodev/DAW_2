package com.ejemplo.cine.controller;

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

import com.ejemplo.cine.model.Genero;
import com.ejemplo.cine.model.Pelicula;
import com.ejemplo.cine.service.IPeliculaService;

import jakarta.validation.Valid;

@Controller
public class PeliculaController {

	@Autowired
	@Qualifier("peliculaServiceImpl")
	private IPeliculaService peliculaService;

	@GetMapping("/peliculas")
	public String lista(Model model,
			@RequestParam(required = false) Genero genero,
			@RequestParam(defaultValue = "false") boolean soloCartelera) {
		model.addAttribute("listaPeliculas", peliculaService.dameFiltradas(genero, soloCartelera));
		model.addAttribute("generos", Genero.values());
		model.addAttribute("generoElegido", genero);
		model.addAttribute("soloCartelera", soloCartelera);
		return "pelicula/lista";
	}

	@GetMapping("/peliculas/{id}")
	public String ficha(@PathVariable int id, Model model) {
		model.addAttribute("pelicula", peliculaService.damePorId(id));
		return "pelicula/ficha";
	}

	@PostMapping("/peliculas/borrar/{id}")
	public String borrar(@PathVariable int id) {
		peliculaService.borrarPorId(id);
		return "redirect:/peliculas";
	}

	@GetMapping("/peliculas/nueva")
	public String nueva(Model model) {
		model.addAttribute("pelicula", new Pelicula());
		model.addAttribute("generos", Genero.values());
		return "pelicula/formulario";
	}

	@GetMapping("/peliculas/editar/{id}")
	public String editar(@PathVariable int id, Model model) {
		model.addAttribute("pelicula", peliculaService.damePorId(id));
		model.addAttribute("generos", Genero.values());
		return "peliculas/form";
	}

	@PostMapping("/peliculas/guardar")
	public String guardar(@Valid @ModelAttribute("pelicula") Pelicula pelicula, BindingResult resultado, Model model) {
		if (resultado.hasErrors()) {
			model.addAttribute("generos", Genero.values());
			return "peliculas/form";
		}
		peliculaService.guardar(pelicula);
		return "redirect:/peliculas";
	}

}
