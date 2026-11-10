package com.ejemplo.modeloExamen.service;


import java.util.List;


import org.springframework.stereotype.Service;

import com.ejemplo.modeloExamen.model.Pelicula;


@Service
public class PeliculaServiceCarteleraImpl extends PeliculaServiceImpl {

	@Override
	public List<Pelicula> dameTodas() {
		return peliculaRepository.findByEnCarteleraTrue();
	}


}
