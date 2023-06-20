package com.example.configuring_email.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.example.configuring_email.model.Email;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class EmailController {
    @GetMapping("")
    public String setEmail(Model model) {
        model.addAttribute("email", new Email());
        return "index";
    }

    @PostMapping("/list")
    public String setEmail(@ModelAttribute Email email, Model model) {
        model.addAttribute("email", email);
        return "display";
    }
}
