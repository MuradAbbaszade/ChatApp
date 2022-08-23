package com.company.ChatApp.controller;

import com.company.ChatApp.dto.UserDTO;
import com.company.entity.User;
import com.company.service.UserDAOService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserPageController {

    @Autowired
    UserDAOService userService;

    @GetMapping("/userslist")
    public ResponseEntity<List> getUsers(HttpServletResponse response) throws IOException {
        List<UserDTO> usersList = new ArrayList<UserDTO>();
        List<User> users = userService.getAll();
        for (User user : users) {
            UserDTO userDTO = new UserDTO();
            userDTO.setName(user.getName());
            usersList.add(userDTO);
        }
        return ResponseEntity.ok(usersList);
    }
}
