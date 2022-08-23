package com.company.ChatApp.service;

import com.company.ChatApp.dto.UserDTO;
import com.company.daoImpl.UserDAOImpl;
import com.company.entity.User;
import java.util.Arrays;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService implements IUserService {
    @Autowired
    private UserDAOImpl userDAO;
    
    @Override
    public User registerNewUserAccount(UserDTO userDto) throws Exception{
        if (emailExists(userDto.getEmail())) {
            throw new Exception("There is an account with that email address: "
              + userDto.getEmail());
        }
        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        return userDAO.insert(user);
    }

    private boolean emailExists(String email) {
        return userDAO.findByEmail(email) != null;
    }
}
