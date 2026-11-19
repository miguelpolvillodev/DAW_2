package com.ejemplo.placeholder.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import com.ejemplo.placeholder.dto.PostDto;
import com.ejemplo.placeholder.service.PostServiceImpl;

@RestController
@RequestMapping("/post")
public class PostController {

	private final PostServiceImpl postService;

	PostController(PostServiceImpl postService) {
		this.postService = postService;
	}

	@GetMapping("/todos")
	public List<PostDto> listar() {
		return postService.listar();
	}

	@GetMapping("/{id}")
	public ResponseEntity<PostDto> obtener(@PathVariable long id) {
		try {
			return ResponseEntity.ok(postService.obtener(id));
		} catch (HttpClientErrorException.NotFound e) {
			return ResponseEntity.notFound().build();
		}
	}
}
