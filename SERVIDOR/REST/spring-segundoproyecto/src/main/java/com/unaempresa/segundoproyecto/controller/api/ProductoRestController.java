package com.unaempresa.segundoproyecto.controller.api;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.unaempresa.segundoproyecto.dto.ProductoRequestDto;
import com.unaempresa.segundoproyecto.dto.ProductoResponseDto;
import com.unaempresa.segundoproyecto.entity.Producto;
import com.unaempresa.segundoproyecto.service.IProductoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/productos")
public class ProductoRestController {

    private final IProductoService productoService;

    public ProductoRestController(IProductoService productoService) {
        this.productoService = productoService;
    }

    private ProductoResponseDto toDto(Producto p) {
        return ProductoResponseDto.builder()
            .id(p.getId())
            .nombre(p.getNombre())
            .precio(p.getPrecio())
            .build();
    }

    @GetMapping
    public ResponseEntity<List<ProductoResponseDto>> listar() {
        List<ProductoResponseDto> dtos = productoService.findAll().stream()
            .map(this::toDto)
            .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoResponseDto> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(toDto(productoService.findById(id)));
    }

    @PostMapping
    public ResponseEntity<ProductoResponseDto> crear(@Valid @RequestBody ProductoRequestDto dto) {
        Producto nuevo = Producto.builder()
            .nombre(dto.getNombre())
            .precio(dto.getPrecio())
            .build();
        Producto guardado = productoService.save(nuevo);
        URI location = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(guardado.getId())
            .toUri();
        return ResponseEntity.created(location).body(toDto(guardado));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductoResponseDto> actualizar(
            @PathVariable Long id,
            @Valid @RequestBody ProductoRequestDto dto) {
        Producto existente = productoService.findById(id);
        existente.setNombre(dto.getNombre());
        existente.setPrecio(dto.getPrecio());
        return ResponseEntity.ok(toDto(productoService.save(existente)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        productoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
