package com.cognizant.onlinefooddeliverysystem.exception.menu;

import com.cognizant.onlinefooddeliverysystem.exception.OnlineFoodDeliveryAppException;

public class MenuItemNotFoundException extends OnlineFoodDeliveryAppException {
    public MenuItemNotFoundException(String message) {
        super(message);
    }
}
