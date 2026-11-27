package com.ejemplo.libreria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ejemplo.libreria.model.Categoria;
import com.ejemplo.libreria.model.Libro;

public interface LibroRepository extends JpaRepository<Libro, Integer> {

	List<Libro> findByCategoria(Categoria categoria);
	List<Libro> findByEsNovedadTrue();
	List<Libro> findByCategoriaAndEsNovedadTrue(Categoria categoria);
}
