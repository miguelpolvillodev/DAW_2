package com.ejemplo.naviera.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejemplo.naviera.model.Barco;
import com.ejemplo.naviera.model.TipoBarco;
import com.ejemplo.naviera.repository.BarcoRepository;

@Service
public class BarcoServiceEnServicioImpl implements IBarcoService {

	@Autowired
	private BarcoRepository barcoRepository;

	@Override
	public List<Barco> dameTodos() {
		List<Barco> enServicio = new ArrayList<>();
		for (Barco b : barcoRepository.findAll()) {
			if (b.isEnServicio()) {
				enServicio.add(b);
			}
		}
		return enServicio;
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
	public List<Barco> dameFiltrados(TipoBarco tipo, boolean soloServicio) {
		if (tipo == null && !soloServicio) {
			return barcoRepository.findAll();
		}
		if (tipo == null) {
			return barcoRepository.findByEnServicioTrue();
		}
		if (!soloServicio) {
			return barcoRepository.findByTipo(tipo);
		}
		return barcoRepository.findByTipoAndEnServicioTrue(tipo);
	}
}
