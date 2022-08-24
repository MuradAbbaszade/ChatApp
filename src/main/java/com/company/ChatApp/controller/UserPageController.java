package com.company.ChatApp.controller;

import com.company.ChatApp.dto.UserDTO;
import com.company.entity.User;
import com.company.service.UserDAOService;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserPageController {

    @Autowired
    UserDAOService userService;

    @GetMapping("searchuser")
    public ModelAndView searchUsers(HttpServletRequest request,
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
        ModelAndView mv = new ModelAndView("users");
        mv.addObject("users", usersList);
        return mv;
    }

    @GetMapping("users")
    public ModelAndView showUsersPage(HttpServletRequest request,
            @RequestParam(value = "name", required = false) String name) {
        List<UserDTO> usersList = new ArrayList<UserDTO>();
        List<User> users;
        users = userService.getAll();
        for (User user : users) {
            if (!user.getEmail().equals(request.getRemoteUser())) {
                UserDTO userDTO = new UserDTO();
                userDTO.setName(user.getName());
                userDTO.setEmail(user.getEmail());
                userDTO.setId(user.getId());
                usersList.add(userDTO);
            }
        }
        String remoteUserEmail =  request.getRemoteUser();
        int remoteUserId =  userService.findByEmail(remoteUserEmail).getId();
        ModelAndView mv = new ModelAndView("users");
        mv.addObject("users", usersList);
        mv.addObject("remoteUserId", remoteUserId);
        return mv;
    }
}
