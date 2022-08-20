package com.company.ChatApp.controller;

import com.company.ChatApp.dto.MessageDTO;
import com.company.service.UserDAOService;
import com.company.entity.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
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

    @PostMapping("/messages")
    public ResponseEntity<List> addMessage(@RequestParam(value = "email", required = false) String email,
            @RequestParam(value = "date", required = false) String date,
            @RequestParam(value = "message", required = false) String message,
            HttpServletResponse response ) throws IOException{
        User user = userService.findByEmail(email);
        String name = user.getName();
        MessageDTO messageDto = new MessageDTO(name,message,date);
        messages.add(messageDto);
        response.sendRedirect("chat");
        return ResponseEntity.ok(messages);
    }
    
    @GetMapping("/messages")
    public ResponseEntity<List> showMessages() {
        return ResponseEntity.ok(messages);
    }
}
