package com.company.ChatApp.controller;

import com.company.ChatApp.dto.UserDTO;
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
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/edit")
public class EditController {

    @Autowired
    UserDAOService userService;

    private static User u = null;

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource
                = new ReloadableResourceBundleMessageSource();

        messageSource.setBasename("classpath:messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @GetMapping
    public String showEditPage(HttpServletRequest request) {
        u = userService.findByEmail(request.getRemoteUser());
        return "edit";
    }

    @PostMapping
    public ModelAndView edit(HttpServletRequest request,
            @ModelAttribute("user") @Valid UserDTO userDto, BindingResult result) {
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
        User user = getRemoteUser();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        userService.update(user);
        return new ModelAndView("chat", "user", userDto);
    }

    public static User getRemoteUser() {
        return u;
    }
}
