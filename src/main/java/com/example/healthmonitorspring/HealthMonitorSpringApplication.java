package com.example.healthmonitorspring;

import com.example.healthmonitorspring.dto.RegisterRequest;
import com.example.healthmonitorspring.entities.User;
import com.example.healthmonitorspring.mapper.UserMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HealthMonitorSpringApplication {
    public static void main(String[] args) {
        SpringApplication.run(HealthMonitorSpringApplication.class, args);
    }

}
