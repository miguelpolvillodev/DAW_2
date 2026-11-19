package com.ejemplo.apipropia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ejemplo.apipropia.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
}