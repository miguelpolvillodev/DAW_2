package com.ejemplo.cine.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejemplo.cine.model.Genero;
import com.ejemplo.cine.model.Pelicula;
import com.ejemplo.cine.repository.PeliculaRepository;

@Service
public class PeliculaServiceImpl implements IPeliculaService {

	@Autowired
	private PeliculaRepository peliculaRepository;

	@Override
	public List<Pelicula> dameTodas() {
		return peliculaRepository.findAll();
	}

	@Override
	public Pelicula damePorId(int id) {
		return peliculaRepository.findById(id).orElse(null);
	}

	@Override
	public List<Pelicula> dameFiltradas(Genero genero, boolean soloCartelera) {
		if (genero == null && !soloCartelera) {
			return peliculaRepository.findAll();
		}
		if (genero == null) {
			return peliculaRepository.findByEnCarteleraTrue();
		}
		if (!soloCartelera) {
			return peliculaRepository.findByGenero(genero);
		}
		return peliculaRepository.findByGeneroAndEnCarteleraTrue(genero);
	}

	@Override
	public void borrarPorId(int id) {
		peliculaRepository.deleteById(id);
	}

	@Override
	public Pelicula guardar(Pelicula pelicula) {
		return peliculaRepository.save(pelicula);
	}

}
