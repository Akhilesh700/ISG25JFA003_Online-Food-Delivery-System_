package com.cognizant.onlinefooddeliverysystem.exception.order;

import com.cognizant.onlinefooddeliverysystem.exception.OnlineFoodDeliveryAppException;

public class CartItemNotFoundWithCartIdException extends OnlineFoodDeliveryAppException {
    public CartItemNotFoundWithCartIdException(String message) {
        super(message);
    }
}
