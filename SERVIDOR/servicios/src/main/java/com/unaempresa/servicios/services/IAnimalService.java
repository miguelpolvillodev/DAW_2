package com.unaempresa.servicios.services;

import java.util.List;

import com.unaempresa.servicios.model.Animal;

public interface IAnimalService {

	public abstract List<Animal> obtenerTodosAnimales();
	public abstract Animal obtenerPorId(int id);
	public abstract void borrarPorId(int id);
	public abstract void saveAnimal(Animal a);
	
}
