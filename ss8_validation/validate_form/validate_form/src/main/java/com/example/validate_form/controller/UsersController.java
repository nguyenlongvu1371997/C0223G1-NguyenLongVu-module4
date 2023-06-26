package com.example.validate_form.controller;

import com.example.validate_form.dto.UsersCreateDto;
import com.example.validate_form.model.Users;
import com.example.validate_form.service.IUsersService;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private IUsersService usersService;

    @GetMapping("")
    public String getCreationForm(Model model) {
        model.addAttribute("usersCreateDto", new UsersCreateDto());
        return "/creationForm";
    }

    @PostMapping("/create")
    public String getCreationForm(@Valid @ModelAttribute UsersCreateDto usersCreateDto,
                                  BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        new UsersCreateDto().validate(usersCreateDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "/creationForm";
        }
        Users users = new Users();
        BeanUtils.copyProperties(usersCreateDto, users);
        usersService.add(users);
        redirectAttributes.addFlashAttribute("msg", "thêm mới thành công");
        return "redirect:/users";
    }
}
