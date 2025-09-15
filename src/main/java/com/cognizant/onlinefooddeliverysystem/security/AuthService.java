package com.cognizant.onlinefooddeliverysystem.security;

import com.cognizant.onlinefooddeliverysystem.dto.LoginRequestDto;
import com.cognizant.onlinefooddeliverysystem.dto.LoginResponseDto;
import com.cognizant.onlinefooddeliverysystem.model.User;
import com.cognizant.onlinefooddeliverysystem.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.net.Authenticator;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final AuthUtil authUtil;
    private final AuthenticationManager authenticationManager;

    public LoginResponseDto login(LoginRequestDto loginRequestDto) {
//        Authentication of User from DAO
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequestDto.getUsername(), loginRequestDto.getPassword())
        );
        User user = (User) authentication.getPrincipal();

//      Generating the auth token with user object
        String authToken = authUtil.generateJwtToken(user);


//      Returning the loginResonseDto object with authToken and userId
        return new LoginResponseDto(authToken, user.getUserId(), user.getRole().toString());
    }
}
