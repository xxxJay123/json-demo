package com.example.jsondemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.jsondemo.entity.Album;
import com.example.jsondemo.repository.AlbumRepository;
import java.util.List;


@Service
public class AlbumService {

  @Autowired
  private final AlbumRepository albumRepository;


  public AlbumService(AlbumRepository albumRepository) {
    this.albumRepository = albumRepository;
  }

  public List<Album> getAllAlbums() {
    return albumRepository.findAll();
  }

  public Album getAlbumById(Integer id) {
    return albumRepository.findById(id).orElse(null);
  }

  public Album createAlbum(Album album) {
    return albumRepository.save(album);
  }

  public Album updateAlbum(Integer id, Album album) {
    if (!albumRepository.existsById(id)) {
      return null;
    }
    album.setId(id);
    return albumRepository.save(album);
  }

  public boolean deleteAlbum(Integer id) {
    if (albumRepository.existsById(id)) {
      albumRepository.deleteById(id);
      return true;
    }
    return false;
  }

  public Album saveAlbum(Album album) {
    return albumRepository.save(album);
  }

  public void saveAllAlbums(List<Album> albums) {
     albumRepository.saveAll(albums);
  }



}
