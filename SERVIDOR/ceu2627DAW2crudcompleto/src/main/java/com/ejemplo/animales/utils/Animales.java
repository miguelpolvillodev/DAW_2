package com.ejemplo.animales.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.ejemplo.animales.model.Animal;

public class Animales {

	// Animales con los que arranca la aplicación.
	private static final List<Animal> INICIALES = List.of(
			new Animal("Perro", 5, 150.0, "Mamífero", false),
			new Animal("Gato", 8, 90.0, "Mamífero", true),
			new Animal("Conejo", 12, 35.5, "Mamífero", false),
			new Animal("Hámster", 20, 12.0, "Mamífero", true),
			new Animal("Periquito", 15, 25.0, "Ave", false),
			new Animal("Canario", 10, 30.0, "Ave", true),
			new Animal("Pez payaso", 30, 18.5, "Pez", false),
			new Animal("Pez dorado", 50, 4.0, "Pez", true),
			new Animal("Tortuga", 6, 45.0, "Reptil", false),
			new Animal("Iguana", 3, 120.0, "Reptil", false));

	// Lista con la que se trabaja: empieza con los iniciales y cambia al guardar o borrar.
	private static final List<Animal> animales = new ArrayList<>(INICIALES);

	// Constructor privado: no hace falta crear objetos Animales, todo son métodos estáticos.
	private Animales() {
	}

	// Lista de solo lectura: desde fuera no se puede añadir ni quitar nada, solo con save y borrarPorId.
	public static List<Animal> dameTodos() {
		return Collections.unmodifiableList(animales);
	}

	// Devuelve el animal con ese id, o null si no existe.
	public static Animal damePorId(int id) {
		for (Animal animal : animales) {
			if (animal.getId() == id) {
				return animal;
			}
		}
		return null;
	}

	// Animales que cumplen los dos filtros: el tipo (null o vacío = cualquiera)
	// y, si se pide, solo los que están en oferta.
	public static List<Animal> dameFiltrados(String tipo, boolean soloOferta) {
		List<Animal> filtrados = new ArrayList<>();
		for (Animal animal : animales) {
			boolean tipoVale = tipo == null || tipo.isEmpty() || tipo.equals(animal.getTipo());
			boolean ofertaVale = !soloOferta || animal.isOferta();
			if (tipoVale && ofertaVale) {
				filtrados.add(animal);
			}
		}
		return filtrados;
	}

	// Los tipos que hay, sin repetir: son las opciones del desplegable del filtro.
	public static List<String> dameTipos() {
		List<String> tipos = new ArrayList<>();
		for (Animal animal : animales) {
			if (!tipos.contains(animal.getTipo())) {
				tipos.add(animal.getTipo());
			}
		}
		return tipos;
	}

	// Borra el animal con ese id. Devuelve true si existía.
	public static boolean borrarPorId(int id) {
		Animal animal = damePorId(id);
		return animal != null && animales.remove(animal);
	}

	// Con id = 0 es un animal nuevo: se crea con el constructor (que le da su id) y se añade.
	// Con otro id, se actualizan los datos del animal que ya existe (null si no existe).
	public static Animal save(Animal datos) {
		if (datos == null) {
			return null;
		}
		if (datos.getId() == 0) {
			Animal nuevo = new Animal(datos.getEspecie(), datos.getCantidad(), datos.getPrecio(),
					datos.getTipo(), datos.isOferta());
			animales.add(nuevo);
			return nuevo;
		}
		Animal existente = damePorId(datos.getId());
		if (existente == null) {
			return null;
		}
		existente.setEspecie(datos.getEspecie());
		existente.setCantidad(datos.getCantidad());
		existente.setPrecio(datos.getPrecio());
		existente.setTipo(datos.getTipo());
		existente.setOferta(datos.isOferta());
		return existente;
	}

}
