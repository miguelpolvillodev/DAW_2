package com.ejemplo.placeholder.service;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.ejemplo.placeholder.dto.PostDto;

@Service
public class PostServiceImpl implements IPostService {

	private final RestClient restClient;
	
	public PostServiceImpl() {
        this.restClient = RestClient.builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .build();
    }
	
	public List<PostDto> listar() {
        return restClient.get()
                .uri("/posts")
                .retrieve()
                .body(new ParameterizedTypeReference<List<PostDto>>() {});
    }
	
	public PostDto obtener(long id) {
        return restClient.get()
                .uri("/posts/{id}", id)
                .retrieve()
                .body(PostDto.class);
    }
}
