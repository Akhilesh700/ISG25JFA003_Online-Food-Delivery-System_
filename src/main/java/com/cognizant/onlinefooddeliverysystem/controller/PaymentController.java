package com.cognizant.onlinefooddeliverysystem.controller;


import com.cognizant.onlinefooddeliverysystem.dto.payment.PaymentCallbackDTO;
import com.cognizant.onlinefooddeliverysystem.dto.payment.PaymentRequestDTO;
import com.cognizant.onlinefooddeliverysystem.dto.payment.PaymentResponseDTO;
import com.cognizant.onlinefooddeliverysystem.dto.payment.PaymentStatusDTO;
import com.cognizant.onlinefooddeliverysystem.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.version.path}/payments")
@RequiredArgsConstructor
public class PaymentController {


    private PaymentService paymentService;

    @Autowired
    PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    //    Initiate

    @PostMapping("initiate")
    public ResponseEntity<PaymentResponseDTO> initiatePayment(@RequestBody PaymentRequestDTO request){
        return new ResponseEntity<>(paymentService.initiatePayment(request), HttpStatus.CREATED);
    }

    //    Dummy callback

    @PostMapping("/dummy-callback")
    public ResponseEntity<String> dummyCallback(@RequestBody PaymentCallbackDTO callback){
        String transactionId = paymentService.processPaymentResponse(callback);
        return new ResponseEntity<>("Callback processed payment's transaction ID : " + transactionId, HttpStatus.ACCEPTED);
    }

    //    this should return status of the order
    @GetMapping("status/order/{orderId}")
    public ResponseEntity<List<PaymentStatusDTO>> getPaymentStatus(@PathVariable("orderId") Integer orderId ) {
        List<PaymentStatusDTO> list = paymentService.getPaymentStatus(orderId);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

}
