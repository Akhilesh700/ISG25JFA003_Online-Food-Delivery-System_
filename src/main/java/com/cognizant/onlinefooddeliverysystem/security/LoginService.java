package com.cognizant.onlinefooddeliverysystem.security;

import com.cognizant.onlinefooddeliverysystem.dto.login.LoginRequestDto;
import com.cognizant.onlinefooddeliverysystem.dto.login.LoginResponseDto;
import com.cognizant.onlinefooddeliverysystem.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {
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
        return new LoginResponseDto(authToken, user.getUserId());
    }
}
