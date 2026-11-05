package com.ejemplo.animales.service;

import java.util.List;
import java.util.Set;

import com.ejemplo.animales.model.Animal;

public interface IAnimalService {

	List<Animal> dameTodos();

	Animal damePorId(int id);

	List<Animal> dameFiltrados(String tipo, boolean soloOferta);

	Set<String> dameTipos();

	void borrarPorId(int id);

	Animal guardar(Animal animal);

}
