package com.example.jsondemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.jsondemo.entity.Comment;
import com.example.jsondemo.repository.CommentRepository;
import java.util.List;

@Service
public class CommentService {
  @Autowired
  private final CommentRepository commentRepository;


  public CommentService(CommentRepository commentRepository) {
    this.commentRepository = commentRepository;
  }

  public List<Comment> getAllComments() {
    return commentRepository.findAll();
  }

  public Comment getCommentById(Integer id) {
    return commentRepository.findById(id).orElse(null);
  }

  public Comment createComment(Comment comment) {
    return commentRepository.save(comment);
  }

  public Comment updateComment(Integer id, Comment comment) {
    if (!commentRepository.existsById(id)) {
      return null;
    }
    comment.setId(id);
    return commentRepository.save(comment);
  }

  public boolean deleteComment(Integer id) {
    if (commentRepository.existsById(id)) {
      commentRepository.deleteById(id);
      return true;
    }
    return false;
  }

  public Comment saveComment(Comment comment) {
    return commentRepository.save(comment);
  }

  public void saveAllComments(List<Comment> comments) {
    commentRepository.saveAll(comments);
  }
}
