package com.example.sandwich.controller;

import com.example.sandwich.service.ISandwichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichController {

    @Autowired
    private ISandwichService sandwichService;

    @PostMapping("/index")
    public String sandwich(@RequestParam("sandwich") String[] condiments, Model model) {
        System.out.println(condiments.length);
        model.addAttribute("list", sandwichService.condiments(condiments));
        return "condiment-list";
    }
}
