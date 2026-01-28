package com.org.demo.service.impl;

import com.org.demo.entity.User;
import com.org.demo.exception.BadRequestException;
import com.org.demo.exception.ResourceNotFoundException;
import com.org.demo.repository.UserRepository;
import com.org.demo.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    //constructor
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    //create user
    @Override
    public User createUser(User user) {
        //validation before saving
        if (repository.existsByUsername(user.getUsername())){
            throw new BadRequestException("Username already exists.");
        }
         if (repository.existsByEmail(user.getEmail())){
             throw new BadRequestException("Email already exists");
         }
         return repository.save(user);
    }
    //find user by id
    @Override
    public User getUserById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }
    //find user by username
    @Override
    public User getUserByUsername(String username) {
        return repository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("Username not found"));
    }
    //list all users
    @Override
    public List<User> getAllUsers() {
        return repository.findAll();
    }
}
