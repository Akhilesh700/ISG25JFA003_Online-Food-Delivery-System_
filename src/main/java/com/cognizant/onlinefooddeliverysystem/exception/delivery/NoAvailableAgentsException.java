package com.cognizant.onlinefooddeliverysystem.exception.delivery;

import com.cognizant.onlinefooddeliverysystem.exception.OnlineFoodDeliveryAppException;

public class NoAvailableAgentsException extends OnlineFoodDeliveryAppException {
    public NoAvailableAgentsException(String message) {
        super(message);
    }
}
