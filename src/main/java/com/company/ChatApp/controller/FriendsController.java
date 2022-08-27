package com.company.ChatApp.controller;

import com.company.entity.Friend;
import com.company.service.FriendDAOService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FriendsController {

    @Autowired
    FriendDAOService friendService;

    @GetMapping("/friends")
    public ModelAndView showFriendsPage() {
        ModelAndView mv = new ModelAndView("friends");
        List<Friend> friends = friendService.getAllFriends();
        mv.addObject("friends",friends);
        return mv;
    }
}
