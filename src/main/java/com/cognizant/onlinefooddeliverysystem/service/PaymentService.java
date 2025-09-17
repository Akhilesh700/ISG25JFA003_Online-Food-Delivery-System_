package com.cognizant.onlinefooddeliverysystem.service;


import com.cognizant.onlinefooddeliverysystem.constant.PaymentConstants;
import com.cognizant.onlinefooddeliverysystem.dto.PaymentCallbackDTO;
import com.cognizant.onlinefooddeliverysystem.dto.PaymentRequestDTO;
import com.cognizant.onlinefooddeliverysystem.dto.PaymentResponseDTO;
import com.cognizant.onlinefooddeliverysystem.dto.PaymentStatusDTO;
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
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

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

        Set<Payment> payments = order.getPayments();


        PaymentResponseDTO response;
        if (payments.stream().anyMatch(p -> p.getPaymentStatus().equalsIgnoreCase("Successful"))) {
            throw new PaymentException("Payment for order Id : " + order.getOrderId() + " is already successful.");
        }
        else if (payments.stream().anyMatch(p -> p.getPaymentStatus().equalsIgnoreCase("Successful"))) {
            throw new PaymentException("Payment for order Id : " + order.getOrderId() + " is already pending.");
        }else {
            // Create new Payment Record
            Payment payment = new Payment();
            payment.setOrder(order);
            payment.setAmount(order.getTotalAmount());
            payment.setMethod(request.getPaymentMethod());
            payment.setPaymentStatus("Pending");
            payment.setPaymentType("Pre_Paid");
            payment.setTimestamp(LocalDateTime.now());

            // commit the transaction and return mapped dto
            response = modelMapper.map(paymentRepository.save(payment), PaymentResponseDTO.class);
        }
        return response;
    }


    @Transactional
    public String  processPaymentResponse(PaymentCallbackDTO callback){

        // 1. Find the payment record
        Payment payment = paymentRepository.findById(callback.getPaymentId())
                .orElseThrow(() -> new PaymentException("Payment not found with ID: " + callback.getPaymentId()));

        String transactionId = "txn_" + UUID.randomUUID();

        if(PaymentConstants.validatePayment(callback.getType(), callback.getIdentifier(), callback.getPin(),callback.getAmount())){
            payment.setPaymentStatus("Successful");
            payment.setTransactionId(transactionId);
        }else {
            payment.setPaymentStatus("Failed");
            payment.setTransactionId(transactionId);
        }

        paymentRepository.save(payment);
        return transactionId;

    }

    public List<PaymentStatusDTO> getPaymentStatus(Integer orderId) {
        List<Payment> paymentList = paymentRepository.findAllByOrder_OrderId(orderId);

        return paymentList.stream()
                .map(payment ->
                        new PaymentStatusDTO(orderId, payment.getPaymentStatus(), payment.getTransactionId()))
                .toList();

    }


}
