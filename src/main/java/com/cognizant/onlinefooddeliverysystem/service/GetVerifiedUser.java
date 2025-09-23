package com.cognizant.onlinefooddeliverysystem.service;

import com.cognizant.onlinefooddeliverysystem.exception.ResourceNotFoundException;
import com.cognizant.onlinefooddeliverysystem.model.User;
import com.cognizant.onlinefooddeliverysystem.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class GetVerifiedUser {
    private final UserRepository userRepository;

    public User getVerifiedUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication == null){
            throw new ResourceNotFoundException("User is not found!");
        }
        String username = (String) authentication.getPrincipal();
        return userRepository.findUserByEmail(username).orElseThrow(() ->
                new ResourceNotFoundException("User not found with email : " + username)
        );

    }
}
