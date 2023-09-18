package com.example.jsondemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.jsondemo.entity.ToDos;
import com.example.jsondemo.service.TodoService;
import java.util.List;
import org.springframework.context.annotation.Lazy;

@RestController
@RequestMapping("/todos")
public class TodoController {

  @Autowired
  @Lazy
  private final TodoService todoService;

  public TodoController(TodoService todoService) {
    this.todoService = todoService;
  }

  @GetMapping("/get-all-todos")
  public List<ToDos> getAllTodos() {
    return todoService.getAllTodos();
  }

  @GetMapping("/gettodos/{id}")
  public ToDos getTodoById(@PathVariable Integer id) {
    return todoService.getTodoById(id);
  }



}
