package com.example.jsondemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.jsondemo.entity.Comment;
import com.example.jsondemo.service.CommentService;
import java.util.List;
import org.springframework.context.annotation.Lazy;


@RestController
@RequestMapping("/comments")
public class CommentController {
  @Autowired
  @Lazy
  private final CommentService commentService;


  public CommentController(CommentService commentService) {
    this.commentService = commentService;
  }

  @GetMapping("/get-all-comment")
  public List<Comment> getAllComments() {
    return commentService.getAllComments();
  }

  @GetMapping("/getcomment/{id}")
  public Comment getCommentById(@PathVariable Integer id) {
    return commentService.getCommentById(id);
  }

}

