package com.cognizant.onlinefooddeliverysystem.service;

import com.cognizant.onlinefooddeliverysystem.repository.CartItemRepository;
import com.cognizant.onlinefooddeliverysystem.repository.CartRepository;
import com.cognizant.onlinefooddeliverysystem.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderServiceImp implements OrderService{

    CartItemRepository cartItemRepository;
    CartRepository cartRepository;
    OrderRepository orderRepository;







}
