/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.ChatApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 *
 * @author roma-cervice
 */
@Controller
@RequestMapping("/termsOfService")
public class TermsOfServiceController {
    @RequestMapping(method=RequestMethod.GET)
    public String showPage(){
        return "termsOfService";
    }
}
