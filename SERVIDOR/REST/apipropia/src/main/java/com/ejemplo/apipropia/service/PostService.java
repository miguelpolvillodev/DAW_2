package com.ejemplo.apipropia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ejemplo.apipropia.dto.NuevoPostDto;
import com.ejemplo.apipropia.dto.PostDto;
import com.ejemplo.apipropia.model.Post;
import com.ejemplo.apipropia.repository.PostRepository;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<PostDto> listar() {
        return postRepository.findAll().stream().map(this::aDto).toList();
    }

    public Optional<PostDto> obtener(long id) {
        return postRepository.findById(id).map(this::aDto);
    }

    public PostDto crear(NuevoPostDto nuevo) {
        Post post = Post.builder()
                .userId(nuevo.userId())
                .title(nuevo.title())
                .body(nuevo.body())
                .build();
        return aDto(postRepository.save(post));
    }

    public Optional<PostDto> actualizar(long id, NuevoPostDto datos) {
        return postRepository.findById(id).map(post -> {
            post.setUserId(datos.userId());
            post.setTitle(datos.title());
            post.setBody(datos.body());
            return aDto(postRepository.save(post));
        });
    }

    public boolean eliminar(long id) {
        if (!postRepository.existsById(id)) {
            return false;
        }
        postRepository.deleteById(id);
        return true;
    }

    private PostDto aDto(Post post) {
        return new PostDto(post.getId(), post.getUserId(), post.getTitle(), post.getBody());
    }
}