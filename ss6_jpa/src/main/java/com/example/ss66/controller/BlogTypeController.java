package com.example.ss66.controller;

import com.example.ss66.model.BlogType;
import com.example.ss66.repository.IBlogTypeRepository;
import com.example.ss66.service.IBlogTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/blogType")
public class BlogTypeController {
    @Autowired
    private IBlogTypeService blogTypeService;

    @GetMapping("")
    public String getBlogType(Model model) {
        model.addAttribute("list", blogTypeService.getBlogTypes());
        return "displayBlogType";
    }

    @GetMapping("/add")
    public String addBlogType(Model model) {
        model.addAttribute("blogType", new BlogType());
        return "addBlogType";
    }

    @PostMapping("/add")
    public String addBlogType(@ModelAttribute BlogType blogType, RedirectAttributes redirectAttributes) {
        blogTypeService.addBlogType(blogType);
        redirectAttributes.addFlashAttribute("message", "Thêm mới thành công");
        return "redirect:/blogType/add";
    }

    @GetMapping("/delete")
    public String deleteBlogType(@RequestParam int id, RedirectAttributes redirectAttributes) {

        if (!blogTypeService.findById(id).isPresent()) {
            redirectAttributes.addFlashAttribute("msg", "không tìm thấy để xóa");
            return "redirect:/blogType";
        }
        blogTypeService.deleteBlogType(id);
        redirectAttributes.addFlashAttribute("msg", "Xóa thành công");
        return "redirect:/blogType";
    }

    @GetMapping("/edit")
    public String editBlogType(@RequestParam int id, RedirectAttributes redirectAttributes,Model model){
        if (!blogTypeService.findById(id).isPresent()) {
            redirectAttributes.addFlashAttribute("msg", "không tìm thấy để sửa");
            return "redirect:/blogType";
        }
        model.addAttribute("blogType",blogTypeService.findById(id));
        return "/editBlogType";
    }
    @PostMapping("/edit")
    public String editBlogType(@ModelAttribute BlogType blogType, RedirectAttributes redirectAttributes) {
        if (!blogTypeService.findById(blogType.getId()).isPresent()) {
            redirectAttributes.addFlashAttribute("msg", "không tìm thấy để sửa");
            return "redirect:/blogType";
        }
        blogTypeService.addBlogType(blogType);
        redirectAttributes.addFlashAttribute("message", "sửa thành công");
        return "redirect:/blogType/add";
    }
}
