package com.unaempresa.segundoproyecto.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unaempresa.segundoproyecto.model.Ciudad;

@Controller
@RequestMapping("/imagenes")
public class ImagenController {

	List<Ciudad> listaCiudades = importarCiudades();

	public List<Ciudad> importarCiudades() {
		List<Ciudad> listaImportada = new ArrayList<>();
		listaImportada.add(new Ciudad("Sevilla", "/img/sevilla.jpg"));
		listaImportada.add(new Ciudad("Madrid", "/img/madrid.jpg"));
		listaImportada.add(new Ciudad("Barcelona", "/img/barcelona.jpg"));
		listaImportada.add(new Ciudad("Valencia", "/img/valencia.jpg"));
		listaImportada.add(new Ciudad("Granada", "/img/granada.jpg"));

		return listaImportada;
	}

	public Ciudad generarCapital() {
		Random random = new Random();
		return listaCiudades.get(random.nextInt(listaCiudades.size()));

	}

	public List<Ciudad> opcionesQuiz(Ciudad correcta) {
		List<Ciudad> copia = new ArrayList<>(listaCiudades);
		Iterator<Ciudad> it = copia.iterator();

		while (it.hasNext()) {
			if (it.next().getId().equals(correcta.getId())) {
				it.remove();
			}
		}

		List<Ciudad> opciones = new ArrayList<>(copia.subList(0, 3));
		opciones.add(correcta);
		Collections.shuffle(opciones);

		return opciones;
	}

	public Ciudad buscarPorId(Integer id) {
		for (Ciudad c : listaCiudades) {
			if (c.getId().equals(id)) {
				return c;
			}
		}
		return null;
	}

	@GetMapping("/quiz")
	public String quiz(Model model) {

		Ciudad correcta = generarCapital();
		model.addAttribute("correcta", correcta);
		model.addAttribute("opciones", opcionesQuiz(correcta));
		return "quiz";
	}

	@GetMapping("/respuesta/{idFoto}/{idOpcion}")
	public String respuesta(Model model, @PathVariable Integer idFoto, @PathVariable Integer idOpcion) {
		model.addAttribute("acierto", idFoto.equals(idOpcion));
		model.addAttribute("correcta", buscarPorId(idFoto));
		return "respuesta";
	}
}
