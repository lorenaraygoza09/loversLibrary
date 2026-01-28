package com.org.demo.repository;

import com.org.demo.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    //buscar por nombre
    Optional<Author> findByName(String name);
    //buscar autores vivos
    List<Author> findByDeathYearIsNull();
    //buscar autores vivos en un periodo de tiempo
    List<Author> findByBirthYearLessThanEqualAndDeathYearGreaterThanEqual(
            Integer year1,
            Integer year2
    );
}
