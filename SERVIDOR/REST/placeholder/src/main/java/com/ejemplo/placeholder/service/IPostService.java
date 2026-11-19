package com.ejemplo.placeholder.service;

import java.util.List;

import com.ejemplo.placeholder.dto.PostDto;

public interface IPostService {

	List<PostDto> listar();
	PostDto obtener(long id);
}
