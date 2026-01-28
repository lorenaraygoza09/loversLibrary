package com.org.demo.mapper;

import com.org.demo.dto.user.UserCreateRequest;
import com.org.demo.dto.user.UserResponse;
import com.org.demo.entity.User;

public class UserMapper {
    public static User toEntity(UserCreateRequest dto){
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword()); //don't forget to encrypt later
        return user;
    }

    public static UserResponse toResponse(User user){
        return new UserResponse(
                user.getId(),
                user.getUsername(),
                user.getEmail()
        );
    }
}
