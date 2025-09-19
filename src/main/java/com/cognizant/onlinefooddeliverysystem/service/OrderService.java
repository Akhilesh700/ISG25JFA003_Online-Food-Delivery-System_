package com.cognizant.onlinefooddeliverysystem.service;


import com.cognizant.onlinefooddeliverysystem.dto.order.PlaceOrderRequestDto;
import com.cognizant.onlinefooddeliverysystem.model.Order;
import org.springframework.transaction.annotation.Transactional;

public interface OrderService {


    @Transactional
    Order placeOrderByCartId(Long cartId, PlaceOrderRequestDto request);
}
