package com.cognizant.onlinefooddeliverysystem.dto.delivery;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeliveryInfoDto {
    // Fields from Delivery entity
    private LocalDateTime pickupTime;
    private LocalDateTime eta;

    // Fields from DeliveryAgent entity
    private String agentName;
    private String agentPhone;

    // You can also include IDs if they are useful for the client
    private Integer deliveryId;
    private Integer agentId;
}
