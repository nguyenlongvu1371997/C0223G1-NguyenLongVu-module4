package com.example.ss66.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "type_of_blog")
public class BlogType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    @OneToMany(mappedBy = "blogType")
    private List<Blog> blogs;

    public BlogType(int id, String name, List<Blog> blogs) {
        this.id = id;
        this.name = name;
        this.blogs = blogs;
    }

    public BlogType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public BlogType() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }
}
