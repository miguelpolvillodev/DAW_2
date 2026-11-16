package com.ejemplo.cine.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ejemplo.cine.model.Genero;
import com.ejemplo.cine.model.Pelicula;



public interface PeliculaRepository extends JpaRepository<Pelicula, Integer>{

	// FILTROS
	List<Pelicula> findByEnCarteleraTrue();
	List<Pelicula> findByGenero(Genero genero);
	List<Pelicula> findByGeneroAndEnCarteleraTrue(Genero genero);
}
