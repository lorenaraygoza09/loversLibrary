package com.org.demo.service;

import com.org.demo.entity.User;

import java.util.List;

public interface UserService {
   User createUser(User user);

   User getUserById(Long id);

   User getUserByUsername(String username);

   List<User> getAllUsers();
}
