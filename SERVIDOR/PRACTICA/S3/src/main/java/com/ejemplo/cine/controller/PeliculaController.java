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
	public String listaPelis(Model m,
			@RequestParam (required = false)Genero genero  ,
			@RequestParam(defaultValue = "false") boolean soloCartelera) {
		m.addAttribute("listaPelis", peliculaService.dameFiltradas(genero, soloCartelera));
		m.addAttribute("generos", Genero.values());
		m.addAttribute("generoElegido", genero);
		m.addAttribute("soloCartelera", soloCartelera);
		return "pelicula/lista";
	}
	
	@GetMapping("/peliculas/{id}")
	public String listaPelis(Model m, @PathVariable int id) {
		m.addAttribute("pelicula", peliculaService.damePorId(id));
		return "pelicula/ficha";
	}
	
	@PostMapping("/peliculas/borrar/{id}")
	public String borrarPeliPorId(@PathVariable int id) {
		peliculaService.borrarPorId(id);
		return "redirect:/peliculas";
	}
	
	@GetMapping("/peliculas/nueva")
	public String crearPeli(Model m) {
		m.addAttribute("pelicula", new Pelicula());
		m.addAttribute("generos", Genero.values());
		return "pelicula/form";
	}
	
	@PostMapping("/peliculas/guardar")
	public String guardarPeli(@Valid @ModelAttribute Pelicula p, BindingResult resultado, Model m) {
		if(resultado.hasErrors()){
			m.addAttribute("generos", Genero.values());
			return "pelicula/form";
		}
		peliculaService.guardar(p);
		return "redirect:/peliculas";
	}
	
	@GetMapping("/peliculas/editar/{id}")
	public String editarPeli(@PathVariable int id, Model m) {
		m.addAttribute("pelicula", peliculaService.damePorId(id));
		m.addAttribute("generos", Genero.values());
		return "pelicula/form";
	}
}
