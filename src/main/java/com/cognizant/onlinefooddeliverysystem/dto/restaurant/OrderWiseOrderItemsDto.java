package com.cognizant.onlinefooddeliverysystem.dto.restaurant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderWiseOrderItemsDto {
    private String name;
    private int quantity;
    private float price;
}
