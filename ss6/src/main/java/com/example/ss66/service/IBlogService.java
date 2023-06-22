package com.example.ss66.service;

import com.example.ss66.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> displayList();

    void addBlog(Blog blog);

    Blog findById(int id);

    List<Blog> findByName(String name);

    void delete(int id);
}
