package com.cognizant.onlinefooddeliverysystem.dto.order;

import com.cognizant.onlinefooddeliverysystem.model.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

// The main response DTO
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderInfoResponseDto { // Renamed for clarity
    private Integer orderId;
    private Integer restaurantId;
    private String restaurantName;
    private String restaurantImgUrl;
    private String customer;
    private String customerPhone;
    private LocalDateTime orderTime;
    private String pickUpAddress;
    private String deliveryAddress;
    private Status.StatusType status;

    private Integer deliveryId;
    private Integer agentId;
    private String agentName;
    private String agentPhone;
    private LocalDateTime pickupTime;
    private LocalDateTime eta;

    private List<OrderItemDto> totalOrderItems; // List of DTOs
}

