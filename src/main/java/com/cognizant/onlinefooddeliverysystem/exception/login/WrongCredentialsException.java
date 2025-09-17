package com.cognizant.onlinefooddeliverysystem.exception.login;

import com.cognizant.onlinefooddeliverysystem.exception.OnlineFoodDeliveryAppException;

public class WrongCredentialsException extends OnlineFoodDeliveryAppException {
    public WrongCredentialsException(String message) {
        super(message);
    }
}
