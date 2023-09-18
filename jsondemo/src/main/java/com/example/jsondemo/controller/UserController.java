package com.example.jsondemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.jsondemo.entity.User;
import com.example.jsondemo.service.UserService;
import java.util.List;
import org.springframework.context.annotation.Lazy;


@RestController
@RequestMapping("/users")
public class UserController {
  @Autowired
  @Lazy
  private final UserService userService;


  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/get-all-user")
  public List<User> getAllUsers() {
    return userService.getAllUsers();
  }

  @GetMapping("/getuser/{id}")
  public User getUserById(@PathVariable Integer id) {
    return userService.getUserById(id);
  }


}
