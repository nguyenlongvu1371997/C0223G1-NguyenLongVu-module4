package com.example.demo_change_money.controller;

import com.example.demo_change_money.service.IConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConvertController {
    @Autowired
    private IConvertService convertService;

    @GetMapping("/convert")
    public String convert() {
        return "index";
    }

    @PostMapping("/convert")
    public String convert(@RequestParam Double money, @RequestParam int from, @RequestParam int to, Model model) {
        model.addAttribute("money", convertService.convert(money, from, to));
        return "index";
    }
}
