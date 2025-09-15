package com.cognizant.onlinefooddeliverysystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration // Marks this class as a source of bean definitions
public class SecurityConfig {

    @Bean // Tells Spring to create a bean for BCryptPasswordEncoder
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}