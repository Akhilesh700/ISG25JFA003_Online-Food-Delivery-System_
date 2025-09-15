package com.cognizant.onlinefooddeliverysystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseDto {
    String jwt;
    int userId;
    String role;
}
