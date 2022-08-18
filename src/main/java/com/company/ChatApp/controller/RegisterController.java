
package com.company.ChatApp.controller;

import com.company.ChatApp.dto.UserDTO;
import com.company.ChatApp.service.UserService;
import com.company.entity.User;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    UserService userService;

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource
                = new ReloadableResourceBundleMessageSource();

        messageSource.setBasename("classpath:messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @GetMapping
    public String showRegistrationForm(WebRequest request, Model model) {
        UserDTO userDto = new UserDTO();
        model.addAttribute("user", userDto);
        return "register";
    }

    @PostMapping
    public ModelAndView registerUserAccount(
            @ModelAttribute("user") @Valid UserDTO userDto, BindingResult result,
            HttpServletRequest request) throws Exception {
        try {
            if (result.hasErrors()) {
                Object obj = result.getAllErrors().get(0);
                ObjectError objectError = null;
                if (obj instanceof ObjectError) {
                    objectError = (ObjectError) obj;
                }
                String message = messageSource().getMessage(objectError, null);
                throw new Exception(message);
            }
        } catch (Exception ex) {
            ModelAndView mv = new ModelAndView();
            mv.addObject("message", ex.getMessage());
            return mv;
        }
        try {
            User registered = userService.registerNewUserAccount(userDto);
        } catch (Exception ex) {
            ModelAndView mv = new ModelAndView();
            mv.addObject("message", ex.getMessage());
            return mv;
        }
        return new ModelAndView("chat", "user", userDto);
    }
}
