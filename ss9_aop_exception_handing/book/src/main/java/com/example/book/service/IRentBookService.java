package com.example.book.service;

import com.example.book.model.BookRent;

import java.util.Optional;

public interface IRentBookService {
    void addCode(BookRent bookRent);
    void deleteCode(int rentId);

    Optional<BookRent> findByCode(String code, int bookId);
}
