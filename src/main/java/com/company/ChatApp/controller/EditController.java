/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.ChatApp.controller;

import com.company.ChatApp.form.UserForm;
import com.company.entity.User;
import com.company.service.UserDAOService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
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
@RequestMapping("/edit")
public class EditController {

    @Autowired
    UserDAOService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String showEditPage(HttpServletRequest request) {
        if (request.getSession().getAttribute("loggedInUser") == null) {
            return "login";
        } else {
            return "edit";
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public ModelAndView edit(HttpServletRequest request,
            @ModelAttribute("userForm") @Valid UserForm userForm, BindingResult result,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "email", required = false) String email,
            @RequestParam(value = "password", required = false) String password,
            @RequestParam(value = "repassword", required = false) String repassword) {
        ModelAndView mv = null;
        RedirectView view = null;
        if (result.hasErrors() | !(password.equals(repassword)) | userService.findByEmail(email)) {
            mv = new ModelAndView("login");
            view = new RedirectView("/login", true);
        } else {
            User user = (User) request.getSession().getAttribute("loggedInUser");
            user.setName(name);
            user.setEmail(email);
            user.setPassword(password);
            userService.update(user);
            mv = new ModelAndView("chat");
            view = new RedirectView("/chat", true);
        }
        mv.setView(view);
        return mv;
    }
}
