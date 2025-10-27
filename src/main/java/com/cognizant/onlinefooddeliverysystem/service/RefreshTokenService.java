package com.cognizant.onlinefooddeliverysystem.service;

import com.cognizant.onlinefooddeliverysystem.dto.refreshtoken.RefreshTokenDto;
import com.cognizant.onlinefooddeliverysystem.dto.refreshtoken.RefreshTokenResponseDto;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public interface RefreshTokenService {

    @Transactional
    RefreshTokenResponseDto generateJwtTokenByRefreshToken(String requestRefreshToken);
}
