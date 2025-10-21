package com.cognizant.onlinefooddeliverysystem.service.implimentation;


import com.cognizant.onlinefooddeliverysystem.constant.PaymentConstants;
import com.cognizant.onlinefooddeliverysystem.dto.payment.PaymentCallbackDTO;
import com.cognizant.onlinefooddeliverysystem.dto.payment.PaymentRequestDTO;
import com.cognizant.onlinefooddeliverysystem.dto.payment.PaymentResponseDTO;
import com.cognizant.onlinefooddeliverysystem.dto.payment.PaymentStatusDTO;
import com.cognizant.onlinefooddeliverysystem.exception.ResourceNotFoundException;
import com.cognizant.onlinefooddeliverysystem.exception.payment.PaymentException;
import com.cognizant.onlinefooddeliverysystem.model.Order;
import com.cognizant.onlinefooddeliverysystem.model.Payment;
import com.cognizant.onlinefooddeliverysystem.model.Status;
import com.cognizant.onlinefooddeliverysystem.repository.OrderRepository;
import com.cognizant.onlinefooddeliverysystem.repository.PaymentRepository;
import com.cognizant.onlinefooddeliverysystem.repository.StatusRepository;
import com.cognizant.onlinefooddeliverysystem.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;
    private final StatusRepository statusRepository;


    @Override
    public PaymentResponseDTO initiatePayment(PaymentRequestDTO request){
        // find the order
        Order order = orderRepository.findOrderByOrderId(request.getOrderId())
                .orElseThrow(() -> new PaymentException("Order not Found with ID: " + request.getOrderId()));

        Set<Payment> payments = order.getPayments();

        PaymentResponseDTO response;
        if (payments.stream().anyMatch(p -> p.getPaymentStatus() == Payment.Status.Successful )) {
            throw new PaymentException("Payment for order Id : " + order.getOrderId() + " is already successful.");
        }
        else if (payments.stream().anyMatch(p -> p.getPaymentStatus() == Payment.Status.Pending)) {
            throw new PaymentException("Payment for order Id : " + order.getOrderId() + " is already pending.");
        }else {
            // Create new Payment Record
            Payment payment = new Payment();
            payment.setOrder(order);
            payment.setAmount(order.getTotalAmount());
            payment.setMethod(request.getPaymentMethod());
            payment.setPaymentStatus(Payment.Status.Pending);
            payment.setPaymentType("Pre_Paid");
            payment.setTimestamp(LocalDateTime.now());

            // commit the transaction and return mapped dto
            response = modelMapper.map(paymentRepository.save(payment), PaymentResponseDTO.class);
        }
        return response;
    }


    @Override
    public String  processPaymentResponse(PaymentCallbackDTO callback){

        // 1. Find the payment record
        Payment payment = paymentRepository.findById(callback.getPaymentId())
                .orElseThrow(() -> new PaymentException("Payment not found with ID: " + callback.getPaymentId()));

        String transactionId = "txn_" + UUID.randomUUID();

        if(PaymentConstants.validatePayment(callback.getType(), callback.getIdentifier(), callback.getPin(),callback.getAmount())){

            payment.setPaymentStatus(Payment.Status.Successful);
            payment.setTransactionId(transactionId);

            Order order = payment.getOrder();
            Status status = statusRepository.findByStatusType(Status.StatusType.valueOf("PLACED"))
                    .orElseThrow(() -> new ResourceNotFoundException("Not_Accepted Status Not Found"));
            order.setStatus(status);

        }else {
            payment.setPaymentStatus(Payment.Status.Failed);
            payment.setTransactionId(transactionId);
        }

        paymentRepository.save(payment);
        return transactionId;

    }

    @Override
    public List<PaymentStatusDTO> getPaymentStatus(Integer orderId) {
        List<Payment> paymentList = paymentRepository.findAllByOrder_OrderId(orderId);

        return paymentList.stream()
                .map(payment ->
                        new PaymentStatusDTO(orderId, payment.getPaymentStatus(), payment.getTransactionId()))
                .toList();

    }


}
