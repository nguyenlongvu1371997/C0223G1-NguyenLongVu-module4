package com.example.ss66.service;

import com.example.ss66.model.Blog;
import com.example.ss66.model.BlogType;

import java.util.List;
import java.util.Optional;

public interface IBlogTypeService {
    List<BlogType> getBlogTypes();
    void addBlogType(BlogType blogType);
    Optional<BlogType> findById(int id);
    void deleteBlogType(int id);

}
