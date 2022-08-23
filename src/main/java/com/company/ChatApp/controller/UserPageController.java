package com.company.ChatApp.controller;

import com.company.entity.User;
import com.company.service.UserDAOService;
import java.util.ArrayList;
import java.util.List;
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

    private List<User> users = new ArrayList<User>();

    @GetMapping("/users")
    public ResponseEntity<List> getUsers() {
        return ResponseEntity.ok(users);
    }

    @PostMapping("/users")
    public ResponseEntity<List> setUsers() {
        users = userService.getAll();
        return ResponseEntity.ok(users);
    }
}
