package com.ejemplo.modeloExamen.service;

import java.util.List;


import com.ejemplo.modeloExamen.model.Pelicula;

public interface IPeliculaService {

	List<Pelicula> dameTodas();
	Pelicula damePorId(Integer id);
	void guardar(Pelicula p);
	void borrarPorId(Integer id);
}
