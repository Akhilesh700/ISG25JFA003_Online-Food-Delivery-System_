package com.cognizant.onlinefooddeliverysystem.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderResponseDTO {

    private Integer orderId;
    private String specialReq;
    private LocalDateTime orderTime;
    private BigDecimal totalAmount;
}
