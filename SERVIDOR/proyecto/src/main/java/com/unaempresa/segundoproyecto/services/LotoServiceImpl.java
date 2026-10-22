package com.unaempresa.segundoproyecto.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.unaempresa.segundoproyecto.model.Loto;

@Service("lotoService")
public class LotoServiceImpl implements ILotoService{

	@Override
	public List<Loto> importarLotos() {
		List<Loto> ts = new ArrayList<>();

		ts.add(new Loto("España", 49, 6));
		ts.add(new Loto("Alemania", 49, 6));
		ts.add(new Loto("Francia", 90, 6));
		ts.add(new Loto("Italia", 49, 5));

		return ts;
	}
	
	@Override
	public List<Integer> generarCombinacion(int max, int cantidad) {
		Random random = new Random();
		List<Integer> combinacion = new ArrayList<>();

		while (combinacion.size() < cantidad) {
			int numero = random.nextInt(1,max);
			if (!combinacion.contains(numero)) {
				combinacion.add(numero);
			}
		}
		Collections.sort(combinacion);
		return combinacion;
	}
}
