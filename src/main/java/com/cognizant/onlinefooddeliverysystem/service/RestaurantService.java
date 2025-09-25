package com.cognizant.onlinefooddeliverysystem.service;

import com.cognizant.onlinefooddeliverysystem.dto.order.AcceptRejectOrderResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface RestaurantService {
    AcceptRejectOrderResponseDto acceptOrder(int orderId, String action);
}
