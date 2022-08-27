package com.company.ChatApp.controller;

import com.company.ChatApp.dto.MessageDTO;
import com.company.entity.User;
import com.company.service.UserDAOService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrivateMessagesController {

    @Autowired
    UserDAOService userService;
    
    private Map<Integer, List<MessageDTO>> messages = new TreeMap<Integer, List<MessageDTO>>();

    @GetMapping("/privateMessages/{id}")
    public ResponseEntity<List> showMessages(@PathVariable("id") int id){
        return ResponseEntity.ok(messages.get(id));
    }
    @PostMapping("/privateMessages/{id}")
    public ResponseEntity<List> addMessage(@PathVariable("id") int id,
            @RequestParam(value = "email", required = false) String email,
            @RequestParam(value = "date", required = false) String date,
            @RequestParam(value = "message", required = false) String message,
            HttpServletResponse response) throws IOException {
        User user = userService.findByEmail(email);
        String name = user.getName();
        MessageDTO messageDto = new MessageDTO(email, name, message, date);
        List<MessageDTO> privateMessages = messages.get(id);
        if(privateMessages==null && !message.equals("")){
            privateMessages = new ArrayList<MessageDTO>();
            privateMessages.add(messageDto);
            System.out.println(privateMessages);
            messages.put(id, privateMessages);
        }
        else if (!message.equals("")) {
            privateMessages.add(messageDto);
            messages.replace(id, privateMessages);
        }
        System.out.println(messages.get(id));
        response.sendRedirect("/ChatAppWeb/privateChat/"+id);
        return ResponseEntity.ok(messages.get(id));
    }
}
