/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.ChatApp.controller;

import com.company.service.UserDAOService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author roma-cervice
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    UserDAOService userService;
    
    @RequestMapping(method=RequestMethod.GET)
    public String index(HttpServletRequest request){
        return "login";
    }
}
