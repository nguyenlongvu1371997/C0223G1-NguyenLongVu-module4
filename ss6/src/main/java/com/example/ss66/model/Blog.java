package com.example.ss66.model;

import javax.persistence.*;


@Entity
@Table(name = "blogs")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String date;
    private String author;
    private String content;

    public Blog(int id, String name, String date, String author, String content) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.author = author;
        this.content = content;
    }

    public Blog(String name, String date, String author, String content) {
        this.name = name;
        this.date = date;
        this.author = author;
        this.content = content;
    }

    public Blog() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
