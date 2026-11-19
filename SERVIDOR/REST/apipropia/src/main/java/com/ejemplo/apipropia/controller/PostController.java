package com.ejemplo.apipropia.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplo.apipropia.dto.NuevoPostDto;
import com.ejemplo.apipropia.dto.PostDto;
import com.ejemplo.apipropia.service.PostService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<PostDto> listar() {
        return postService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDto> obtener(@PathVariable long id) {
        return postService.obtener(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PostDto> crear(@Valid @RequestBody NuevoPostDto nuevo) {
        PostDto creado = postService.crear(nuevo);
        return ResponseEntity.created(URI.create("/posts/" + creado.id())).body(creado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostDto> actualizar(@PathVariable long id, @Valid @RequestBody NuevoPostDto datos) {
        return postService.actualizar(id, datos)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable long id) {
        return postService.eliminar(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}
