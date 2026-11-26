package com.ejemplo.demo.controller;

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

import com.ejemplo.demo.model.Genero;
import com.ejemplo.demo.model.Pelicula;
import com.ejemplo.demo.service.IPeliculaService;

import jakarta.validation.Valid;

@Controller
public class PeliculaController {

	@Autowired
	@Qualifier("peliculaServiceImpl")
	private IPeliculaService peliculaService;

	@GetMapping("/peliculas")
	public String listado(Model m, @RequestParam(required = false) Genero genero,
									@RequestParam(defaultValue = "false") boolean soloCartelera) {
		m.addAttribute("listaPeliculas", peliculaService.dameFiltradas(genero, soloCartelera));
		m.addAttribute("generos", Genero.values());
		m.addAttribute("soloCartelera", soloCartelera);
		m.addAttribute("generoElegido", genero);
		return "peliculas/listado";
	}

	@GetMapping("/peliculas/{id}")
	public String dameUnaPeli(Model m, @PathVariable int id) {
		m.addAttribute("pelicula", peliculaService.damePorId(id));
		m.addAttribute("titulo", peliculaService.damePorId(id).getTitulo());
		return "peliculas/ficha";
	}

	@PostMapping("/peliculas/borrar/{id}")
	public String borrarUnaPeli(@PathVariable int id) {
		peliculaService.borrarPorId(id);
		return "redirect:/peliculas";
	}

	@GetMapping("peliculas/nueva")
	public String crearPeli(Model m) {
		m.addAttribute("pelicula", new Pelicula());
		m.addAttribute("generos", Genero.values());
		return "peliculas/form";
	}

	@PostMapping("peliculas/guardar")
	public String guardar(@Valid @ModelAttribute("pelicula") Pelicula pelicula, BindingResult resultado, Model m) {
		if (resultado.hasErrors()) {
			m.addAttribute("generos", Genero.values());
			return "peliculas/form";
		}
		peliculaService.guardar(pelicula);
		return "redirect:/peliculas";
	}

	@GetMapping("peliculas/editar/{id}")
	public String editarPeli(Model m, @PathVariable int id) {
		m.addAttribute("pelicula", peliculaService.damePorId(id));
		m.addAttribute("generos", Genero.values());
		return "peliculas/form";
	}

}
