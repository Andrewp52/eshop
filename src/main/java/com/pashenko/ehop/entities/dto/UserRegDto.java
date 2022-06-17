package com.pashenko.ehop.entities.dto;

import lombok.Data;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class UserRegDto {
    @NotBlank
    @Email
    private String userName;
    @NotBlank
    private String password;
    @NotBlank
    private String repPassword;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private String address;
    @NotBlank
    private String phone;

    public boolean isPasswordMatch(){
        return password != null && password.equals(repPassword);
    }
}
