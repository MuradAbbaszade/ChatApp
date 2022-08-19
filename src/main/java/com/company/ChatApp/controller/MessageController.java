package com.company.ChatApp.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/message")
public class MessageController {

    private List<String> messages = new ArrayList<String>();
    
    @GetMapping
    public String showPage() {
        return "messages";
    }

}
