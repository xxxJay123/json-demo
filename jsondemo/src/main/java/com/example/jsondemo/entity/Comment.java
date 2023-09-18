package com.example.jsondemo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "comments")//done checked
public class Comment {
    @Id
    private Integer id;

    private Integer postId;
    private String name;
    private String email;

    
    private String body;
}
