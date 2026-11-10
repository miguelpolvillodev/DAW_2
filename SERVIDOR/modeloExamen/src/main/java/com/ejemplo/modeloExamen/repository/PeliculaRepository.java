package com.ejemplo.modeloExamen.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ejemplo.modeloExamen.model.Pelicula;

public interface PeliculaRepository extends JpaRepository<Pelicula, Integer>{

	List<Pelicula> findByEnCarteleraTrue();

	
	
}
