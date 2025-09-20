package com.cognizant.onlinefooddeliverysystem.dto.payment;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PaymentCallbackDTO {
    private Integer paymentId;
    private String type;
    private String identifier;
    private Integer pin;
    private Float amount;
}
