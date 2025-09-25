package com.cognizant.onlinefooddeliverysystem.dto.order;

import com.cognizant.onlinefooddeliverysystem.model.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class GetOrderHistoryResponseDto {
    private int orderId;
    private String restaurant;
    private String restaurantAddress;
    private BigDecimal totalPrice;
    private List<OrderItem> orderItems;
    private String status;
    private String specialRequest;
}
