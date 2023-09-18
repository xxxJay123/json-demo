package com.example.jsondemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.jsondemo.entity.Album;

public interface AlbumRepository extends JpaRepository<Album, Integer>{
  
}
