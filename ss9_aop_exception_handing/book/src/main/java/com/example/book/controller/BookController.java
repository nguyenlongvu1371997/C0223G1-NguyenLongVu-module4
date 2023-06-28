package com.example.book.controller;

import com.example.book.service.IBookService;
import com.example.book.service.IRentBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/book")
public class BookController {
@Autowired
    IBookService bookService;
@Autowired
    IRentBookService rentBookService;

@GetMapping("")
    public String getBookList(Model model){
    model.addAttribute("list",bookService.displayList());
    return "/displayList";
}
@GetMapping("/detail")
    public String detailBook(@RequestParam int id, Model model, RedirectAttributes redirectAttributes){
    if(!bookService.findBook(id).isPresent()){
        redirectAttributes.addFlashAttribute("msg","không tìm thấy sách");
        return "redirect:/book";
    }
    model.addAttribute("book", bookService.findBook(id).get());
    return "/detail";
}
}
