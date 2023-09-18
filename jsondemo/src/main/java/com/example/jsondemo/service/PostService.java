package com.example.jsondemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.jsondemo.entity.Post;
import com.example.jsondemo.repository.PostRepository;

import java.util.List;

@Service
public class PostService {
  @Autowired
  private final PostRepository postRepository;


  public PostService(PostRepository postRepository) {
    this.postRepository = postRepository;
  }

  public List<Post> getAllPosts() {
    return postRepository.findAll();
  }

  public Post getPostById(Integer id) {
    return postRepository.findById(id).orElse(null);
  }

  public Post createPost(Post post) {
    return postRepository.save(post);
  }

  public Post updatePost(Integer id, Post post) {
    if (!postRepository.existsById(id)) {
      return null;
    }
    post.setId(id);
    return postRepository.save(post);
  }

  public boolean deletePost(Integer id) {
    if (postRepository.existsById(id)) {
      postRepository.deleteById(id);
      return true;
    }
    return false;
  }

  public Post savePost(Post post) {
    return postRepository.save(post);
  }

  public void saveAllPosts(List<Post> posts) {
     postRepository.saveAll(posts);
  }
}
