package com.ejemplo.puerto.service;

import java.util.List;

import com.ejemplo.puerto.model.Barco;
import com.ejemplo.puerto.model.TipoBarco;

public interface IBarcoService {

	List<Barco> dameTodos();
	Barco damePorId(int id);
	void guardar(Barco b);
	void borrarPorId(int id);
	List<Barco> dameFiltrados(TipoBarco tipo, boolean enPuerto);
}
