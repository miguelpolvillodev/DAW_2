package com.ejemplo.vehiculos;

import static org.assertj.core.api.Assertions.assertThat;

import com.ejemplo.vehiculos.entity.Vehiculo;
import com.ejemplo.vehiculos.repository.VehiculoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

@DataJpaTest
class VehiculosApplicationTests {

	@Autowired
	private VehiculoRepository vehiculoRepository;

	@Test
	void importSqlCargaDiezVehiculos() {
		assertThat(vehiculoRepository.findAll()).hasSize(10);
	}

	@Test
	void guardarYRecuperarUnVehiculo() {
		Vehiculo guardado = vehiculoRepository.save(
				Vehiculo.builder().marca("Mazda").modelo("3").matricula("1111 ABC").anio(2022).precio(19900.0).build());

		assertThat(guardado.getId()).isNotNull();
		Vehiculo recuperado = vehiculoRepository.findById(guardado.getId()).orElseThrow();
		assertThat(recuperado.getMarca()).isEqualTo("Mazda");
	}

	@Test
	void buscarUnVehiculoQueNoExisteDaVacio() {
		assertThat(vehiculoRepository.findById(999999L)).isEmpty();
	}
}
