package com.example.jsondemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.jsondemo.entity.ToDos;

public interface ToDosRepository extends JpaRepository<ToDos, Integer> {
  
}
