package com.cognizant.onlinefooddeliverysystem.controller;

import com.cognizant.onlinefooddeliverysystem.dto.UpdateEntityResponseDto;
import com.cognizant.onlinefooddeliverysystem.dto.customer.CustomerProfileResponseDto;
import com.cognizant.onlinefooddeliverysystem.dto.order.AcceptRejectOrderResponseDto;
import com.cognizant.onlinefooddeliverysystem.dto.restaurant.RestaurantOrderHistoryResponseDTO;
import com.cognizant.onlinefooddeliverysystem.dto.restaurant.RestaurantProfileResponseDto;
import com.cognizant.onlinefooddeliverysystem.dto.restaurant.RestaurantProfileUpdateRequestDto;
import com.cognizant.onlinefooddeliverysystem.model.MenuItems;
import com.cognizant.onlinefooddeliverysystem.model.Restaurant;
import com.cognizant.onlinefooddeliverysystem.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("${api.version.path}/restaurant")
public class RestaurantController {

    private final RestaurantService restaurantService;

    @PutMapping("/update-status/{orderId}")
    public ResponseEntity<AcceptRejectOrderResponseDto> acceptOrder(@PathVariable("orderId") int orderId, @RequestParam("action") String action){
        return new ResponseEntity<>(restaurantService.acceptOrder(orderId, action), HttpStatus.ACCEPTED);
    }

    @GetMapping("order-history")
    public List<RestaurantOrderHistoryResponseDTO> getOrderHistoryByRestaurant(){
        return restaurantService.getOrderHistoryByRestaurant();
    }

    @GetMapping("menu")
    public List<MenuItems> getMenuItems(){
        return restaurantService.getMenuItems();
    }

    @PutMapping("update-profile")
    public ResponseEntity<UpdateEntityResponseDto> updateRestaurantProfile(@RequestBody RestaurantProfileUpdateRequestDto requestDto){
        return new ResponseEntity<>(restaurantService.updateRestaurantProfile(requestDto), HttpStatus.ACCEPTED);
    }
    @GetMapping("/profile")
    public ResponseEntity<RestaurantProfileResponseDto> getRestaurantProfileDetails(){
        return new ResponseEntity<>(restaurantService.getRestaurantProfileDetails(), HttpStatus.OK);
    }
}
