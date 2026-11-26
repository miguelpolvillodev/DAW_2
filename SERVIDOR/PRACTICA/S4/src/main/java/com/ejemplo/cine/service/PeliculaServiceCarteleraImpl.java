package com.ejemplo.cine.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejemplo.cine.model.Genero;
import com.ejemplo.cine.model.Pelicula;
import com.ejemplo.cine.repository.PeliculaRepository;

@Service
public class PeliculaServiceCarteleraImpl implements IPeliculaService{

	@Autowired
	private PeliculaRepository peliculaRepository;
	
	
	@Override
	public List<Pelicula> dameTodas() {
		List<Pelicula> soloCartelera = new ArrayList<>();
		
		for (Pelicula p : peliculaRepository.findAll()) {
			if(p.isEnCartelera()) {
				soloCartelera.add(p);
			}
		}
		return soloCartelera;
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
	public List<Pelicula> dameFiltradas(Genero genero, boolean enCartelera) {
		if(genero == null && !enCartelera) {
			return peliculaRepository.findAll();
		}
		
		if(genero == null) {
			return peliculaRepository.findByEnCarteleraTrue();
		}
		
		if(!enCartelera) {
			return peliculaRepository.findByGenero(genero);
		}
		return peliculaRepository.findByGeneroAndEnCarteleraTrue(genero);
	}
}
