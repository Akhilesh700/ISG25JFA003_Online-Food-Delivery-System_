package com.cognizant.onlinefooddeliverysystem.exception.menu;

import com.cognizant.onlinefooddeliverysystem.exception.OnlineFoodDeliveryAppException;

public class RestaurantNotFoundException extends OnlineFoodDeliveryAppException {
    public RestaurantNotFoundException(String message) {
        super(message);
    }
}
