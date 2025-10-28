package com.cognizant.onlinefooddeliverysystem.dto.restaurant;

import com.cognizant.onlinefooddeliverysystem.model.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderHistoryByRestaurant {
    private Integer orderId;
    private LocalDateTime orderTime;
    private String specialReq;
    private BigDecimal totalAmount;
    private String customerName;
    private String customerPhone;
    private Status.StatusType status;
}
