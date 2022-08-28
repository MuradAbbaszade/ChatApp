package com.company.ChatApp.controller;

import com.company.ChatApp.dto.EditUserDTO;
import com.company.entity.User;
import com.company.service.UserDAOService;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class EditController {

    @Autowired
    UserDAOService userService;

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource
                = new ReloadableResourceBundleMessageSource();

        messageSource.setBasename("classpath:messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @GetMapping("/edit")
    public ModelAndView showEditPage(HttpServletRequest request) {
        String remoteUserEmail = request.getRemoteUser();
        User user = userService.findByEmail(remoteUserEmail);
        ModelAndView mv = new ModelAndView("edit");
        mv.addObject("user",user);
        return mv;
    }

   @PostMapping("/edit")
    public ModelAndView edit(HttpServletRequest request,
            @ModelAttribute("userForm") @Valid EditUserDTO editUserDto, BindingResult result,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "email", required = false) String email) {

        ModelAndView mv = null;
        RedirectView view = null;
        String remoteUserEmail = request.getRemoteUser();
        User user = userService.findByEmail(remoteUserEmail);
        String remoteUserName = user.getName();

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
            mv = new ModelAndView("edit");
            mv.addObject("message", ex.getMessage());
            return mv;
        }
        if (userService.findByEmail(email) != null && !(email.equals(user.getEmail()))) {
            mv = new ModelAndView("edit");
            mv.addObject("message", "Email already exist");
        } else {
            user.setName(name);
            user.setEmail(email);
            if (!(remoteUserEmail.equals(email))) {
                userService.update(user);
                request.getSession().invalidate();
                mv = new ModelAndView("login");
                view = new RedirectView("/login", true);
                mv.setView(view);
                return mv;
            }
            userService.update(user);
            mv = new ModelAndView("main");
            view = new RedirectView("/main", true);
        }
        mv.setView(view);
        return mv;
    }
}
