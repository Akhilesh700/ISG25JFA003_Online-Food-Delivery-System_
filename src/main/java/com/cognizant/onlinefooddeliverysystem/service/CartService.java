package com.cognizant.onlinefooddeliverysystem.service;

import com.cognizant.onlinefooddeliverysystem.dto.cart.CartRequestDto;

public interface CartService {

    public Long addToCart(Integer customerId ,CartRequestDto request);

}
