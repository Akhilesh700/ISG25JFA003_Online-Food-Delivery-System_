package com.cognizant.onlinefooddeliverysystem.model;

import com.cognizant.onlinefooddeliverysystem.dto.order.AcceptRejectOrderResponseDto;
import com.cognizant.onlinefooddeliverysystem.service.RestaurantService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("${api.version.path}/restaurant/order")
public class RestaurantController {

    private final RestaurantService restaurantService;


    @PutMapping("/update-status/{orderId}")
    public ResponseEntity<AcceptRejectOrderResponseDto> acceptOrder(@PathVariable("orderId") int orderId, @RequestParam("action") String action){
        return new ResponseEntity<>(restaurantService.acceptOrder(orderId, action), HttpStatus.ACCEPTED);
    }
}
