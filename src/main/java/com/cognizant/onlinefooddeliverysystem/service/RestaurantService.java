package com.cognizant.onlinefooddeliverysystem.service;

import com.cognizant.onlinefooddeliverysystem.dto.UpdateEntityResponseDto;
import com.cognizant.onlinefooddeliverysystem.dto.order.AcceptRejectOrderResponseDto;
import com.cognizant.onlinefooddeliverysystem.dto.restaurant.OrderHistoryByRestaurant;
import com.cognizant.onlinefooddeliverysystem.dto.restaurant.OrderHistoryResponseDto;
import com.cognizant.onlinefooddeliverysystem.dto.restaurant.RestaurantProfileResponseDto;
import com.cognizant.onlinefooddeliverysystem.dto.restaurant.RestaurantProfileUpdateRequestDto;
import com.cognizant.onlinefooddeliverysystem.model.MenuItems;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RestaurantService {
    List<OrderHistoryResponseDto> getOrderHistoryByRestaurant() ;

    AcceptRejectOrderResponseDto acceptOrder(int orderId, String action);

    List<MenuItems> getMenuItems();

    UpdateEntityResponseDto updateRestaurantProfile(RestaurantProfileUpdateRequestDto requestDto);

    RestaurantProfileResponseDto getRestaurantProfileDetails();
}
