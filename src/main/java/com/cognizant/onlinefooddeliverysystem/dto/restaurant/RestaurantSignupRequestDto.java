package com.cognizant.onlinefooddeliverysystem.dto.restaurant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantSignupRequestDto {
    private String email;
    private String password;
    private String name;
    private LocalTime openTime;
    private LocalTime closeTime;
    private String phone;
    private String address;
}
