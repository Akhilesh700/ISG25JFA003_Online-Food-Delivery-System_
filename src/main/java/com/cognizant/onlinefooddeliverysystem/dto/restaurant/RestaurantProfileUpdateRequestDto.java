package com.cognizant.onlinefooddeliverysystem.dto.restaurant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
public class RestaurantProfileUpdateRequestDto {
    private String phone = null;
    private String name = null;
    private String address = null;
    private LocalTime openTime = null;
    private LocalTime closeTime = null;
}
