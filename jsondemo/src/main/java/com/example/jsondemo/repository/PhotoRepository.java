package com.example.jsondemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.jsondemo.entity.Photo;

public interface PhotoRepository extends JpaRepository<Photo, Integer> {

}

