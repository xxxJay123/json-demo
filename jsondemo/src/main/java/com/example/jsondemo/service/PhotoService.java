package com.example.jsondemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.jsondemo.entity.Photo;
import com.example.jsondemo.repository.PhotoRepository;
import java.util.List;

@Service
public class PhotoService {
  @Autowired

  private final PhotoRepository photoRepository;


  public PhotoService(PhotoRepository photoRepository) {
    this.photoRepository = photoRepository;
  }

  public List<Photo> getAllPhotos() {
    return photoRepository.findAll();
  }

  public Photo getPhotoById(Integer id) {
    return photoRepository.findById(id).orElse(null);
  }

  public Photo createPhoto(Photo photo) {
    return photoRepository.save(photo);
  }

  public Photo updatePhoto(Integer id, Photo photo) {
    if (!photoRepository.existsById(id)) {
      return null;
    }
    photo.setId(id);
    return photoRepository.save(photo);
  }

  public boolean deletePhoto(Integer id) {
    if (photoRepository.existsById(id)) {
      photoRepository.deleteById(id);
      return true;
    }
    return false;
  }

  public Photo savePhoto(Photo photo) {
    return photoRepository.save(photo);
  }

  public void saveAllPhotos(List<Photo> photos) {
     photoRepository.saveAll(photos);
  }
}
