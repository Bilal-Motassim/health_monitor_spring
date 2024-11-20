package com.example.healthmonitorspring.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class RegisterRequest {

    private String firstName;

    private String lastName;

    @Email
    private String email;

    private String password;
}
