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
	    if (a.getId() == 0) {
	        a.setId(Animal.getNextId());
	        Animal.setNextId(Animal.getNextId() + 1);
	        Animales.getListaAnimales().add(a);
	    } else {
	        for (Animal an : Animales.getListaAnimales()) {
	            if (an.getId() == a.getId()) {
	                an.setCantidad(a.getCantidad());
	                an.setEspecie(a.getEspecie());
	                an.setOferta(a.isOferta());
	                an.setPrecio(a.getPrecio());
	                an.setTipo(a.getTipo());
	                break;
	            }
	        }
	    }
	}

}
