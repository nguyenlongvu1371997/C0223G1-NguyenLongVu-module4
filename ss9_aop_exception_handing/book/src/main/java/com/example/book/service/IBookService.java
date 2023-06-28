package com.example.book.service;

import com.example.book.model.Book;

import java.util.List;
import java.util.Optional;

public interface IBookService {
    List<Book> displayList();
    boolean rentBook(Book book);
    void returnBook(Book book);
    Optional<Book> findBook(int id);
}
