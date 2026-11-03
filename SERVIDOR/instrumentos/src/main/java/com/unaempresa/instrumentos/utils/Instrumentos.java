package com.unaempresa.instrumentos.utils;

import java.util.ArrayList;
import java.util.List;

import com.unaempresa.instrumentos.model.Familia;
import com.unaempresa.instrumentos.model.Instrumento;
import com.unaempresa.servicios.model.Animal;

public class Instrumentos {

	// Instrumentos con los que arranca la aplicación.
	private static final List<Instrumento> INICIALES = List.of(
			new Instrumento("Guitarra clásica Alhambra 4P", 6, 289.00, Familia.CUERDA, false),
			new Instrumento("Violín Stentor Student", 4, 175.50, Familia.CUERDA, true),
			new Instrumento("Bajo eléctrico Yamaha TRBX", 3, 420.00, Familia.CUERDA, false),
			new Instrumento("Flauta travesera Yamaha YFL-222", 5, 540.00, Familia.VIENTO, false),
			new Instrumento("Saxofón alto Selmer", 2, 1350.00, Familia.VIENTO, true),
			new Instrumento("Armónica Hohner Special 20", 25, 38.90, Familia.VIENTO, false),
			new Instrumento("Caja de batería Pearl 14", 4, 119.00, Familia.PERCUSION, true),
			new Instrumento("Cajón flamenco", 9, 95.00, Familia.PERCUSION, false),
			new Instrumento("Piano digital Casio CDP-S110", 3, 449.00, Familia.TECLADO, false),
			new Instrumento("Teclado Yamaha PSR-E373", 7, 239.00, Familia.TECLADO, true));

	// Lista con la que se trabaja: empieza con los iniciales y cambia al guardar o borrar.
	private static final List<Instrumento> instrumentos = new ArrayList<>(INICIALES);
	
	
	public static List<Instrumento> dameTodos() {
		return instrumentos;
	}
	
	public static Instrumento damePorId(long id) {
		for (Instrumento instrumento : instrumentos) {
			if(instrumento.getId() == id) {
				return instrumento;
			}
		}
		return null;
	}
	
	public static Instrumento save(Instrumento i) {
		if(i == null) {
			return null;
		}
		
		if(i.getId() == 0) {
			Instrumento nuevo = new Instrumento(i.getModelo(), i.getExistencias(), i.getPrecio(), i.getFamilia(), i.isUsado());
			instrumentos.add(nuevo);
			return nuevo;
		}
		Instrumento existente = damePorId(i.getId());
		if (existente == null) {
			return null;
		}
		existente.setExistencias(i.getExistencias());
		existente.setFamilia(i.getFamilia());
		existente.setModelo(i.getModelo());
		existente.setPrecio(i.getPrecio());
		existente.setUsado(i.isUsado());
		return existente;
	}
	
	public static void borrarPorId(long id) {
		Instrumento instrumento = damePorId(id); 
		if(instrumento != null) {
			instrumentos.remove(instrumento);
		}
	}
	
	public static List<Familia> dameTipos() {
		List<Familia> tipos = new ArrayList<>();
		for (Familia f : animales) {
			if (!tipos.contains(animal.getTipo())) {
				tipos.add(animal.getTipo());
			}
		}
		return tipos;
	}
}
