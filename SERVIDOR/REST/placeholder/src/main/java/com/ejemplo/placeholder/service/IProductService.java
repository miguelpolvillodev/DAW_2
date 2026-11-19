package com.ejemplo.placeholder.service;

import java.util.List;

import com.ejemplo.placeholder.dto.ProductDto;

public interface IProductService {

	List<ProductDto> listar();
	ProductDto Obtener (Long id);
}
