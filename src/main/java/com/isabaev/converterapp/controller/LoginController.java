package com.isabaev.converterapp.controller;


import com.isabaev.converterapp.entity.User;
import com.isabaev.converterapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;


    @GetMapping("/login")
    public String loginPage(Model model) {
      //  model.addAttribute("userForm", new User());

        return "login";
    }

    @PostMapping("/login")
    public String addUser(@ModelAttribute("userForm") User userForm, Model model) {

        User userFromBD = userService.loadUserByUsername(userForm.getUsername());

        if (userFromBD == null || !userFromBD.getPassword().equals(userForm.getPassword())){
            model.addAttribute("usernameError", "Проверьте правильность введенных Вами данных");
            return "registration";
        }

        return "converter";
    }

}
