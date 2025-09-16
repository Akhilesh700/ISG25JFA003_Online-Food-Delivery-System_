package com.cognizant.onlinefooddeliverysystem.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PaymentStatusDTO {

    private Integer orderId;
    private String paymentStatus;
    private String transactionId;
}
