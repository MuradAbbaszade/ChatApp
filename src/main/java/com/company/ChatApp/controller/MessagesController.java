
package com.company.ChatApp.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
@RequestMapping("/messages")
public class MessagesController {

    @RequestMapping(method = RequestMethod.GET)
    public String showChatPage(HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        if (request.getSession().getAttribute("loggedInUser") == null) {
            return "login";
        } else {
            return "messages";
        }
    }
}
