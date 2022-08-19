package com.company.ChatApp.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessagesController {

    private List<String> messages = new ArrayList<String>();

    @PostMapping("/messages")
    public ResponseEntity<List> showChatPage(@RequestParam(value = "message", required = false) String message) {
        messages.add(message);
        return ResponseEntity.ok(messages);
    }
}
