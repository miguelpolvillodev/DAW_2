package com.ejemplo.cine.services;

import java.util.List;

import com.ejemplo.cine.model.Genero;
import com.ejemplo.cine.model.Pelicula;

public interface IPeliculaService {

	List<Pelicula> dameTodas();
	Pelicula damePorId(int id);
	void guardar(Pelicula p);
	void borraroPorId(int id);
	List<Pelicula> dameFiltradas(Genero genero, boolean soloCartelera);
	
}
