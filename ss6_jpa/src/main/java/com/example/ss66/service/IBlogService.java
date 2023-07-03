package com.example.ss66.service;

import com.example.ss66.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    Page<Blog> displayList(Pageable pageable);
    List<Blog> getBlog();



    Page<Blog> displayListByType(int type, Pageable pageable);
    List<Blog> displayListByType(int type);

    void addBlog(Blog blog);

    Blog findById(int id);

    List<Blog> findByName(String name);

    void delete(int id);
    List<Blog> getListLimit(int limit);

}
