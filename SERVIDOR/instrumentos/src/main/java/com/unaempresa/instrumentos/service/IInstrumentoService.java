package com.unaempresa.instrumentos.service;

import java.util.List;

import com.unaempresa.instrumentos.model.Familia;
import com.unaempresa.instrumentos.model.Instrumento;

public interface IInstrumentoService {
	//Todos los instrumentos
	List<Instrumento> dameTodos();
	
	// 1 instrumento
	Instrumento damePorId(long id);
	
	//Crear nuevo / editar
	Instrumento save(Instrumento i);
	
	//Borrar
	void borrarPorId(long id);
	
	//Nombre sin repetir para poner en el filtro
	List<Familia> dameTipos();
	
	//Filtro por usados
	List<Instrumento> soloUsados();
}
