package com.example.jsondemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import com.example.jsondemo.entity.Post;
import com.example.jsondemo.service.PostService;
import java.util.Arrays;
import java.util.List;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/posts")
public class PostController {
  @Autowired
@Lazy
  private final PostService postService;

  private final String JPI_API_URL = "https://jsonplaceholder.typicode.com/posts";


  public PostController(PostService postService) {
    this.postService = postService;
  }

  @GetMapping("/get-all-posts")
  public List<Post> getAllPosts() {
    return postService.getAllPosts();
  }

  @GetMapping("/getpost/{id}")
  public Post getPostById(@PathVariable Integer id) {
    return postService.getPostById(id);
  }
  


}
