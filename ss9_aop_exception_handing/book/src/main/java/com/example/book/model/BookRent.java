package com.example.book.model;

import javax.persistence.*;

@Entity
public class BookRent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String code;
    @ManyToOne
    @JoinColumn(name="book_id", nullable = false)
    private Book book;

    public BookRent(Integer id, String code, Book book) {
        this.id = id;
        this.code = code;
        this.book = book;
    }

    public BookRent(String code, Book book) {
        this.code = code;
        this.book = book;
    }

    public BookRent() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
