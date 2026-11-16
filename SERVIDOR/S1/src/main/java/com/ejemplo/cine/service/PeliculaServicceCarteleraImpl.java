package com.ejemplo.cine.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ejemplo.cine.model.Genero;
import com.ejemplo.cine.model.Pelicula;
import com.ejemplo.cine.repository.PeliculaRepository;

public class PeliculaServicceCarteleraImpl implements IPeliculaService {

	
	@Autowired
	private PeliculaRepository peliculaRepository;

	//Filtra por las que estan en cartelera
	@Override
	public List<Pelicula> dameTodas() {
		return peliculaRepository.findByEnCarteleraTrue();
	}

	@Override
	public Pelicula damePorId(Integer id) {
		return peliculaRepository.findById(null).orElse(null);
	}

	@Override
	public void guardar(Pelicula p) {
		peliculaRepository.save(p);
		
	}

	@Override
	public void borrarPorId(Integer id) {
		peliculaRepository.deleteById(id);
		
	}

	@Override
	public List<Pelicula> dameFiltradas(Genero genero, boolean soloCartelera) {
		if(genero == null && !soloCartelera) {
			return peliculaRepository.findAll();
		}
		if (genero == null) {
			return peliculaRepository.findByEnCarteleraTrue();
		}
		if(!soloCartelera) {
			return peliculaRepository.findByGenero(genero);
		}
		
		return peliculaRepository.findByGeneroAndEnCarteleraTrue(genero);
	}

}
