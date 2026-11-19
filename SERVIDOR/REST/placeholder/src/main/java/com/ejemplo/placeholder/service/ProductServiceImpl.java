package com.ejemplo.placeholder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.ejemplo.placeholder.dto.ProductDto;

@Service
public class ProductServiceImpl  implements IProductService{

	private final RestClient restClient;

	public ProductServiceImpl() {
		this.restClient = RestClient.builder()
				.baseUrl("https://fakestoreapi.com")
				.build();
	}

	@Override
	public List<ProductDto> listar() {
		return restClient.get()
				.uri("/products")
				.retrieve()
				.body(new ParameterizedTypeReference<List<ProductDto>>() {});
	}

	@Override
	public ProductDto Obtener(Long id) {
		return restClient.get()
				.uri("/{id}", id)
				.retrieve()
				.body(ProductDto.class);
	}
}
