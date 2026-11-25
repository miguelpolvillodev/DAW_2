package com.ejemplo.serviciosrest.repository;

import com.ejemplo.serviciosrest.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
