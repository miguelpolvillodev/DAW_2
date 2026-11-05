package com.unaempresa.instrumentos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unaempresa.instrumentos.model.Familia;
import com.unaempresa.instrumentos.model.Instrumento;
import com.unaempresa.instrumentos.service.IInstrumentoService;

@Controller
@RequestMapping("/instrumento")
public class InstrumentoController {

	@Autowired
	private IInstrumentoService instrumentoService;

	@GetMapping("/todos")
	public String dameTodos(Model model, Familia familia, boolean usado) {
		model.addAttribute("listaInstrumentos", instrumentoService.dameTodos());
		model.addAttribute("instrumentosUsados", instrumentoService.soloUsados());
		model.addAttribute("tipos", instrumentoService.dameTipos());
		model.addAttribute("tipo", familia);
		model.addAttribute("soloOferta", usado);
		return "instrumento/lista";
	}

	@GetMapping("/id/{id}")
	public String damePorId(Model model, @PathVariable long id) {
		model.addAttribute("instrumento", instrumentoService.damePorId(id));
		return "instrumento/un-instrumento";
	}
	
	@GetMapping("/borrar/{id}")
	public String borrarPorId(@PathVariable long id) {
		instrumentoService.borrarPorId(id);
		return "redirect:/instrumento/todos";
	}
	
	@GetMapping("/nuevo")
	public String crearInstrumento(Model model) {
		model.addAttribute("subtitulo", "Nuevo Instrumento");
		model.addAttribute("boton", "Crear Instrumento");
		model.addAttribute("animal", new Instrumento());
		return "instrumento/formulario";
	}
	
	@GetMapping("/editar/{id}")
	public String editarInstrumento(Model model, @PathVariable long id) {
		Instrumento i = instrumentoService.damePorId(id);
		if (i == null) {
			return "redirect:/instrumento/todos";
		}
		model.addAttribute("subtitulo", "Editar animal");
		model.addAttribute("boton", "Guardar cambios");
		model.addAttribute("animal", i);
		return "instrumento/formulario";
	}
	
	
	@PostMapping("/guardar")
	public String guardar(@ModelAttribute Instrumento animal) {
		instrumentoService.save(animal);
		return "redirect:/instrumento/todos";
	}
}
