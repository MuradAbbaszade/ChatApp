
package com.company.ChatApp.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    
    @GetMapping("/main")
    public String showMainPage(HttpServletRequest request, Model model) {
        return "main";
    }
}