
package com.company.ChatApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PrivateChatController {
    @GetMapping("/privateChat")
    public String showPrivateChat(){
        return "privateChat";
    }
}
