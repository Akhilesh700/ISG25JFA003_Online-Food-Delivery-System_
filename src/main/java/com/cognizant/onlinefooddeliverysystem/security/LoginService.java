package com.cognizant.onlinefooddeliverysystem.security;

import com.cognizant.onlinefooddeliverysystem.dto.login.LoginRequestDto;
import com.cognizant.onlinefooddeliverysystem.dto.login.LoginResponseDto;
import com.cognizant.onlinefooddeliverysystem.model.DeviceInfo;
import com.cognizant.onlinefooddeliverysystem.model.RefreshToken;
import com.cognizant.onlinefooddeliverysystem.model.User;
import com.cognizant.onlinefooddeliverysystem.repository.RefreshTokenRepository;
import com.cognizant.onlinefooddeliverysystem.util.ExtractIpFromRequest;
import com.cognizant.onlinefooddeliverysystem.util.GenerateRefreshToken;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final AuthUtil authUtil;
    private final AuthenticationManager authenticationManager;
    private final GenerateRefreshToken generateRefreshToken;
    private final RefreshTokenRepository refreshTokenRepository;
    private final ExtractIpFromRequest ipExtractor;
    private final HttpServletRequest request;

    @Transactional
    public LoginResponseDto login(LoginRequestDto loginRequestDto) {
//        Authentication of User from DAO
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(loginRequestDto.getUsername(), loginRequestDto.getPassword())
        );

        User user = (User) authentication.getPrincipal();
//        Updating the lastLoginAt to current time
        user.setLastLoginAt(LocalDateTime.now());

//        Generating the auth token with user object
        String authToken = authUtil.generateJwtToken(user);
//        Generating the refresh token

        LoginResponseDto responseDto = new LoginResponseDto();
        responseDto.setJwt(authToken);
        responseDto.setUserId(user.getUserId());

//        Extracting client IP address
        String clientIp = ipExtractor.extractIpFromRequest(request);
        DeviceInfo deviceInfo = DeviceInfo.builder()
                .ip(clientIp)
                .name(loginRequestDto.getDeviceName())
                .browserName(loginRequestDto.getBrowserName())
                .browserVersion(loginRequestDto.getBrowserVersion())
                .timezone(loginRequestDto.getTimezone())
                .deviceType(loginRequestDto.getDeviceType())
                .build();

//        If user choose to remember him
        if(loginRequestDto.getRememberMe()){
            String generatedRefreshToken = generateRefreshToken.generateRefreshToken();
            responseDto.setRefreshToken(generatedRefreshToken);
//            Saving refresh token in the DB
            refreshTokenRepository.save(RefreshToken.builder()
                    .token(generatedRefreshToken)
                    .deviceInfo(deviceInfo)
                    .user(user)
                    .expiryDate(Instant.now().plus(7, ChronoUnit.DAYS))
                    .build()
            );
        }

//        Returning the DTO object
        return responseDto;
    }
}
