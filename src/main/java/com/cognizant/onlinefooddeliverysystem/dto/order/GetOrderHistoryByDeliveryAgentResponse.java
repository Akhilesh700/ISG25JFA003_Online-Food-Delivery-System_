package com.cognizant.onlinefooddeliverysystem.dto.order;

import com.cognizant.onlinefooddeliverysystem.model.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetOrderHistoryByDeliveryAgentResponse {
    private Integer orderId;
    private String restaurant;
    private String customer;
    private String customerPhone;
    private LocalDateTime orderTime;
    private String pickUpAddress;
    private String deliveryAddress;
    private Status.StatusType status;
    private Long totalOrderItems;
}
