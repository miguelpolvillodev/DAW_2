package com.unaempresa.segundoproyecto.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unaempresa.segundoproyecto.model.Libro;

@Controller
@RequestMapping("/libros")
public class LibroController {

	public List<Libro> listaLibros = importarLibros();

	public List<Libro> importarLibros() {
		List<Libro> listaImportada = new ArrayList<>();
		listaImportada.add(new Libro("Don Quijote de la Mancha", "Miguel de Cervantes", 5, "Novela"));
		listaImportada.add(new Libro("Cien años de soledad", "Gabriel García Márquez", 4, "Realismo mágico"));
		listaImportada.add(new Libro("La sombra del viento", "Carlos Ruiz Zafón", 6, "Misterio"));
		listaImportada.add(new Libro("1984", "George Orwell", 3, "Ciencia ficción"));
		listaImportada.add(new Libro("Un mundo feliz", "Aldous Huxley", 2, "Ciencia ficción"));
		listaImportada.add(new Libro("El señor de los anillos", "J.R.R. Tolkien", 7, "Fantasía"));
		listaImportada.add(new Libro("El hobbit", "J.R.R. Tolkien", 4, "Fantasía"));
		listaImportada.add(new Libro("Harry Potter y la piedra filosofal", "J.K. Rowling", 8, "Fantasía"));
		listaImportada.add(new Libro("Orgullo y prejuicio", "Jane Austen", 3, "Romántica"));
		listaImportada.add(new Libro("Crimen y castigo", "Fiódor Dostoyevski", 2, "Novela"));
		listaImportada.add(new Libro("El nombre de la rosa", "Umberto Eco", 3, "Misterio"));
		listaImportada.add(new Libro("Asesinato en el Orient Express", "Agatha Christie", 5, "Misterio"));
		listaImportada.add(new Libro("Dune", "Frank Herbert", 4, "Ciencia ficción"));
		listaImportada.add(new Libro("Fahrenheit 451", "Ray Bradbury", 3, "Ciencia ficción"));
		listaImportada.add(new Libro("La casa de los espíritus", "Isabel Allende", 2, "Realismo mágico"));
		listaImportada.add(new Libro("El principito", "Antoine de Saint-Exupéry", 6, "Infantil"));
		listaImportada.add(new Libro("Matilda", "Roald Dahl", 4, "Infantil"));
		listaImportada.add(new Libro("Drácula", "Bram Stoker", 2, "Terror"));
		listaImportada.add(new Libro("Frankenstein", "Mary Shelley", 3, "Terror"));
		listaImportada.add(new Libro("It", "Stephen King", 5, "Terror"));
		listaImportada.add(new Libro("Sapiens", "Yuval Noah Harari", 4, "Ensayo"));
		listaImportada.add(new Libro("El arte de la guerra", "Sun Tzu", 3, "Ensayo"));
		listaImportada.add(new Libro("La ciudad y los perros", "Mario Vargas Llosa", 2, "Novela"));
		listaImportada.add(new Libro("Patria", "Fernando Aramburu", 3, "Novela"));
		listaImportada.add(new Libro("Juego de tronos", "George R.R. Martin", 6, "Fantasía"));
		return listaImportada;
	}

	public List<Libro> filtroPorGenero(String genero) {
		List<Libro> librosFiltrados = new ArrayList<>();
		for (Libro l : listaLibros) {
			if (l.getGenero().equals(genero)) {
				librosFiltrados.add(l);
			}
		}
		return librosFiltrados;
	}

	public Libro filtroPorId(Integer id) {

		for (Libro l : listaLibros) {
			if (l.getId().equals(id)) {
				return l;
			}
		}
		return null;
	}

	@GetMapping("/lista")
	public String mostrarTodos(Model model) {
		model.addAttribute("listaLibros", listaLibros);
		return "listaLibros";
	}

	@GetMapping("/genero/{genero}")
	public String filtroGenero(Model model, @PathVariable String genero) {
		model.addAttribute("librosFiltrados", filtroPorGenero(genero));
		model.addAttribute("generoInsertado", genero);
		return "filtroGenero";
	}

	@GetMapping("/id/{id}")
	public String filtroId(Model model, @PathVariable Integer id) {
		Libro libro = filtroPorId(id);
	    model.addAttribute("libro", libro);
	    model.addAttribute("idBuscado", id);
	    if (libro != null) {
	        model.addAttribute("libroNombre", libro.getTitulo());
	    }
	    return "detalleLibro";
	}
}
