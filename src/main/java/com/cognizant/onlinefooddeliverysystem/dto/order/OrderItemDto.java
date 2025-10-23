package com.cognizant.onlinefooddeliverysystem.dto.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// A DTO for the items in the list
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemDto {
    private Long orderItemId;
    private String itemName; // From MenuItems
    private int quantity;
    private float price;
}
