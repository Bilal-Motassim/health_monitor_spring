package com.example.healthmonitorspring.services.impl;

import com.example.healthmonitorspring.dto.LoginRequest;
import com.example.healthmonitorspring.dto.LoginResponse;
import com.example.healthmonitorspring.entities.User;
import com.example.healthmonitorspring.repositories.UserRepository;
import com.example.healthmonitorspring.services.AuthService;
import com.example.healthmonitorspring.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;



    @Override
    public boolean register(User user){
        if (userRepository.findByEmail(user.getEmail())!=null) {
            return false;
        }

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());

        user.setPassword(encodedPassword);
        User user1= userRepository.save(user);
        if(user1!=null){
            return true;
        }
        return false;
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginRequest.getEmail(),
                loginRequest.getPassword()
        ));

        if(authentication.isAuthenticated()){
            User user = userRepository.findByEmail(loginRequest.getEmail());
            LoginResponse response = new LoginResponse();
            response.setAuthToken(jwtUtils.GenerateToken(loginRequest.getEmail()));
            response.setId(user.getId());
            response.setFirstname(user.getFirstName());
            response.setLastname(user.getLastName());
            response.setEmail(user.getEmail());
            return response;
        } else {
            return null;
        }

    }
}
