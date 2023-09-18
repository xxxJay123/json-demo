package com.example.jsondemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.jsondemo.entity.Post;

public interface PostRepository extends JpaRepository<Post, Integer>{
  
}
