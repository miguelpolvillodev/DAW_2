package com.unaempresa.segundoproyecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unaempresa.segundoproyecto.entity.Categoria;
import com.unaempresa.segundoproyecto.entity.Producto;

@Repository
public interface ICategoriaRepository extends JpaRepository<Categoria, Long> {

    List<Categoria> findByNombreContainingIgnoreCase(String nombre);

    @Query("SELECT p FROM Producto p JOIN p.categorias c WHERE c.id = :categoriaId")
    List<Producto> findProductosByCategoriaId(@Param("categoriaId") Long categoriaId);
}
