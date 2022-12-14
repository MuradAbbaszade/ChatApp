package com.company.ChatApp.validator;

import com.company.ChatApp.annotation.PasswordMatches;
import com.company.ChatApp.dto.UserDTO;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator
  implements ConstraintValidator<PasswordMatches, Object> {
    
    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
    }
    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context){
        UserDTO user = (UserDTO) obj;
        return user.getPassword().equals(user.getMatchingPassword());
    }
}
