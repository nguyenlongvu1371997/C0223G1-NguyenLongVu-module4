package com.example.book.controller;

import com.example.book.model.Book;
import com.example.book.model.BookRent;
import com.example.book.service.IBookService;
import com.example.book.service.IRentBookService;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/book")
public class BookController {
@Autowired
    private IBookService bookService;
@Autowired
   private IRentBookService rentBookService;

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
@PostMapping("/rent")
    public String rentBook(@RequestParam int id, RedirectAttributes redirectAttributes){
    if(!bookService.findBook(id).isPresent()){
        redirectAttributes.addFlashAttribute("msg","không tìm thấy sách");
        return "/detail";
    }
    if(bookService.rentBook(bookService.findBook(id).get())){
        String code =  String.valueOf((int) Math.floor(((Math.random() * 89999) + 10000)));
        rentBookService.addCode(new BookRent(code,new Book(id)));
        redirectAttributes.addFlashAttribute("msg","thuê thành công, mã trả của bạn là: "+code);

        return "redirect:/book";
    }
    return "redirect:/book";
}
@PostMapping("/return")
    public String returnBook(@RequestParam int id, @RequestParam String code,RedirectAttributes redirectAttributes){
    if(!rentBookService.findByCode(code,id).isPresent()){
        redirectAttributes.addFlashAttribute("msg","trả thất bại");
        return "/detail";
    }
    rentBookService.deleteCode(rentBookService.findByCode(code,id).get().getId());
    bookService.returnBook(bookService.findBook(id).get());
    redirectAttributes.addFlashAttribute("msg","trả thành công");
    return "redirect:/book";
}
}
