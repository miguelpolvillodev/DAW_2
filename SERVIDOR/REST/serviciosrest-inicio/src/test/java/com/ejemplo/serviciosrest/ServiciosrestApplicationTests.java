package com.ejemplo.serviciosrest;

import static org.assertj.core.api.Assertions.assertThat;

import com.ejemplo.serviciosrest.entity.Cliente;
import com.ejemplo.serviciosrest.repository.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

@DataJpaTest
class ServiciosrestApplicationTests {

	@Autowired
	private ClienteRepository clienteRepository;

	@Test
	void importSqlCargaDiezClientes() {
		assertThat(clienteRepository.findAll()).hasSize(10);
	}

	@Test
	void guardarYRecuperarUnCliente() {
		Cliente guardado = clienteRepository.save(
				Cliente.builder().nombre("Nuevo Cliente").email("nuevo@example.com").telefono("611000111").build());

		assertThat(guardado.getId()).isNotNull();
		Cliente recuperado = clienteRepository.findById(guardado.getId()).orElseThrow();
		assertThat(recuperado.getNombre()).isEqualTo("Nuevo Cliente");
	}

	@Test
	void buscarUnClienteQueNoExisteDaVacio() {
		assertThat(clienteRepository.findById(999999L)).isEmpty();
	}
}
