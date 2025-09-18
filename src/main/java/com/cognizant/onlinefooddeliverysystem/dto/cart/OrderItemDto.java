package com.cognizant.onlinefooddeliverysystem.dto.cart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemDto {
    private Long menuItemId;
    private Integer quantity;
}
