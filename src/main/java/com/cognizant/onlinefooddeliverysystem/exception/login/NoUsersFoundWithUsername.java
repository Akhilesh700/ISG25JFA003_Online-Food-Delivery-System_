package com.cognizant.onlinefooddeliverysystem.exception.login;

import com.cognizant.onlinefooddeliverysystem.exception.OnlineFoodDeliveryAppException;

public class NoUsersFoundWithUsername extends OnlineFoodDeliveryAppException {
    public NoUsersFoundWithUsername(String message) {
        super(message);
    }
}
