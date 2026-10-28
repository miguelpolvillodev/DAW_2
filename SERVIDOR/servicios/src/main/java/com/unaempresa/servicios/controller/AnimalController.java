package com.unaempresa.servicios.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sun.net.httpserver.Authenticator.Result;
import com.unaempresa.servicios.model.Animal;
import com.unaempresa.servicios.services.AnimalServiceImpl;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/animal")
public class AnimalController {
	
	@Autowired
	private AnimalServiceImpl animalService;
	

	@GetMapping("/todos")
	public String todosAnimales(Model modelo) {
		modelo.addAttribute("todosAnimales", animalService.obtenerTodosAnimales());
		return "animal/animales";
	}
	
	@GetMapping("id/{id}")
	public String animalPorId(Model modelo, @PathVariable int id) {
		Animal encontrado = animalService.obtenerPorId(id);
		modelo.addAttribute("animal", encontrado );
		return "animal/unAnimal";
	}
	
	@GetMapping("/borrar/{id}")
	public String borrarPorId(@PathVariable int id) {
		animalService.borrarPorId(id);
		return "redirect:/animal/todos";
	}
	
	@GetMapping("/crear")
	public String crearAnimal(Model model) {
		model.addAttribute("animal", new Animal());
		return "animal/registrarAnimal";
	}

	@GetMapping("/editar/{id}")
	public String editarAnimal(Model model, @PathVariable int id) {
		model.addAttribute("animal", animalService.obtenerPorId(id));
		return "animal/registrarAnimal";
	}

	@PostMapping("/guardar")
	public String guardarAnimal(@Valid Animal animal, BindingResult result) {
		if(result.hasErrors()) {
			return "animal/registrarAnimal";
		}
		animalService.saveAnimal(animal);
		return "redirect:/animal/todos";
	}
	
}
