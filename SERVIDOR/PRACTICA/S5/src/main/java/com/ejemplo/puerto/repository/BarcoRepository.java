package com.ejemplo.puerto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ejemplo.puerto.model.Barco;
import com.ejemplo.puerto.model.TipoBarco;

public interface BarcoRepository extends JpaRepository<Barco, Integer> {

	List<Barco> findByEnPuertoTrue();
	List<Barco> findByTipo(TipoBarco tipo);
	List<Barco> findByEnPuertoTrueAndTipo(TipoBarco tipo);
}
