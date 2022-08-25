/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.ChatApp.controller;

import com.company.ChatApp.dto.FriendRequestDTO;
import com.company.entity.FriendRequest;
import com.company.service.FriendDAOService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author roma-cervice
 */
@Controller
public class FriendRequestController {
    @Autowired
    FriendDAOService friendService;
    
    @GetMapping("friend-requests")
    public void showRequests(HttpServletResponse response,
            @RequestParam(value="button",required=false)String button,
            @RequestParam(value="fromUserId",required=false)int fromUserId,
            @RequestParam(value="toUserId",required=false)int toUserId) throws IOException{
        if(button.equals("send")){
            System.out.println(fromUserId+" "+toUserId);
            friendService.sendFriendRequest(fromUserId,toUserId);
        }
        response.sendRedirect("users");
    }
}
