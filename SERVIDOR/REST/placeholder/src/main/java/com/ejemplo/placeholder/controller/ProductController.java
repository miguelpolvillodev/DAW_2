package com.ejemplo.placeholder.controller;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplo.placeholder.dto.ProductDto;
import com.ejemplo.placeholder.service.ProductServiceImpl;

@RestController
@RequestMapping("/productos")
public class ProductController {
	
	private final ProductServiceImpl productService;

	ProductController(ProductServiceImpl productService) {
		this.productService = productService;
	}
	
	@GetMapping("/todos")
	public List<ProductDto> obtenerTodos(){
		System.out.println(productService.listar());
		return productService.listar();
	}
	
	@GetMapping("/{id}")
	public ProductDto obtenerPorId(@PathVariable Long id) {
		return productService.Obtener(id);
	}

}
