package com.example.jsondemo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "posts")//done checked
public class Post {
  @Id
  private Integer id;

  private Integer userId;
  private String title;
  private String body;
}
