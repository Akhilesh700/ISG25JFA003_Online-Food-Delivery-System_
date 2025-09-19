package com.cognizant.onlinefooddeliverysystem.service;

import com.cognizant.onlinefooddeliverysystem.dto.cart.CartRequestDto;
import com.cognizant.onlinefooddeliverysystem.dto.cart.CartResponseDto;

public interface CartService {

    public CartResponseDto addToCart(Integer customerId , CartRequestDto request);

}
