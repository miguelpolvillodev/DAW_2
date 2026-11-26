package com.ejemplo.libreria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejemplo.libreria.model.Categoria;
import com.ejemplo.libreria.model.Libro;
import com.ejemplo.libreria.repository.LibroRepository;

@Service
public class LibroServiceImpl implements ILibroService {

	@Autowired
	private LibroRepository libroRepository;

	@Override
	public List<Libro> dameTodos() {
		return libroRepository.findAll();
	}

	@Override
	public Libro damePorId(int id) {
		return libroRepository.findById(id).orElse(null);
	}

	@Override
	public void guardar(Libro l) {
		libroRepository.save(l);

	}

	@Override
	public void borrarPorId(int id) {
		libroRepository.deleteById(id);

	}

	@Override
	public List<Libro> dameFiltrados(Categoria categoria, boolean soloNovedades) {
		if (categoria == null && !soloNovedades) {
			return libroRepository.findAll();
		}
		if (categoria == null) {
			return libroRepository.findByEsNovedadTrue();
		}
		if (!soloNovedades) {
			return libroRepository.findByCategoria(categoria);
		}
		return libroRepository.findByCategoriaAndEsNovedadTrue(categoria);
	}

}
