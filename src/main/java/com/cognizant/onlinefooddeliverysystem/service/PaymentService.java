package com.cognizant.onlinefooddeliverysystem.service;


import com.cognizant.onlinefooddeliverysystem.dto.PaymentRequestDTO;
import com.cognizant.onlinefooddeliverysystem.dto.PaymentResponseDTO;
import com.cognizant.onlinefooddeliverysystem.exception.PaymentException;
import com.cognizant.onlinefooddeliverysystem.model.Order;
import com.cognizant.onlinefooddeliverysystem.model.Payment;
import com.cognizant.onlinefooddeliverysystem.repository.OrderRepository;
import com.cognizant.onlinefooddeliverysystem.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PaymentService {
    @Autowired
    PaymentRepository paymentRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ModelMapper modelMapper;

    @Transactional
    public PaymentResponseDTO initiatePayment(PaymentRequestDTO request){
        // find the order
        Order order = orderRepository.findOrderByOrderId(request.getOrderId())
                .orElseThrow(() -> new PaymentException("Order not Found with ID: " + request.getOrderId()));

        // Create new Payment Record
        Payment payment = new Payment();
        payment.setOrder(order);
        payment.setAmount(order.getTotalAmount());
        payment.setMethod(request.getPaymentMethod());
        payment.setPaymentStatus("Pending");
        payment.setPaymentType("Pre_Paid");
        payment.setTimestamp(LocalDateTime.now());

        // commit the transaction and return mapped dto
        return modelMapper.map(paymentRepository.save(payment), PaymentResponseDTO.class);
    }

}
