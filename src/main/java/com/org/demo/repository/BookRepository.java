package com.org.demo.repository;

import com.org.demo.entity.Book;
import com.org.demo.entity.Genre;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    //buscar libro por id de API externa
    Optional<Book> findByGoogleBookId(String googleBookId);
    //buscar libro por genero
    Page<Book> findByGenre(Genre genre, Pageable pageable);
    //buscar libro por autor
    Page<Book> findByAuthor_NameContainingIgnoreCase(
            String authorName,
            Pageable pageable
    );
    //buscar libro por idioma
    Page<Book> findByLanguage(String language, Pageable pageable);
}
