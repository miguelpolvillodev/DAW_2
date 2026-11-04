package com.unaempresa.servicios.service;

import java.util.List;

import com.unaempresa.servicios.model.Animal;

public interface IAnimalService {

	List<Animal> dameTodos();

	Animal damePorId(int id);

	List<Animal> dameFiltrados(String tipo, boolean soloOferta);

	List<String> dameTipos();

	boolean borrarPorId(int id);

	Animal guardar(Animal animal);

}
