package com.example.jsondemo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.jsondemo.entity.User;
import com.example.jsondemo.repository.UserRepository;

@Service
public class UserService {
  @Autowired
  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  public User getUserById(Integer id) {
    return userRepository.findById(id).orElse(null);
  }

  public User createUser(User user) {
    return userRepository.save(user);
  }

  public User updateUser(Integer id, User user) {
    if (!userRepository.existsById(id)) {
      return null;
    }
    user.setId(id);
    return userRepository.save(user);
  }

  public boolean deleteUser(Integer id) {
    if (userRepository.existsById(id)) {
      userRepository.deleteById(id);
      return true;
    }
    return false;
  }

  public User saveUser(User user) {
    return userRepository.save(user);
  }

  public void saveAllUsers(List<User> users) {
    userRepository.saveAll(users);
  }

}
