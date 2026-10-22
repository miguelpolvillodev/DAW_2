package com.unaempresa.segundoproyecto.services;

import java.util.List;


import com.unaempresa.segundoproyecto.model.Loto;

public interface ILotoService {

	public abstract List<Loto> importarLotos();
	public abstract List<Integer> generarCombinacion(int max, int cantidad);
}
