package com.ejemplo.cine.service;

import java.util.List;

import com.ejemplo.cine.model.Genero;
import com.ejemplo.cine.model.Pelicula;

public interface IPeliculaService {

	List<Pelicula> dameTodas();
	Pelicula damePorId(int id);
	List<Pelicula> dameFiltradas(Genero genero, boolean soloCartelera);
	void borrarPorId(int id);
	Pelicula guardar(Pelicula pelicula);

}
