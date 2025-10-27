package com.cognizant.onlinefooddeliverysystem.exception.refreshtoken;

import com.cognizant.onlinefooddeliverysystem.exception.OnlineFoodDeliveryAppException;

public class TokenRefreshException extends OnlineFoodDeliveryAppException {
    public TokenRefreshException(String token, String message) {
        super(String.format("Failed for token [%s]: %s", token, message));
    }

    public TokenRefreshException(String message) {
        super(message);
    }
}
