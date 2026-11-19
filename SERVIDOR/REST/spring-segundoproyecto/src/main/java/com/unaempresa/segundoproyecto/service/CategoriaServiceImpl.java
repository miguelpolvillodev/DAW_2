package com.unaempresa.segundoproyecto.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unaempresa.segundoproyecto.entity.Categoria;
import com.unaempresa.segundoproyecto.entity.Producto;
import com.unaempresa.segundoproyecto.exception.CategoriaNoEncontradoException;
import com.unaempresa.segundoproyecto.repository.ICategoriaRepository;

@Service
@Transactional(readOnly = true)
public class CategoriaServiceImpl implements ICategoriaService {

    private final ICategoriaRepository categoriaRepository;

    public CategoriaServiceImpl(ICategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    @Override
    public Page<Categoria> findAllPaginado(Pageable pageable) {
        return categoriaRepository.findAll(pageable);
    }

    @Override
    public Categoria findById(Long id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new CategoriaNoEncontradoException(id));
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        categoriaRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public List<Categoria> findByNombre(String nombre) {
        return categoriaRepository.findByNombreContainingIgnoreCase(nombre);
    }

    @Override
    public List<Producto> findProductosByCategoria(Long categoriaId) {
        return categoriaRepository.findProductosByCategoriaId(categoriaId);
    }
}
