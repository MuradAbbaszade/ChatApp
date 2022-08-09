/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.ChatApp.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/register")
public class RegisterController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("register");
        return mv;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public ModelAndView index1(@RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "email", required = false) String email, @RequestParam(value = "password", required = false) String password,
            @RequestParam(value = "repassword", required = false) String repassword) {
        ModelAndView mv = null;
        RedirectView view=null;
        if (password.equals(repassword)) {
            mv = new ModelAndView("login");
            view = new RedirectView("/login", true);
        } else {
            mv = new ModelAndView("register");
            view = new RedirectView("/register", true);
        }
        view.setExposeModelAttributes(false);
        mv.setView(view);
        return mv;
    }

}
