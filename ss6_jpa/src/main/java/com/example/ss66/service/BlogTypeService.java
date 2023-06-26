package com.example.ss66.service;

import com.example.ss66.model.BlogType;
import com.example.ss66.repository.IBlogTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlogTypeService implements IBlogTypeService{
    @Autowired
    private IBlogTypeRepository blogTypeRepository;
    @Override
    public List<BlogType> getBlogTypes() {
        return blogTypeRepository.findAll();
    }
}
