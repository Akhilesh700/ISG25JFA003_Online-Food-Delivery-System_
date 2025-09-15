package com.cognizant.onlinefooddeliverysystem.controller;

import com.cognizant.onlinefooddeliverysystem.dto.LoginRequestDto;
import com.cognizant.onlinefooddeliverysystem.dto.LoginResponseDto;
import com.cognizant.onlinefooddeliverysystem.dto.SignUpResponseDto;
import com.cognizant.onlinefooddeliverysystem.security.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("${api.version.path}/auth")
@RequiredArgsConstructor
@RestController
public class AuthController {

    private final AuthService service;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequestDto){
        return ResponseEntity.ok(service.login(loginRequestDto));
    }


}
