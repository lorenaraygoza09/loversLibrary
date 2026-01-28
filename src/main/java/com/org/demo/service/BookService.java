package com.org.demo.service;

public interface BookService {
    Object searchBooks(String query);

    Object getBookById(Long id);
}
