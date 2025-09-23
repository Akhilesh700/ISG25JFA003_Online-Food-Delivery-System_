package com.cognizant.onlinefooddeliverysystem.service;

import com.cognizant.onlinefooddeliverysystem.dto.cart.CartRequestDto;
import com.cognizant.onlinefooddeliverysystem.dto.cart.CartResponseDto;
import com.cognizant.onlinefooddeliverysystem.model.Cart;

public interface CartService {

    CartResponseDto addToCart(Integer customerId , CartRequestDto request);
    Cart getCartByCustomerId(Integer customerId);
    Cart getCartByVerifiedUser();
}
