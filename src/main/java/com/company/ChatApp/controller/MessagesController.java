package com.company.ChatApp.controller;

import com.company.ChatApp.dto.MessageDTO;
import com.company.service.UserDAOService;
import com.company.entity.User;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessagesController {
 
    @Autowired
    UserDAOService userService;
    
    private List<MessageDTO> messages = new ArrayList<MessageDTO>();

    @PostMapping("/message")
    public ResponseEntity<List> addMessage(@RequestParam(value = "email", required = false) String email,
            @RequestParam(value = "date", required = false) String date,
            @RequestParam(value = "message", required = false) String message) {
        User user = userService.findByEmail(email);
        String name = user.getName();
        MessageDTO messageDto = new MessageDTO(name,message,date);
        messages.add(messageDto);
        return ResponseEntity.ok(messages);
    }
    
    @GetMapping("/message")
    public ResponseEntity<List> showMessages() {
        return ResponseEntity.ok(messages);
    }
}
