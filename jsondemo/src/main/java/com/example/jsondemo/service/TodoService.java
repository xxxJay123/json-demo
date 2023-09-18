package com.example.jsondemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.jsondemo.entity.ToDos;
import com.example.jsondemo.repository.ToDosRepository;
import java.util.List;

@Service
public class TodoService {
  @Autowired
  private final ToDosRepository todoRepository;


  public TodoService(ToDosRepository todoRepository) {
    this.todoRepository = todoRepository;
  }

  public List<ToDos> getAllTodos() {
    return todoRepository.findAll();
  }

  public ToDos getTodoById(Integer id) {
    return todoRepository.findById(id).orElse(null);
  }

  public ToDos createTodo(ToDos todo) {
    return todoRepository.save(todo);
  }

  public ToDos updateTodo(Integer id, ToDos todo) {
    if (!todoRepository.existsById(id)) {
      return null;
    }
    todo.setId(id);
    return todoRepository.save(todo);
  }

  public boolean deleteTodo(Integer id) {
    if (todoRepository.existsById(id)) {
      todoRepository.deleteById(id);
      return true;
    }
    return false;
  }

  public ToDos saveToDos(ToDos todo) {
    return todoRepository.save(todo);
  }

  public void  saveAllToDos(List<ToDos> todos) {
     todoRepository.saveAll(todos);
  }
}
