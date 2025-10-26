package com.cognizant.onlinefooddeliverysystem.service;

import com.cognizant.onlinefooddeliverysystem.dto.UpdateEntityResponseDto;
import com.cognizant.onlinefooddeliverysystem.dto.order.AcceptRejectOrderResponseDto;
import com.cognizant.onlinefooddeliverysystem.dto.restaurant.RestaurantOrderHistoryResponseDTO;
import com.cognizant.onlinefooddeliverysystem.dto.restaurant.RestaurantProfileUpdateRequestDto;
import com.cognizant.onlinefooddeliverysystem.model.MenuItems;
import com.cognizant.onlinefooddeliverysystem.model.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RestaurantService {
    List<RestaurantOrderHistoryResponseDTO> getOrderHistoryByRestaurant() ;

    AcceptRejectOrderResponseDto acceptOrder(int orderId, String action);

    List<MenuItems> getMenuItems();

    UpdateEntityResponseDto updateRestaurantProfile(RestaurantProfileUpdateRequestDto requestDto);
}
