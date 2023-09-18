package com.example.jsondemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.jsondemo.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer>{
  
}
