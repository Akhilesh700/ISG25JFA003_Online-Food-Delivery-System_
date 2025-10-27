package com.cognizant.onlinefooddeliverysystem.dto.restaurant;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantProfileResponseDto {
    private String phone = null;
    private String name = null;
    private String address = null;
    private LocalTime openTime = null;
    private LocalTime closeTime = null;
}
