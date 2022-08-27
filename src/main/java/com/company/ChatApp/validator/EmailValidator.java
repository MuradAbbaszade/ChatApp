package com.company.ChatApp.validator;

import com.company.ChatApp.annotation.EmailExist;
import com.company.ChatApp.dto.UserDTO;
import com.company.entity.User;
import com.company.service.UserDAOService;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class EmailValidator
  implements ConstraintValidator<EmailExist, Object> {
    
    @Autowired
    UserDAOService userService;
    
    @Override
    public void initialize(EmailExist constraintAnnotation) {
    }
    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context){
        UserDTO userDto = (UserDTO) obj;
        User user = userService.findByEmail(userDto.getEmail());
        return user==null;
    }
}