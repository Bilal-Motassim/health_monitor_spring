package com.example.healthmonitorspring.mapper;

import com.example.healthmonitorspring.dto.RegisterRequest;
import com.example.healthmonitorspring.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User toEntity(RegisterRequest registerRequest) {
        User user = new User();
        user.setFirstName(registerRequest.getFirstName());
        user.setLastName(registerRequest.getLastName());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(registerRequest.getPassword());
        return user;
    }
}
