package com.org.demo.repository;

import com.org.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    //buscar usuario por username
    Optional<User> findByUsername(String username);
    //buscar usuario por email
    Optional<User> findByEmail(String email);
    //username existente
    boolean existsByUsername(String username);
    //email existente
    boolean existsByEmail(String email);
}
