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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("/product/list")
    public String showList(Model model) {
        model.addAttribute("list", this.productService.showList());
        return "showList";
    }

    @GetMapping("/product/add")
    public String addProduct(Model model) {
        model.addAttribute("product", new Product());
        return "addProduct";
    }

    @PostMapping("/product/add")
    public String addProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        this.productService.add(product);
        redirectAttributes.addFlashAttribute("massage", "thêm mới thành công");
        return "redirect:/product/add";
    }

    @PostMapping("/product/delete")
    public String deleteProduct(@RequestParam int id, RedirectAttributes redirectAttributes) {
        System.out.println(id);
        this.productService.delete(id);
        redirectAttributes.addFlashAttribute("massage", "xóa thành công");
        return "redirect:/product/list";
    }

    @GetMapping("/product/edit")
    public String editProduct(@RequestParam int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "editProduct";
    }

    @PostMapping("/product/edit")
    public String editProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        this.productService.edit(product);
        redirectAttributes.addFlashAttribute("massage", "sửa thành công");
        return "redirect:/product/list";
    }

    @PostMapping("/product/detail")
    public String detailProduct(@RequestParam int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "detailProduct";
    }

    @GetMapping("/product/find")
    public String findProduct(@RequestParam String name, Model model, RedirectAttributes redirectAttributes) {
        if (this.productService.findProduct(name) == null) {
            redirectAttributes.addFlashAttribute("massage", "không tìm thấy");
            return "redirect:/product/list";
        }
        model.addAttribute("list", this.productService.findProduct(name));
        return "showList";
    }
}
