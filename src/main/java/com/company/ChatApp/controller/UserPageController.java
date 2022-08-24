package com.company.ChatApp.controller;

import com.company.ChatApp.dto.UserDTO;
import com.company.entity.User;
import com.company.service.UserDAOService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class UserPageController {

    @Autowired
    UserDAOService userService;

    @GetMapping("users")
    public ModelAndView showUsersPage(HttpServletRequest request) {
        List<UserDTO> usersList = new ArrayList<UserDTO>();
        List<User> users = userService.getAll();
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
}
