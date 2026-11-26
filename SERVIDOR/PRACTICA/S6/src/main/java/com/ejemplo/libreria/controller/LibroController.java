package com.ejemplo.libreria.controller;

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

import com.ejemplo.libreria.model.Categoria;
import com.ejemplo.libreria.model.Libro;
import com.ejemplo.libreria.service.ILibroService;

import jakarta.validation.Valid;

@Controller
public class LibroController {

	@Autowired
	@Qualifier("libroServiceImpl")
	private ILibroService libroService;

	@GetMapping("/libros")
	public String listaLibros(Model m, 
			@RequestParam(required = false) Categoria categoria,
			@RequestParam(defaultValue = "false") boolean soloNovedades) {
		
		m.addAttribute("listaLibros", libroService.dameFiltrados(categoria, soloNovedades));
		m.addAttribute("categorias", Categoria.values());
		m.addAttribute("categoriaElegida", categoria);
		m.addAttribute("soloNovedades", soloNovedades);
		return "libro/lista";
	}

	@GetMapping("/libros/{id}")
	public String fichaLibro(Model m, @PathVariable int id) {
		m.addAttribute("libro", libroService.damePorId(id));
		return "libro/ficha";
	}

	@PostMapping("/libros/borrar/{id}")
	public String borrarLibro(@PathVariable int id) {
		libroService.borrarPorId(id);
		return "redirect:/libros";
	}

	@PostMapping("/libros/guardar")
	public String crearLibro(@Valid @ModelAttribute Libro libro, BindingResult resultado, Model m) {
		if (resultado.hasErrors()) {
			m.addAttribute("categorias", Categoria.values());
			return "libro/form";
		}

		libroService.guardar(libro);
		return "redirect:/libros";
	}

	@GetMapping("/libros/nuevo")
	public String guardarLibro(Model m) {
		m.addAttribute("libro", new Libro());
		m.addAttribute("categorias", Categoria.values());

		return "libro/form";
	}
	
	@GetMapping("/libros/editar/{id}")
	public String editarLibro(@PathVariable int id, Model m) {
		m.addAttribute("libro", libroService.damePorId(id));
		m.addAttribute("categorias", Categoria.values());
		return "libro/form";
	}

}
