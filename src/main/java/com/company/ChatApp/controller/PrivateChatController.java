package com.company.ChatApp.controller;

import com.company.entity.Friend;
import com.company.service.FriendDAOService;
import com.company.service.UserDAOService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PrivateChatController {

    @Autowired
    UserDAOService userService;

    @Autowired
    FriendDAOService friendService;

    @GetMapping("privateChat/{id}")
    public ModelAndView showChat(@PathVariable("id") int id,
            HttpServletRequest request) {
        ModelAndView mv = new ModelAndView("privateChat");
        mv.addObject("friendId", id);
        String email = request.getRemoteUser();
        String name = userService.findByEmail(email).getName();
        mv.addObject("email", email);
        mv.addObject("name", name);
        return mv;
    }

    @PostMapping("privateChat/{id}")
    public ModelAndView showChatPage(@PathVariable("id") int id,
            HttpServletRequest request) {
        ModelAndView mv = new ModelAndView("privateChat");
        String email = request.getRemoteUser();
        String name = userService.findByEmail(email).getName();
        List<Friend> friends = friendService.getAllFriends();
        mv.addObject("friends", friends);
        mv.addObject("name", name);
        mv.addObject("email", email);
        mv.addObject("friendId", id);
        return mv;
    }
}
