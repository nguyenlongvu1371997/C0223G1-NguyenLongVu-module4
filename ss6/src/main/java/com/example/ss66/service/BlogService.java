package com.example.ss66.service;

import com.example.ss66.model.Blog;
import com.example.ss66.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public Page<Blog> displayList(Pageable pageable) {
        return blogRepository.findAllByFlagDeleteIsFalse(pageable);
    }

    @Override
    public void addBlog(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found product by id " + id));
    }


    @Override
    public List<Blog> findByName(String name) {
        return blogRepository.searchForName(name);
    }

    @Override
    public void delete(int id) {
        Blog blog = blogRepository.findById(id).get();
        blog.setFlagDelete(true);
        blogRepository.save(blog);
    }
}
