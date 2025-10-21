package com.cognizant.onlinefooddeliverysystem.service;

import com.cognizant.onlinefooddeliverysystem.dto.order.AcceptRejectOrderResponseDto;
import com.cognizant.onlinefooddeliverysystem.dto.restaurant.RestaurantOrderHistoryResponseDTO;
import com.cognizant.onlinefooddeliverysystem.model.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RestaurantService {
    List<RestaurantOrderHistoryResponseDTO> getOrderHistoryByRestaurant() ;

    AcceptRejectOrderResponseDto acceptOrder(int orderId, String action);
}
