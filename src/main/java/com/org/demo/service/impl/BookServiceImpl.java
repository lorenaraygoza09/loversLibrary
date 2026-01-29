package com.org.demo.service.impl;

import com.org.demo.repository.BookRepository;
import com.org.demo.service.BookService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    private final BookRepository repository;

    public BookServiceImpl(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    public Object searchBooks(String query) {
        return null;
    }

    @Override
    public Object getBookById(Long id) {
        return null;
    }
}
