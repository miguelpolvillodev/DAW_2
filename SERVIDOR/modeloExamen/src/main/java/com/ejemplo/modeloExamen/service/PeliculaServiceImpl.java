package com.ejemplo.modeloExamen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.ejemplo.modeloExamen.model.Pelicula;
import com.ejemplo.modeloExamen.repository.PeliculaRepository;

@Service
public class PeliculaServiceImpl implements IPeliculaService{

	@Autowired
	protected PeliculaRepository peliculaRepository;
	
	@Override
	public List<Pelicula> dameTodas() {
		return peliculaRepository.findAll();
	}

	@Override
	public Pelicula damePorId(Integer id) {
		return peliculaRepository.findById(id).orElse(null);
	}

	@Override
	public void guardar(Pelicula p) {
		peliculaRepository.save(p);
		
	}

	@Override
	public void borrarPorId(Integer id) {
		peliculaRepository.deleteById(id);
		
	}

}
