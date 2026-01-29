package com.org.demo.controller;

import com.org.demo.dto.user.UserCreateRequest;
import com.org.demo.dto.user.UserResponse;
import com.org.demo.entity.User;
import com.org.demo.mapper.UserMapper;
import com.org.demo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //create user
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse createUser(@Valid @RequestBody UserCreateRequest request){
        User user = UserMapper.toEntity(request);
        User savedUser = userService.createUser(user);
        return UserMapper.toResponse(savedUser);
    }
    //get user by id
    @GetMapping("/{id}")
    public UserResponse getUserById(@PathVariable Long id){
        return UserMapper.toResponse(
                userService.getUserById(id)
        );
    }
    //list all users
    @GetMapping
    public List<UserResponse> getAllUsers(){
        return userService.getAllUsers()
                .stream()
                .map(UserMapper::toResponse)
                .toList();
    }
}
