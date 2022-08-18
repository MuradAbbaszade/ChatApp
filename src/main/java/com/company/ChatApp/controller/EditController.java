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
        return "edit";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/")
    public ModelAndView edit(HttpServletRequest request,
            @ModelAttribute("userForm") @Valid UserForm userForm, BindingResult result,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "email", required = false) String email) {
        ModelAndView mv = null;
        RedirectView view = null;
        User user = (User) request.getSession().getAttribute("loggedInUser");

        if (result.hasErrors()) {
            mv = new ModelAndView("edit");
            view = new RedirectView("/edit", true);
        } else if ((userService.findByEmail(email)==null) && !(email.equals(user.getEmail()))) {
            mv = new ModelAndView("edit");
            view = new RedirectView("/edit", true);
        } else {
            user.setName(name);
            user.setEmail(email);
            userService.update(user);
            mv = new ModelAndView("chat");
            view = new RedirectView("/chat", true);
        }
        mv.setView(view);
        return mv;
    }

    public static String getLoggedInUserName(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("loggedInUser");
        return user.getName();
    }

    public static String getLoggedInUserEmail(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("loggedInUser");
        return user.getEmail();
    }
}
