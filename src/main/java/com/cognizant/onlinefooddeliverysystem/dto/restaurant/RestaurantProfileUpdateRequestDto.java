package com.cognizant.onlinefooddeliverysystem.dto.restaurant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class RestaurantProfileUpdateRequestDto {
    private String phone = null;
    private String name = null;
    private String address = null;
    private LocalDate openTime = null;
    private LocalDate closeTime = null;
}
