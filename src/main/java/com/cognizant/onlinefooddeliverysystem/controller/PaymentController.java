package com.cognizant.onlinefooddeliverysystem.controller;


import com.cognizant.onlinefooddeliverysystem.dto.PaymentRequestDTO;
import com.cognizant.onlinefooddeliverysystem.dto.PaymentResponseDTO;
import com.cognizant.onlinefooddeliverysystem.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${api.version.path}/payments")
@RequiredArgsConstructor
public class PaymentController {


    PaymentService paymentService;

    //    Initiate

    @PostMapping("initiate")
    public ResponseEntity<PaymentResponseDTO> initiatePayment(@RequestBody PaymentRequestDTO request){
        return new ResponseEntity<>(paymentService.initiatePayment(request), HttpStatus.CREATED);
    }

    //    Dummy callback


    //    status/order/{orderId}

}
