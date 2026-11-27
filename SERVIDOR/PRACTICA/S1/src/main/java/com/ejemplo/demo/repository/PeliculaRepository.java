package com.ejemplo.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ejemplo.demo.model.Genero;
import com.ejemplo.demo.model.Pelicula;

public interface PeliculaRepository extends JpaRepository<Pelicula, Integer>{	
	List<Pelicula> findByGenero(Genero genero);

	List<Pelicula> findByEnCarteleraTrue();

	List<Pelicula> findByGeneroAndEnCarteleraTrue(Genero genero);

}
