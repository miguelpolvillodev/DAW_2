package com.ejemplo.animales.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.ejemplo.animales.model.Animal;

public interface IAnimalRepository extends JpaRepository<Animal, Integer> {

	List<String> findAllByTipo();

	List<Animal> findAllByTipoAndOferta(String tipo, boolean oferta);

	
}
