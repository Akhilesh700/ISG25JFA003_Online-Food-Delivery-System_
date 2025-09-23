package com.cognizant.onlinefooddeliverysystem.exception.order;

import com.cognizant.onlinefooddeliverysystem.exception.OnlineFoodDeliveryAppException;

public class UserHasNoRoleException extends OnlineFoodDeliveryAppException {
    public UserHasNoRoleException(String message) {
        super(message);
    }
}
