package com.example.ss66.controller;

import com.example.ss66.model.Blog;
import com.example.ss66.service.IBlogService;
import com.example.ss66.service.IBlogTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @Autowired
    private IBlogTypeService blogTypeService;

    @GetMapping()
    public String getBlogs(@PageableDefault(size = 3) Pageable pageable, Model model){
        model.addAttribute("list",blogService.displayList(pageable));
        return "displayList";
    }

    @GetMapping("/add")
    public String addBlog(Model model){
        model.addAttribute("blog",new Blog());
        model.addAttribute("blogTypes", blogTypeService.getBlogTypes());
        return "addBlog";
    }

    @PostMapping("/add")
    public String addBlog(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes){
        blogService.addBlog(blog);
        redirectAttributes.addFlashAttribute("message","Thêm mới thành công");
        return "redirect:/blog/add";
    }

    @GetMapping("/delete")
    public String deleteBlog(@RequestParam int id,Model model, RedirectAttributes redirectAttributes){
        if(blogService.findById(id)==null){
            redirectAttributes.addFlashAttribute("message","không tìm thấy blog để xóa");
            return "redirect:/blog";
        }
        blogService.delete(id);
        redirectAttributes.addFlashAttribute("message","xóa thành công");
        return "redirect:/blog";
    }

    @GetMapping("/detail")
    public String detailBlog(@RequestParam int id, Model model, RedirectAttributes redirectAttributes){
        if(blogService.findById(id)==null){
            redirectAttributes.addFlashAttribute("message","không tìm thấy blog");
            return "redirect:/blog";
        }
        model.addAttribute("blog",blogService.findById(id));
        return "detailBlog";
    }

    @GetMapping("/edit")
    public String editBlog(@RequestParam int id,Model model, RedirectAttributes redirectAttributes){
        if(blogService.findById(id)==null){
            redirectAttributes.addFlashAttribute("message","không tìm thấy blog để sửa");
            return "redirect:/blog";
        }
        model.addAttribute("blog",blogService.findById(id));
        model.addAttribute("blogTypes", blogTypeService.getBlogTypes());
        return "editBlog";
    }

    @PostMapping("/edit")
    public String editBlog(@ModelAttribute Blog blog, Model model, RedirectAttributes redirectAttributes){
        if(blogService.findById(blog.getId())==null){
            redirectAttributes.addFlashAttribute("message","không tìm thấy blog để sửa");
            return "redirect:/blog";
        }
        blogService.addBlog(blog);
        redirectAttributes.addFlashAttribute("message","sửa thành công");
        return "redirect:/blog";
    }

}
