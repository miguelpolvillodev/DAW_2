package com.ejemplo.animales.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ejemplo.animales.model.Animal;
import com.ejemplo.animales.service.IAnimalService;

@Controller
@RequestMapping("/animal")
public class AnimalController {

	private final IAnimalService animalService;

	// Con un solo constructor, Spring inyecta el servicio sin @Autowired.
	// Se declara con la interfaz, no con la implementación.
	public AnimalController(IAnimalService animalService) {
		this.animalService = animalService;
	}

	// Se ejecuta antes de cada petición del controlador: el título llega a sus vistas.
	@ModelAttribute(name = "titulo")
	public String titulo() {
		return "Tienda de animales";
	}

	// Los filtros llegan en la dirección: /animal/todos?tipo=Ave&soloOferta=true
	// required = false deja entrar sin tipo; defaultValue da valor a la casilla.
	@GetMapping("/todos")
	public String todos(Model model, @RequestParam(required = false) String tipo,
			@RequestParam(defaultValue = "false") boolean soloOferta) {
		model.addAttribute("animales", animalService.dameFiltrados(tipo, soloOferta));
		model.addAttribute("tipos", animalService.dameTipos());
		model.addAttribute("tipo", tipo);
		model.addAttribute("soloOferta", soloOferta);
		return "animal/lista";
	}

	// {id} es una parte variable de la ruta: @PathVariable la recoge en el parámetro.
	@GetMapping("/id/{id}")
	public String unoPorId(Model model, @PathVariable int id) {
		model.addAttribute("animal", animalService.damePorId(id));
		return "animal/un-animal";
	}

	// redirect: no pinta una vista, pide al navegador que vaya a otra dirección.
	@GetMapping("/borrar/{id}")
	public String borrarPorId(@PathVariable int id) {
		animalService.borrarPorId(id);
		return "redirect:/animal/todos";
	}

	// Muestra el formulario con un animal vacío (id = 0) para rellenar.
	@GetMapping("/nuevo")
	public String nuevoFormulario(Model model) {
		model.addAttribute("subtitulo", "Nuevo animal");
		model.addAttribute("boton", "Crear animal");
		model.addAttribute("animal", new Animal());
		return "animal/formulario";
	}

	// Muestra el formulario con los datos del animal que se va a editar.
	// Si no existe, vuelve a la lista.
	@GetMapping("/editar/{id}")
	public String editarFormulario(Model model, @PathVariable int id) {
		Animal animal = animalService.damePorId(id);
		if (animal == null) {
			return "redirect:/animal/todos";
		}
		model.addAttribute("subtitulo", "Editar animal");
		model.addAttribute("boton", "Guardar cambios");
		model.addAttribute("animal", animal);
		return "animal/formulario";
	}

	// Recibe los datos del formulario en un Animal y lo guarda:
	// con id = 0 lo crea; con otro id, actualiza el que ya existe
	// (si no existe, no hace nada).
	@PostMapping("/guardar")
	public String guardar(@ModelAttribute Animal animal) {
		animalService.guardar(animal);
		return "redirect:/animal/todos";
	}

}
