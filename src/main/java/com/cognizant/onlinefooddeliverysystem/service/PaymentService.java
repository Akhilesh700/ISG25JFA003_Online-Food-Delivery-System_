package com.cognizant.onlinefooddeliverysystem.service;

import com.cognizant.onlinefooddeliverysystem.dto.payment.PaymentCallbackDTO;
import com.cognizant.onlinefooddeliverysystem.dto.payment.PaymentRequestDTO;
import com.cognizant.onlinefooddeliverysystem.dto.payment.PaymentResponseDTO;
import com.cognizant.onlinefooddeliverysystem.dto.payment.PaymentStatusDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PaymentService {

    @Transactional
    PaymentResponseDTO initiatePayment(PaymentRequestDTO request);

    @Transactional
    String  processPaymentResponse(PaymentCallbackDTO callback);

    List<PaymentStatusDTO> getPaymentStatus(Integer orderId);

}
