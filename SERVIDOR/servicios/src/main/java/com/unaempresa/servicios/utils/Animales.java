package com.unaempresa.servicios.utils;

import java.util.ArrayList;
import java.util.List;

import com.unaempresa.servicios.model.Animal;

public class Animales {

	private static List<Animal> listaAnimales = importarAnimales();
	
	private static List<Animal> importarAnimales(){
		List<Animal> animales = new ArrayList<>();

		animales.add(new Animal("Perro", 12, 350.00, "Mamífero", false));
		animales.add(new Animal("Gato", 15, 200.00, "Mamífero", true));
		animales.add(new Animal("Conejo", 20, 45.50, "Mamífero", false));
		animales.add(new Animal("Hámster", 30, 12.99, "Mamífero", true));
		animales.add(new Animal("Cobaya", 18, 25.00, "Mamífero", false));
		animales.add(new Animal("Loro", 6, 480.00, "Ave", false));
		animales.add(new Animal("Canario", 25, 35.00, "Ave", true));
		animales.add(new Animal("Periquito", 40, 18.50, "Ave", false));
		animales.add(new Animal("Agaporni", 14, 60.00, "Ave", true));
		animales.add(new Animal("Cacatúa", 3, 900.00, "Ave", false));
		animales.add(new Animal("Tortuga", 10, 75.00, "Reptil", false));
		animales.add(new Animal("Iguana", 5, 120.00, "Reptil", true));
		animales.add(new Animal("Gecko", 9, 85.00, "Reptil", false));
		animales.add(new Animal("Pitón", 4, 250.00, "Reptil", true));
		animales.add(new Animal("Camaleón", 3, 190.00, "Reptil", false));
		animales.add(new Animal("Pez payaso", 50, 22.00, "Pez", true));
		animales.add(new Animal("Pez dorado", 60, 4.50, "Pez", false));
		animales.add(new Animal("Betta", 35, 9.99, "Pez", true));
		animales.add(new Animal("Rana arborícola", 8, 40.00, "Anfibio", false));
		animales.add(new Animal("Axolotl", 7, 55.00, "Anfibio", true));
		
		return animales;
	}

	public static List<Animal> getListaAnimales() {
		return listaAnimales;
	}

}
