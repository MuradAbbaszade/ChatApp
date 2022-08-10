/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.ChatApp.controller;

import com.company.ChatApp.form.UserForm;
import com.company.entity.User;
import com.company.service.UserDAOService;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    UserDAOService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showRegisterPage() {
        ModelAndView mv = new ModelAndView("register");
        return mv;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public ModelAndView register(@Valid UserForm userForm,BindingResult result,@RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "email", required = false) String email, @RequestParam(value = "password", required = false) String password,
            @RequestParam(value = "repassword", required = false) String repassword) {
        ModelAndView mv = null;
        RedirectView view=null;
        if (result.hasErrors()|!(password.equals(repassword))|userService.findByEmail(email)) {
            mv = new ModelAndView("register");
            view = new RedirectView("/register", true);
        } else {
            userService.insert(new User(0,name,email,password));
            mv = new ModelAndView("chat");
            view = new RedirectView("/chat", true);
        }
        view.setExposeModelAttributes(false);
        mv.setView(view);
        return mv;
    }

}
