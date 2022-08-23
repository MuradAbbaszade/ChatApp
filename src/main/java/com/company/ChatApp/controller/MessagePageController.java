
package com.company.ChatApp.controller;

import com.company.ChatApp.dto.UserDTO;
import com.company.ChatApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
@RequestMapping("/message-page")
public class MessagePageController {

    @Autowired
    UserService userService;
    
    @GetMapping
    public String showMessagePage(WebRequest request, Model model) {
        UserDTO userDto = new UserDTO();
        model.addAttribute("user", userDto);
        return "message-page";
    }
}
