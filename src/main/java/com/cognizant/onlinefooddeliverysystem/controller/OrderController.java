package com.cognizant.onlinefooddeliverysystem.controller;
import com.cognizant.onlinefooddeliverysystem.dto.order.PlaceOrderRequestDto;
import com.cognizant.onlinefooddeliverysystem.model.Order;
import com.cognizant.onlinefooddeliverysystem.service.OrderService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${api.version.path}/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/place/{cartItemId}")
    public ResponseEntity<Order> placeOrder(@PathVariable Long cartItemId, @RequestBody PlaceOrderRequestDto request) {
        Order newOrder = orderService.placeOrderByCartId(cartItemId, request);
        return new ResponseEntity<>(newOrder, HttpStatus.CREATED);
    }
}