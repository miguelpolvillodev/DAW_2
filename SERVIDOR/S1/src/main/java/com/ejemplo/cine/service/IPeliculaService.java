package com.ejemplo.cine.service;

import java.util.List;

import com.ejemplo.cine.model.Genero;
import com.ejemplo.cine.model.Pelicula;

public interface IPeliculaService {

	List<Pelicula> dameTodas();
	Pelicula damePorId(Integer id);
	void guardar(Pelicula p);
	void borrarPorId(Integer id);
	List<Pelicula> dameFiltradas(Genero genero, boolean soloCartelera);
}
