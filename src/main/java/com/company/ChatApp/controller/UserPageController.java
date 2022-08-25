package com.company.ChatApp.controller;

import com.company.ChatApp.dto.FriendDTO;
import com.company.ChatApp.dto.FriendRequestDTO;
import com.company.ChatApp.dto.UserDTO;
import com.company.entity.Friend;
import com.company.entity.FriendRequest;
import com.company.entity.User;
import com.company.service.FriendDAOService;
import com.company.service.UserDAOService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class UserPageController {

    @Autowired
    UserDAOService userService;

    @Autowired
    FriendDAOService friendService;
    
    @GetMapping("users")
    public ModelAndView showUsersPage(HttpServletRequest request,
            @RequestParam(value = "name", required = false) String name) {

        List<UserDTO> usersList = new ArrayList<UserDTO>();
        List<User> users;
        if (name == null) {
            users = userService.getAll();
        } else if (name.equals("")) {
            users = userService.getAll();
        } else {
            users = userService.findByName(name);
        }
        for (User user : users) {
            if (!user.getEmail().equals(request.getRemoteUser())) {
                UserDTO userDTO = new UserDTO();
                userDTO.setName(user.getName());
                userDTO.setEmail(user.getEmail());
                userDTO.setId(user.getId());
                usersList.add(userDTO);
            }
        }
        List<FriendRequestDTO> friendRequestsDTO = new ArrayList<FriendRequestDTO>();
        List<FriendRequest> friendRequests = friendService.getAllRequest();
        for (FriendRequest friendRequest : friendRequests) {
            int id = friendRequest.getId();
            int fromUserId = friendRequest.getFromUser().getId();
            int toUserId = friendRequest.getToUser().getId();
            FriendRequestDTO requestDTO = new FriendRequestDTO(id, fromUserId, toUserId);
            friendRequestsDTO.add(requestDTO);
        }
        List<FriendDTO> friendsDTO = new ArrayList<FriendDTO>();
        List<Friend> friends = friendService.getAllFriends();
        for (Friend friend : friends) {
            int id = friend.getId();
            int userId = friend.getUser().getId();
            int friendId = friend.getFriend().getId();
            FriendDTO friendDTO = new FriendDTO(id, userId, friendId);
            friendsDTO.add(friendDTO);
        }
        String remoteUserEmail = request.getRemoteUser();
        int remoteUserId = userService.findByEmail(remoteUserEmail).getId();
        ModelAndView mv = new ModelAndView("users");
        mv.addObject("friends", friendsDTO);
        mv.addObject("requests", friendRequestsDTO);
        mv.addObject("users", usersList);
        mv.addObject("remoteUserId", remoteUserId);
        return mv;
    }
}
