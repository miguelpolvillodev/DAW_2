package com.ejemplo.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejemplo.demo.model.Genero;
import com.ejemplo.demo.model.Pelicula;
import com.ejemplo.demo.repository.PeliculaRepository;

@Service
public class PeliculaServiceCarteleraImpl implements IPeliculaService {
	
	@Autowired
	private PeliculaRepository peliculaRepository;

	@Override
	public List<Pelicula> dameTodas() {
	List<Pelicula> enCartelera = new ArrayList<>();
	
	for (Pelicula p : peliculaRepository.findAll()) {
		if(p.isEnCartelera()) {
			enCartelera.add(p);
		}
	}
	
	return enCartelera;
	}

	@Override
	public Pelicula damePorId(int id) {
		return peliculaRepository.findById(id).orElse(null);
	}

	@Override
	public void guardar(Pelicula p) {
		peliculaRepository.save(p);
		
	}

	@Override
	public void borrarPorId(int id) {
		peliculaRepository.deleteById(id);
		
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
}
