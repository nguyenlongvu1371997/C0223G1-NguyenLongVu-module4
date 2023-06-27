package com.example.ss66.service;

import com.example.ss66.model.Blog;
import com.example.ss66.model.BlogType;
import com.example.ss66.repository.IBlogTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogTypeService implements IBlogTypeService {
    @Autowired
    private IBlogTypeRepository blogTypeRepository;

    @Override
    public List<BlogType> getBlogTypes() {
        return blogTypeRepository.findAll();
    }

    @Override
    public void addBlogType(BlogType blogType) {
        blogTypeRepository.save(blogType);
    }

    @Override
    public Optional<BlogType> findById(int id) {
        return blogTypeRepository.findById(id);
    }

    @Override
    public void deleteBlogType(int id) {
        blogTypeRepository.deleteById(id);
    }

}
