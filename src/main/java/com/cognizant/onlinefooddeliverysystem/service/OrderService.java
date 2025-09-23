package com.cognizant.onlinefooddeliverysystem.service;


import com.cognizant.onlinefooddeliverysystem.dto.order.GetOrderHistoryResponseDto;
import com.cognizant.onlinefooddeliverysystem.dto.order.PlaceOrderRequestDto;
import com.cognizant.onlinefooddeliverysystem.dto.order.PlaceOrderResponseDto;
import org.springframework.transaction.annotation.Transactional;

public interface OrderService {


    @Transactional
    PlaceOrderResponseDto placeOrderByCartId(PlaceOrderRequestDto request);

    GetOrderHistoryResponseDto getOrderHistoryByCustomerId(int customerId);
}
