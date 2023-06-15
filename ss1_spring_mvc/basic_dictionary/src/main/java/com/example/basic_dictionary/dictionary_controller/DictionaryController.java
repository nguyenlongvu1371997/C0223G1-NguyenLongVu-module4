package com.example.basic_dictionary.dictionary_controller;

import com.example.basic_dictionary.dictionary_service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@Controller
public class DictionaryController {
    @Autowired
    IDictionaryService dictionaryService;

    @GetMapping("/dictionary")
    public String dictionary() {
        return "index";
    }

    @PostMapping("/dictionary")
    public String dictionary(@RequestParam String word, Model model) {
        model.addAttribute("word", dictionaryService.translate(word));
        return "index";
    }
}
