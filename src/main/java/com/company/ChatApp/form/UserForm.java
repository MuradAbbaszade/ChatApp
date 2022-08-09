
package com.company.ChatApp.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


public class UserForm {
    @NotEmpty(message="This field cannot be empty")
    @Size(min=3,max=30,message="Size is not valid")
    private String name;
    @NotEmpty(message="This field cannot be empty")
    @Size(min=13,max=30,message="Size is not valid")
    private String email;
    @NotEmpty(message="This field cannot be empty")
    @Size(min=3,max=30,message="Size is not valid")
    private String password;
    @NotEmpty(message="This field cannot be empty")
    @Size(min=3,max=30,message="Size is not valid")
    private String repassword;

    public UserForm() {
    }

    public UserForm(String name, String email, String password, String repassword) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.repassword = repassword;
    }
        public UserForm(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepassword() {
        return repassword;
    }

    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }
}
