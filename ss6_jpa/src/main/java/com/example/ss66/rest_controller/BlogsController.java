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
    public ResponseEntity<List<Blog>> getBlogList() {
        List<Blog> list = blogService.getBlog();
        if (list == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @GetMapping("/limit/{limit}")
    public ResponseEntity<List<Blog>> getBlogListLimit(@PathVariable int limit) {
        List<Blog> list = blogService.getListLimit(limit);
        if (list == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("{id}")
    private ResponseEntity<Blog> getBlogDetail(@PathVariable Integer id) {
        if (blogService.findById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogService.findById(id), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateBlog(@PathVariable Integer id, @RequestBody Blog blog) {
        if (blogService.findById(id) != null) {
            blogService.addBlog(blog);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/findByName/{name}")
    @CrossOrigin("*")
    public ResponseEntity<List<Blog>> findBlogsByName(@PathVariable String name) {
        List<Blog> list = blogService.findByName(name);
        if (list == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

}
