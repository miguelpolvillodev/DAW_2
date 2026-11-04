package com.unaempresa.instrumentos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.unaempresa.instrumentos.model.Familia;
import com.unaempresa.instrumentos.model.Instrumento;
import com.unaempresa.instrumentos.utils.Instrumentos;

@Service
public class InstrumentoServiceImpl implements IInstrumentoService {

	@Override
	public List<Instrumento> dameTodos() {
		return Instrumentos.dameTodos();
	}

	@Override
	public Instrumento damePorId(long id) {
		return Instrumentos.damePorId(id);
	}

	@Override
	public Instrumento save(Instrumento i) {
		return Instrumentos.save(i);
	}

	@Override
	public void borrarPorId(long id) {
		Instrumentos.borrarPorId(id);
		
	}

	@Override
	public List<Familia> dameTipos() {
		return Instrumentos.dameTipos();
	}

	@Override
	public List<Instrumento> soloUsados() {
		// TODO Auto-generated method stub
		return Instrumentos.soloUsados();
	}

}
