package com.ejemplo.puerto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejemplo.puerto.model.Barco;
import com.ejemplo.puerto.model.TipoBarco;
import com.ejemplo.puerto.repository.BarcoRepository;

@Service
public class BarcoServiceImpl implements IBarcoService {

	@Autowired
	private BarcoRepository barcoRepository;

	@Override
	public List<Barco> dameTodos() {
		return barcoRepository.findAll();
	}

	@Override
	public Barco damePorId(int id) {
		return barcoRepository.findById(id).orElse(null);
	}

	@Override
	public void guardar(Barco b) {
		barcoRepository.save(b);

	}

	@Override
	public void borrarPorId(int id) {
		barcoRepository.deleteById(id);

	}

	@Override
	public List<Barco> dameFiltrados(TipoBarco tipo, boolean enPuerto) {
		if (tipo == null && !enPuerto) {
			return barcoRepository.findAll();
		}

		if (tipo == null) {
			return barcoRepository.findByEnPuertoTrue();
		}

		if (!enPuerto) {
			return barcoRepository.findByTipo(tipo);
		}
		return barcoRepository.findByEnPuertoTrueAndTipo(tipo);
	}

}
