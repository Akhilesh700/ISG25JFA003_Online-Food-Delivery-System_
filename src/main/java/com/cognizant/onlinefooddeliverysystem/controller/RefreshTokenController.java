package com.cognizant.onlinefooddeliverysystem.controller;

import com.cognizant.onlinefooddeliverysystem.dto.refreshtoken.RefreshTokenDto;
import com.cognizant.onlinefooddeliverysystem.dto.refreshtoken.RefreshTokenResponseDto;
import com.cognizant.onlinefooddeliverysystem.service.RefreshTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${api.version.path}/auth")
@RequiredArgsConstructor
public class RefreshTokenController {

    private final RefreshTokenService refreshTokenService;

    @PostMapping("refresh")
    public ResponseEntity<RefreshTokenResponseDto> generateJwtTokenByRefreshToken(@RequestBody RefreshTokenDto refreshTokenDto){
        return new ResponseEntity<>(refreshTokenService.generateJwtTokenByRefreshToken(refreshTokenDto.getRefreshToken()),HttpStatus.OK);
    }
}
