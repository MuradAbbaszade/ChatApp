package com.company.ChatApp.controller;

import com.company.service.UserDAOService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GlobalChatController {

    @Autowired
    UserDAOService userService;
    
    @GetMapping("/globalChat")
    public ModelAndView showChatPage(HttpServletRequest request, Model model) {
        ModelAndView mv = new ModelAndView("globalChat");
        String email = request.getRemoteUser();
        String name = userService.findByEmail(email).getName();
        mv.addObject("name",name);
        mv.addObject("email",email);
        return mv;
    }
}
