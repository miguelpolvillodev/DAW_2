package com.ejemplo.animales.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejemplo.animales.model.Animal;
import com.ejemplo.animales.repository.IAnimalRepository;


@Service
public class AnimalServiceImpl implements IAnimalService {

	@Autowired
	private IAnimalRepository animalRepository;

	@Override
	public List<Animal> dameTodos() {
		return animalRepository.findAll();
		
	}

	@Override
	public Animal damePorId(int id) {
		return animalRepository.findById(id).orElse(null);
		
	}

	@Override
	public List<Animal> dameFiltrados(String tipo, boolean soloOferta) {
		return animalRepository.findAllByTipoAndOferta(tipo, soloOferta);
		
	}

	@Override
	public Set<String> dameTipos() {
		List<Animal> todos = animalRepository.findAll();
		Set<String> tipos = new HashSet<>();
		for (Animal a : todos) {
			tipos.add(a.getTipo());
		}
		return tipos;
		
	}

	@Override
	public void borrarPorId(int id) {
		animalRepository.deleteById(id);
		
	}

	@Override
	public Animal guardar(Animal animal) {
		return animalRepository.save(animal);
		// return Animales.save(animal);
	}

}
