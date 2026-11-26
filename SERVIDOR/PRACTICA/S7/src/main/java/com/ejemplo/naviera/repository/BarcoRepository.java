package com.ejemplo.naviera.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ejemplo.naviera.model.Barco;
import com.ejemplo.naviera.model.TipoBarco;

public interface BarcoRepository extends JpaRepository<Barco, Integer> {

	List<Barco> findByTipo(TipoBarco tipo);

	List<Barco> findByTipoAndEnServicioTrue(TipoBarco tipo);

	List<Barco> findByEnServicioTrue();
}
