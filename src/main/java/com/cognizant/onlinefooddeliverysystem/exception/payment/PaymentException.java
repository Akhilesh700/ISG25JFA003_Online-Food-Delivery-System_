package com.cognizant.onlinefooddeliverysystem.exception.payment;

import com.cognizant.onlinefooddeliverysystem.exception.OnlineFoodDeliveryAppException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PaymentException extends OnlineFoodDeliveryAppException {
    public PaymentException(String message) {
        super(message);
    }
}
