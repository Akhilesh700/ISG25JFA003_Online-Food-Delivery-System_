package com.cognizant.onlinefooddeliverysystem.exception.payment;

import com.cognizant.onlinefooddeliverysystem.exception.OnlineFoodDeliveryAppException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CartNotFoundException extends OnlineFoodDeliveryAppException {
    public CartNotFoundException(String message) {
        super(message);
    }
}
