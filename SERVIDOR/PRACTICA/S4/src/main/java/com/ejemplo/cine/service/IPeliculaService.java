package com.ejemplo.cine.service;

import java.util.List;

import com.ejemplo.cine.model.Genero;
import com.ejemplo.cine.model.Pelicula;

public interface IPeliculaService {

	List<Pelicula> dameTodas();
	Pelicula damePorId(int id);
	void guardar(Pelicula p);
	void borrarPorId(int id);
	List<Pelicula> dameFiltradas(Genero genero, boolean enCartelera);
}
