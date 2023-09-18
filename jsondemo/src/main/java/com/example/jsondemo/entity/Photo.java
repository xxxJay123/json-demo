package com.example.jsondemo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "photo")//done checked
public class Photo {
  @Id
  private Integer id;
  private Integer albumId;
  private String title;
  private String url;
  private String thumbnailUrl;

 
}


