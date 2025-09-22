package com.cognizant.onlinefooddeliverysystem.exception.payment;

import com.cognizant.onlinefooddeliverysystem.exception.OnlineFoodDeliveryAppException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class InvalidPaymentTypeException extends OnlineFoodDeliveryAppException {
    public InvalidPaymentTypeException(String message) {
        super(message);
    }
}
