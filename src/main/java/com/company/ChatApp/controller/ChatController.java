/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.ChatApp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/chat")
public class ChatController {
    
    @RequestMapping(method = RequestMethod.GET)
    public String showChatPage(HttpServletRequest request,HttpServletResponse response){
        if(request.getSession().getAttribute("loggedInUser")==null){
            return "login";
        }
        else{
            return "chat";
        }
    }
}
