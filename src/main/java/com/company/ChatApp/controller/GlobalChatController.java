package com.company.ChatApp.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GlobalChatController {

    @GetMapping("/globalChat")
    public String showChatPage(HttpServletRequest request, Model model) {
        return "globalChat";
    }
}
