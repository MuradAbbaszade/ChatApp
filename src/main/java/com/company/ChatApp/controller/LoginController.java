package com.company.ChatApp.controller;

import com.company.ChatApp.dto.UserDTO;
import com.company.ChatApp.service.MyUserDetailsService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    MyUserDetailsService userService;

    @GetMapping
    public String showLoginForm(WebRequest request, Model model) {
        UserDTO userDto = new UserDTO();
        model.addAttribute("user", userDto);
        return "login";
    }
}
