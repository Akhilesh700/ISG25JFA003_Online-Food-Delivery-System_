package com.cognizant.onlinefooddeliverysystem.dto.payment;

import lombok.Data;

@Data
public class PaymentRequestDTO {
    private Integer orderId;
    private String paymentMethod;
}
