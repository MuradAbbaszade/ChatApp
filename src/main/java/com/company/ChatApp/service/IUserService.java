
package com.company.ChatApp.service;

import com.company.ChatApp.dto.UserDTO;
import com.company.entity.User;

public interface IUserService {
    User registerNewUserAccount(UserDTO userDto) throws Exception;
}
