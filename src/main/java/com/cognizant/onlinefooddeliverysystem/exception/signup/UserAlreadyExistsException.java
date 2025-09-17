package com.cognizant.onlinefooddeliverysystem.exception.signup;

import com.cognizant.onlinefooddeliverysystem.exception.OnlineFoodDeliveryAppException;

public class UserAlreadyExistsException extends OnlineFoodDeliveryAppException {
    public UserAlreadyExistsException(String message) {
        super(message);
    }
}
