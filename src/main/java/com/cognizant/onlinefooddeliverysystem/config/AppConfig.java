package com.cognizant.onlinefooddeliverysystem.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class randomConfig {

    @Bean
    public ModelMapper modelMapper() {
        return  new ModelMapper();
    }
}
