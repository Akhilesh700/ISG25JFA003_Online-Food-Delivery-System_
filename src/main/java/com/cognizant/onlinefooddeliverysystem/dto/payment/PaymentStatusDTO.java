package com.cognizant.onlinefooddeliverysystem.dto.payment;


import com.cognizant.onlinefooddeliverysystem.model.Payment;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PaymentStatusDTO {

    private Integer orderId;
    private Payment.Status paymentStatus;
    private String transactionId;
}
