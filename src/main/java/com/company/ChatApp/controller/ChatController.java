/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.ChatApp.controller;

import com.company.ChatApp.form.LoggedInUser;
import com.company.ChatApp.form.UserForm;
import com.company.entity.User;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

@Controller
@RequestMapping("/chat")
public class ChatController {

    private ArrayList<UserForm> usersAndMessages = new ArrayList<UserForm>();

    public ArrayList<UserForm> getMessages() {
        return usersAndMessages;
    }

    @Controller
    @RequestMapping("/chat")
    public class SuccessRegistrationController {

     @GetMapping
        public String showRegistrationForm(WebRequest request, Model model) {
            return "chat";
        }
    }

    @PostMapping
    public void sendMessage(HttpServletRequest request,
            HttpSession session,
            HttpServletResponse response,
            @RequestParam(value = "message", required = false) String message) throws IOException {
        session.setAttribute("message", message);
        response.sendRedirect("messages");
        /*User user = (User) request.getSession().getAttribute("loggedInUser");

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("d MMM yyyy HH:mm");
        String strDate = formatter.format(date);
        UserForm userForm = new UserForm(user.getName(), message, strDate);

        usersAndMessages.add(userForm);

        request.getSession()
                .setAttribute("usersAndMessages", usersAndMessages);
        response.sendRedirect(
                "chat");*/
    }
}
