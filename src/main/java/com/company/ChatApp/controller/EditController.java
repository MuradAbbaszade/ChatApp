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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/edit")
public class EditController {

    @Autowired
    UserDAOService userService;

    @GetMapping
    public String showEditPage(HttpServletRequest request) {
        return "edit";
    }

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource
                = new ReloadableResourceBundleMessageSource();

        messageSource.setBasename("classpath:messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @PostMapping
    public ModelAndView edit(HttpServletRequest request,
            @ModelAttribute("userForm") @Valid EditUserDTO editUserDto, BindingResult result,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "email", required = false) String email) {
        ModelAndView mv = null;
        RedirectView view = null;
        String remoteUserEmail = request.getRemoteUser();
        User user = userService.findByEmail(remoteUserEmail);

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
        }catch (Exception ex) {
            mv = new ModelAndView("edit");
            mv.addObject("message", ex.getMessage());
            return mv;
        }
        if (userService.findByEmail(email) != null && !(email.equals(user.getEmail()))) {
            mv = new ModelAndView("edit");
            view = new RedirectView("/edit", true);
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
            mv = new ModelAndView("chat");
            view = new RedirectView("/chat", true);
        }
        mv.setView(view);
        return mv;
    }
}
