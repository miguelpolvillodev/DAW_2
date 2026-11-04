package com.unaempresa.servicios.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.unaempresa.servicios.model.Animal;
import com.unaempresa.servicios.utils.Animales;

@Service
public class AnimalServiceImpl implements IAnimalService {

	@Override
	public List<Animal> dameTodos() {
		return Animales.dameTodos();
	}

	@Override
	public Animal damePorId(int id) {
		return Animales.damePorId(id);
	}

	@Override
	public List<Animal> dameFiltrados(String tipo, boolean soloOferta) {
		return Animales.dameFiltrados(tipo, soloOferta);
	}

	@Override
	public List<String> dameTipos() {
		return Animales.dameTipos();
	}

	@Override
	public boolean borrarPorId(int id) {
		return Animales.borrarPorId(id);
	}

	@Override
	public Animal guardar(Animal animal) {
		return Animales.save(animal);
	}

}
