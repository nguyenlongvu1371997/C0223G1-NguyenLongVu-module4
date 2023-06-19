package com.example.calculator.controller;

import com.example.calculator.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @Autowired
    private ICalculatorService calculatorService;

    @GetMapping("")
    public String calculator() {
        return "index";
    }

    @PostMapping("/calculator")
    public String calculator(@RequestParam double number1, double number2, String math, Model model) {

        model.addAttribute("result", calculatorService.calculator(number1, number2, math));
        return "index";
    }
}
