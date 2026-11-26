package com.ejemplo.naviera.service;

import java.util.List;

import com.ejemplo.naviera.model.Barco;
import com.ejemplo.naviera.model.TipoBarco;

public interface IBarcoService {

	List<Barco> dameTodos();

	Barco damePorId(int id);

	void guardar(Barco b);

	void borrarPorId(int id);
	
	List<Barco> dameFiltrados(TipoBarco tipo, boolean soloServicio);
}
