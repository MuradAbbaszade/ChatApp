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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author roma-cervice
 */
@RestController
public class FriendRequestController {
    @Autowired
    FriendDAOService friendService;
    
    List<FriendRequestDTO> requests = new ArrayList<FriendRequestDTO>();
    @GetMapping("friend-requests")
    public ResponseEntity<List> showRequests(HttpServletResponse response) throws IOException {
        List<FriendRequest> friendRequests = friendService.getAllRequest();
        for(FriendRequest request : friendRequests){
            int id = request.getId();
            int fromUserId = request.getFromUser().getId();
            int toUserId = request.getToUser().getId();
            FriendRequestDTO requestDTO = new FriendRequestDTO(id,fromUserId,toUserId);
            requests.add(requestDTO);
        }
        return ResponseEntity.ok(requests);
    }
}
