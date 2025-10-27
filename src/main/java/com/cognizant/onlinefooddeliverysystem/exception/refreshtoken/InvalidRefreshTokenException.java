package com.cognizant.onlinefooddeliverysystem.exception.refreshtoken;

import com.cognizant.onlinefooddeliverysystem.exception.OnlineFoodDeliveryAppException;

public class InvalidRefreshTokenException extends OnlineFoodDeliveryAppException {
    public InvalidRefreshTokenException(String message) {
        super(message);
    }
}
