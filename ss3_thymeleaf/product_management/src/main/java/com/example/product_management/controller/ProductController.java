package com.example.product_management.controller;

import com.example.product_management.model.Product;
import com.example.product_management.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("/showList")
    public String showList(Model model) {
        model.addAttribute("list", this.productService.showList());
        return "showList";
    }

    @GetMapping("/addProduct")
    public String addProduct(Model model) {
        model.addAttribute("product", new Product());
        return "addProduct";
    }

    @PostMapping("/addProduct")
    public String addProduct(@ModelAttribute Product product) {
        this.productService.add(product);
        return "addProduct";
    }

    @PostMapping("/deleteProduct")
    public String deleteProduct(@RequestParam int id) {
        System.out.println(id);
        this.productService.delete(id);
        return "redirect:/showList";
    }
    @GetMapping("/editProduct")
    public String editProduct(@RequestParam int id,Model model){
        model.addAttribute("product", productService.findById(id));
        return "editProduct";
    }
    @PostMapping("/editProduct")
    public String editProduct(@ModelAttribute Product product){
        this.productService.edit(product);
        return "redirect:/showList";
    }

    @PostMapping("/detailProduct")
    public String detailProduct(@RequestParam int id,Model model){
        model.addAttribute("product",productService.findById(id));
        return "detailProduct";
    }

    @GetMapping("/findProduct")
    public String findProduct(@RequestParam String name,Model model) {
        model.addAttribute("list", this.productService.findProduct(name));
        return "showList";
    }
}
