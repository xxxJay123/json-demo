package com.example.jsondemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.jsondemo.entity.Photo;
import com.example.jsondemo.service.PhotoService;
import java.util.List;
import org.springframework.context.annotation.Lazy;

@RestController
@RequestMapping("/photos")
public class PhotoController {
  @Autowired
@Lazy
  private final PhotoService photoService;


  public PhotoController(PhotoService photoService) {
    this.photoService = photoService;
  }

  @GetMapping("/get-all-comment")
  public List<Photo> getAllPhoto() {
    return photoService.getAllPhotos();
  }

  @GetMapping("/getcomment/{id}")
  public Photo getCommentById(@PathVariable Integer id) {
    return photoService.getPhotoById(id);
  }
}
