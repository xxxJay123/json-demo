package com.example.jsondemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.jsondemo.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
