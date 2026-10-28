package com.unaempresa.servicios.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.unaempresa.servicios.model.Animal;
import com.unaempresa.servicios.utils.Animales;

@Service
public class AnimalServiceImpl implements IAnimalService {

	@Override
	public List<Animal> obtenerTodosAnimales() {
		List<Animal> listaAnimales = Animales.getListaAnimales();
		return listaAnimales;
	}

	@Override
	public Animal obtenerPorId(int id) {

		for (Animal a : Animales.getListaAnimales()) {
			if (a.getId() == id) {
				return a;
			}
		}
		return null;
	}

	@Override
	public void borrarPorId(int id) {
		List<Animal> lista = Animales.getListaAnimales();

		lista.removeIf(animal -> animal.getId() == id);

	}

	@Override
	public void saveAnimal(Animal a) {
	    Animal existente = obtenerPorId(a.getId());

	    if (existente == null) {
	        Animales.getListaAnimales().add(a);   // no existe: alta
	    } else {
	        int pos = Animales.getListaAnimales().indexOf(existente);
	        Animales.getListaAnimales().set(pos, a);   // existe: reemplazar
	    }
	}

}
