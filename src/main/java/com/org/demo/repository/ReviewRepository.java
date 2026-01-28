package com.org.demo.repository;

import com.org.demo.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends JpaRepository <Review, Long> {

    //buscar reseñas por usuario y libro
    Optional<Review> findByUser_IdAndBook_Id(Long userId, Long bookId);
    //buscar reseñas por libro
    List<Review> findByBook_Id(Long bookId);
    //validar existencia de reseña por usuario para un libro para evitar duplicidades
    boolean existsByUser_IdAndBook_Id(Long userId, Long bookId);
}
