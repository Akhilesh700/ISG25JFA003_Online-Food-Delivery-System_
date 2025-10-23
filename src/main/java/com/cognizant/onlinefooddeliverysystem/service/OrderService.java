package com.cognizant.onlinefooddeliverysystem.service;


import com.cognizant.onlinefooddeliverysystem.dto.order.*;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface OrderService {


    @Transactional
    PlaceOrderResponseDto placeOrderByCartId(PlaceOrderRequestDto request);

    List<GetOrderHistoryResponseDto> getOrderHistoryByCustomerId();

    @Transactional
    void updateOrderPaymentStatus(Integer orderId, UpdatePaymentRequestDto request);

    OrderInfoResponseDto getOrderInfo(Integer orderId);
}
