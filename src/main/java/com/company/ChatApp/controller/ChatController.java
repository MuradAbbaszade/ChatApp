/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.ChatApp.controller;

import com.company.ChatApp.form.LoggedInUser;
import com.company.entity.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/chat")
public class ChatController {
    
    private ArrayList<LoggedInUser> messages = new ArrayList<LoggedInUser>();

    public ArrayList<LoggedInUser> getMessages() {
        return messages;
    }

@RequestMapping(method = RequestMethod.GET)
    public String showChatPage(HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        if (request.getSession().getAttribute("loggedInUser") == null) {
            return "login";
        } else {
            return "chat";
        }
    }

@RequestMapping(method = RequestMethod.POST)
    public void sendMessage(HttpServletRequest request,
            HttpServletResponse response,
            @RequestParam(value = "message", required = false) String message) throws IOException {
        User user = (User)request.getSession().getAttribute("loggedInUser");
        LoggedInUser loggedInUser = new LoggedInUser(user.getName(),message);
        messages.add(loggedInUser);
        request.getSession().setAttribute("messages", messages);
        response.sendRedirect("chat");
    }
}
