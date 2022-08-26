package com.company.ChatApp.controller;

import com.company.ChatApp.dto.UserDTO;
import com.company.ChatApp.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class LoginController {

    @Autowired
    MyUserDetailsService userService;

    @GetMapping("/login")
    public String showLoginForm(WebRequest request, Model model) {
        UserDTO userDto = new UserDTO();
        model.addAttribute("user", userDto);
        return "login";
    }

    @GetMapping("/termsOfService")
    public String showPage() {
        return "termsOfService";
    }
}
