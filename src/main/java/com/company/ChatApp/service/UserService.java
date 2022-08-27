package com.company.ChatApp.service;

import com.company.ChatApp.dto.UserDTO;
import com.company.daoImpl.UserDAOImpl;
import com.company.entity.User;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService implements IUserService {
    @Autowired
    private UserDAOImpl userDAO;
    
    @Override
    public User registerNewUserAccount(UserDTO userDto){
        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        return userDAO.insert(user);
    }
}
