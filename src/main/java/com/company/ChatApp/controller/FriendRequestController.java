package com.company.ChatApp.controller;

import com.company.service.FriendDAOService;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class FriendRequestController {

    @Autowired
    FriendDAOService friendService;

    @GetMapping("friend-requests")
    public ModelAndView getRequestButton(HttpServletResponse response,
            @RequestParam(value = "button", required = false) String button,
            @RequestParam(value = "fromUserId", required = false) int fromUserId,
            @RequestParam(value = "toUserId", required = false) int toUserId,
            @RequestParam(value = "name", required = false) String name) throws IOException {
        if (button.equals("send")) {
            System.out.println(fromUserId + " " + toUserId);
            friendService.sendFriendRequest(fromUserId, toUserId);
        } else if (button.equals("delete")) {
            int requestId = friendService.getRequestId(fromUserId, toUserId);
            friendService.declineFriendRequest(requestId);
        } else if (button.equals("accept")) {
            int requestId = friendService.getRequestId(fromUserId, toUserId);
            friendService.acceptFriendRequest(requestId);
        } else if (button.equals("deleteFriend")) {
            Integer friendId = friendService.getFriendsId(fromUserId, toUserId);
            if (friendId == null) {
                friendId = friendService.getFriendsId(toUserId, fromUserId);
            }
            friendService.deleteFriend(friendId);
        }
        ModelAndView mv = new ModelAndView("users");
        if(name==null) name="";
        RedirectView view = new RedirectView("users?name="+name);
        mv.setView(view);
        return mv;
    }
}
