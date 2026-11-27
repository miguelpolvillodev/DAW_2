package com.ejemplo.libreria.service;

import java.util.List;

import com.ejemplo.libreria.model.Categoria;
import com.ejemplo.libreria.model.Libro;

public interface ILibroService {

	List<Libro> dameTodos();
	Libro damePorId(int id);
	void guardar(Libro l);
	void borrarPorId(int id);
	List<Libro> dameFiltrados(Categoria categoria, boolean soloNovedades);
}
