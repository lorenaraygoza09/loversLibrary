package com.org.demo.controller;

import com.org.demo.dto.auth.AuthResponse;
import com.org.demo.dto.request.LoginRequest;
import com.org.demo.dto.request.RegisterRequest;
import com.org.demo.entity.Role;
import com.org.demo.entity.User;
import com.org.demo.exception.BadRequestException;
import com.org.demo.repository.UserRepository;
import com.org.demo.security.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthController(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) {
        if (userRepository.existsByUsername(request.getUsername())){
            throw new BadRequestException("Username already exists");
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(Role.USER);

        userRepository.save(user);

        String token = jwtService.generateToken(user);
        return  ResponseEntity.ok(new AuthResponse(token));
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request){
        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new BadRequestException("Invalid credentials"));
        if (!passwordEncoder.matches(
                request.getPassword(),
                user.getPassword()
        )) {
            throw new BadRequestException("Invalid credentials");
        }
        String token = jwtService.generateToken(user);
        return new AuthResponse(token);
    }
}
