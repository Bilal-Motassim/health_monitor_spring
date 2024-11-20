package com.example.healthmonitorspring.services;

import com.example.healthmonitorspring.dto.LoginRequest;
import com.example.healthmonitorspring.dto.LoginResponse;
import com.example.healthmonitorspring.entities.User;

public interface AuthService {
    boolean register(User user);
    LoginResponse login(LoginRequest loginRequest);
}
