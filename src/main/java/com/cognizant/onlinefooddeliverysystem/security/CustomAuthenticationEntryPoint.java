package com.cognizant.onlinefooddeliverysystem.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

// TODO: Understand this file
@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {

        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setContentType("application/json");

        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("status", "401");
        errorResponse.put("error", "Unauthorized");
        errorResponse.put("message", "Invalid authorization token or Invalid access role");

        // Write the JSON response to the client
        response.getWriter().write(objectMapper.writeValueAsString(errorResponse));
    }
}
