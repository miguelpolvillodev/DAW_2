package com.ejemplo.demo.service;

import java.util.List;

import com.ejemplo.demo.model.Genero;
import com.ejemplo.demo.model.Pelicula;

public interface IPeliculaService {
	
	List<Pelicula> dameTodas();
	List<Pelicula> dameFiltradas(Genero genero, boolean soloCartelera);

	Pelicula damePorId(int id);
	
	void guardar(Pelicula p);
	
	void borrarPorId(int id);
}
