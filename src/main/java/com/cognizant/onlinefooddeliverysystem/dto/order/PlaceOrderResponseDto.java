package com.cognizant.onlinefooddeliverysystem.dto.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PlaceOrderResponseDto {
    int totalOrderItems;
    String message;
}
