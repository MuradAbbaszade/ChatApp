/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.ChatApp.controller;

import com.company.ChatApp.form.UserForm;
import com.company.service.UserDAOService;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author roma-cervice
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    UserDAOService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String showLoginPage(HttpServletRequest request) {
        return "login";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public ModelAndView register(@Valid UserForm userForm, BindingResult result,
            @RequestParam(value = "email", required = false) String email,
            @RequestParam(value = "password", required = false) String password) {
        
        ModelAndView mv = null;
        RedirectView view = null;
        if (result.hasErrors() | userService.findByEmailAndPassword(email, password)==null) {
            mv = new ModelAndView("login");
            view = new RedirectView("/login", true);
        } else {
            mv = new ModelAndView("chat");
            view = new RedirectView("/chat", true);
        }
        view.setExposeModelAttributes(false);
        mv.setView(view);
        return mv;
    }
}
