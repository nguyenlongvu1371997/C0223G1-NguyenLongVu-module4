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
        double result = 0;
        switch (math) {
            case "plus":
                result = calculatorService.plus(number1, number2);
                break;
            case "minus":
                result = calculatorService.minus(number1, number2);
                break;
            case "multiply":
                result = calculatorService.multiply(number1, number2);
                break;
            case "divide":
                if (number1 == 0) {
                    model.addAttribute("result", "không tính được");
                    return "index";
                }
                result = calculatorService.divide(number1, number2);
                break;
            default:
                break;
        }
        model.addAttribute("result", result);
        return "index";
    }
}
