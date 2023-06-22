package com.example.product_management.controller;

import com.example.product_management.model.Product;
import com.example.product_management.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping("/list")
    public String showList(Model model) {
        model.addAttribute("list", this.productService.showList());
        return "showList";
    }

    @GetMapping("/add")
    public String addProduct(Model model) {
        model.addAttribute("product", new Product());
        return "addProduct";
    }

    @PostMapping("/add")
    public String addProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        this.productService.add(product);
        redirectAttributes.addFlashAttribute("massage", "thêm mới thành công");
        return "redirect:add";
    }

    @PostMapping("/delete")
    public String deleteProduct(@RequestParam int id, RedirectAttributes redirectAttributes) {
        if(this.productService.findById(id)==null){
            redirectAttributes.addFlashAttribute("massage", "không tìm thấy sản phẩm");
            return "redirect:list";
        }
        this.productService.delete(id);
        redirectAttributes.addFlashAttribute("massage", "xóa thành công");
        return "redirect:list";
    }

    @GetMapping("/edit")
    public String editProduct(@RequestParam int id, Model model, RedirectAttributes redirectAttributes) {
        if(this.productService.findById(id)==null){
            redirectAttributes.addFlashAttribute("massage", "không tìm thấy sản phẩm");
            return "redirect:list";
        }
        model.addAttribute("product", productService.findById(id));
        return "editProduct";
    }

    @PostMapping("/edit")
    public String editProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        if(this.productService.findById(product.getId())==null){
            redirectAttributes.addFlashAttribute("massage", "không tìm thấy sản phẩm");
            return "redirect:list";
        }
        this.productService.edit(product);
        redirectAttributes.addFlashAttribute("massage", "sửa thành công");
        return "redirect:list";
    }

    @PostMapping("/detail")
    public String detailProduct(@RequestParam int id, Model model, RedirectAttributes redirectAttributes) {
        if(this.productService.findById(id)==null){
            redirectAttributes.addFlashAttribute("massage", "không tìm thấy sản phẩm");
            return "redirect:list";
        }
        model.addAttribute("product", productService.findById(id));
        return "detailProduct";
    }

    @GetMapping("/find")
    public String findProduct(@RequestParam String name, Model model, RedirectAttributes redirectAttributes) {
        if(name.equals("")){
            return "redirect:list";
        }
        if (this.productService.findProduct(name).size()==0) {
            redirectAttributes.addFlashAttribute("massage", "không tìm thấy");
            return "redirect:list";
        }
        model.addAttribute("list", this.productService.findProduct(name));
        return "showList";
    }
}
