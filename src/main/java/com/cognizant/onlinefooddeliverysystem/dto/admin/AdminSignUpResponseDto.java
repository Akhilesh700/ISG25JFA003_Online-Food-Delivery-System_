package com.cognizant.onlinefooddeliverysystem.dto.admin;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class AdminSignUpResponseDto {
    private int id;
    private LocalDateTime createdAt;
}
