/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.ChatApp.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 *
 * @author roma-cervice
 */
public class EditUserDTO {

    @NotEmpty(message = "Please fill the all fields")
    @Size(min = 2, max = 15, message = "Name size must be between 2 and 15")
    private String name;
    @NotEmpty(message = "Please fill the all fields")
    @Size(min = 11, max = 35, message = "Email size must be between 11 and 35")
    private String email;
    @NotEmpty(message = "Please fill the all fields")
    @Size(min = 3, max = 25, message = "Password size must be between 3 and 25")

    public String getName() {
        return name;
    }

    public EditUserDTO(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
