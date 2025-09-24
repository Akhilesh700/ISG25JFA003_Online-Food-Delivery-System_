package com.cognizant.onlinefooddeliverysystem.dto.payment;

import com.cognizant.onlinefooddeliverysystem.model.Payment;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class PaymentResponseDTO {

    private Integer paymentId;
    private String method;

    private BigDecimal amount;

    private String transactionId;

    private LocalDateTime timestamp;

    private String paymentType;

    private Payment.Status paymentStatus;


}
