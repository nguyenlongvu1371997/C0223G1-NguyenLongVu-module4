package com.example.ss66.model;

import net.bytebuddy.implementation.bind.annotation.Default;

import javax.persistence.*;


@Entity
@Table(name = "blogs")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String date;
    private String author;
    @Column(length = 2000)
    private String content;
    @ManyToOne
    @JoinColumn(name = "type_of_blog_id", referencedColumnName = "id",nullable = true)
    private BlogType blogType;
    private boolean flagDelete;

    public Blog(String name, String date, String author, String content, BlogType blogType, boolean flagDelete) {
        this.name = name;
        this.date = date;
        this.author = author;
        this.content = content;
        this.blogType = blogType;
        this.flagDelete = flagDelete;
    }

    public Blog(Integer id, String name, String date, String author, String content, BlogType blogType, boolean isDelete) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.author = author;
        this.content = content;
        this.blogType = blogType;
        this.flagDelete = isDelete;
    }

    public Blog(Integer id, String name, String date, String author, String content, BlogType blogType) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.author = author;
        this.content = content;
        this.blogType = blogType;
    }

    public Blog(Integer id, String name, String date, String author, String content) {
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public BlogType getTypeOfBlog() {
        return blogType;
    }

    public void setTypeOfBlog(BlogType blogType) {
        this.blogType = blogType;
    }

    public BlogType getBlogType() {
        return blogType;
    }

    public void setBlogType(BlogType blogType) {
        this.blogType = blogType;
    }

    public boolean getFlagDelete() {
        return flagDelete;
    }

    public void setFlagDelete(boolean flagDelete) {
        this.flagDelete = flagDelete;
    }

}
