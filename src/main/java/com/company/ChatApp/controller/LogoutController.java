/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.ChatApp.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author roma-cervice
 */
@Controller
@RequestMapping("/logout")
public class LogoutController {
    @GetMapping
    public ModelAndView logout(HttpServletRequest request){
        ModelAndView mv = new ModelAndView("login");
        RedirectView view = new RedirectView("/login");
        mv.setView(view);
        return mv;
    }
    
}
