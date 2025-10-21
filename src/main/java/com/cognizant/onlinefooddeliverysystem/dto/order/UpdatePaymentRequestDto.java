package com.cognizant.onlinefooddeliverysystem.dto.order;

import com.cognizant.onlinefooddeliverysystem.model.Payment;
import lombok.Data;

@Data
public class UpdatePaymentRequestDto {

    private String paymentId;
    private Payment.Status status;
    private Long amount;

}
