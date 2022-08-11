/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.ChatApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author roma-cervice
 */
@Controller
@RequestMapping("/settings")
public class SettingsController {
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView showEditPage(){
    ModelAndView mv = new ModelAndView("settings");
    return mv;
    }
}
