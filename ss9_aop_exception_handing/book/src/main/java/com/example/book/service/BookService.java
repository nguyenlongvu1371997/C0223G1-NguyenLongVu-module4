package com.example.book.service;

import com.example.book.model.Book;
import com.example.book.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepository bookRepository;

    @Override
    public List<Book> displayList() {
        return bookRepository.findAll();
    }

    @Override
    public boolean rentBook(Book book) {
        if (book.getAmount() == 0) {
            return false;
        }
        book.setAmount(book.getAmount() - 1);
        bookRepository.save(book);
        return true;
    }

    @Override
    public void returnBook(Book book) {
        book.setAmount(book.getAmount() + 1);
        bookRepository.save(book);
    }

    @Override
    public Optional<Book> findBook(int id) {
        return bookRepository.findById(id);
    }
}
