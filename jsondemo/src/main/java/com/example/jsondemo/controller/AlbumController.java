package com.example.jsondemo.controller;

import com.example.jsondemo.entity.Album;
import com.example.jsondemo.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.context.annotation.Lazy;
import java.util.List;

@RestController
@RequestMapping("/albums")
public class AlbumController {
  @Autowired
@Lazy

  private final AlbumService albumService;

  public AlbumController(AlbumService albumService) {
    this.albumService = albumService;
  }

  @GetMapping("/get-all-albums")
  public List<Album> getAllAlbums() {
    return albumService.getAllAlbums();
  }

  @GetMapping("/getalbum/{id}")
  public Album getAlbumById(@PathVariable Integer id) {
    return albumService.getAlbumById(id);
  }
}

