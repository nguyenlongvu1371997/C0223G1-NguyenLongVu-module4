package com.example.ss66.rest_controller;

import com.example.ss66.model.Blog;
import com.example.ss66.model.BlogType;
import com.example.ss66.service.IBlogService;
import com.example.ss66.service.IBlogTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/blogTypes")
public class BlogTypesController {
    @Autowired
    private IBlogTypeService blogTypeService;
    @Autowired
    private IBlogService blogService;

    @GetMapping
    public List<BlogType> getBlogTypeList() {
        return this.blogTypeService.getBlogTypes();
    }

    @GetMapping("{blogType}")
    private List<Blog> getBlogByBlogType(@PathVariable Integer blogType) {
        return this.blogService.displayListByType(blogType);
    }

}
