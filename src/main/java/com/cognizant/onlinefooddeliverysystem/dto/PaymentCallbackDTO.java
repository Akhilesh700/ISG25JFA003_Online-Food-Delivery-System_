package com.cognizant.onlinefooddeliverysystem.dto;

import lombok.Data;

@Data
public class PaymentCallbackDTO {
    private Integer paymentId;
    private String type;
    private String identifier;
    private Integer pin;
    private Float amount;
}
