package com.example.ss66.rest_controller;

import com.example.ss66.model.Blog;
import com.example.ss66.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogs")
public class BlogsController {
    @Autowired
    private IBlogService blogService;

    @GetMapping()
    public List<Blog> getBlogList() {
        return this.blogService.getBlog();
    }

    @GetMapping("{id}")
    private Blog getBlogDetail(@PathVariable Integer id) {
        return this.blogService.findById(id);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateBlog(@PathVariable Integer id, @RequestBody Blog blog) {
        if(blogService.findById(id) != null) {
            blogService.addBlog(blog);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }






}
