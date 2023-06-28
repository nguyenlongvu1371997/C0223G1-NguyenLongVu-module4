package com.example.book.service;

import com.example.book.model.BookRent;
import com.example.book.repository.IBookRentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RentBookService implements IRentBookService {
    @Autowired
    private IBookRentRepository bookRentRepository;

    @Override
    public void addCode(BookRent bookRent) {
        bookRentRepository.save(bookRent);
    }

    @Override
    public void deleteCode(int rentId) {
        bookRentRepository.deleteById(rentId);
    }

    @Override
    public Optional<BookRent> findByCode(String code, int bookId) {
        return bookRentRepository.findBookRent(code, bookId);
    }
}
