package com.cognizant.onlinefooddeliverysystem.controller;
import com.cognizant.onlinefooddeliverysystem.dto.order.PlaceOrderRequestDto;
import com.cognizant.onlinefooddeliverysystem.dto.order.PlaceOrderResponseDto;
import com.cognizant.onlinefooddeliverysystem.service.OrderService;
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
    public ResponseEntity<PlaceOrderResponseDto> placeOrder(@PathVariable Long cartItemId, @RequestBody PlaceOrderRequestDto request) {
        return new ResponseEntity<>(orderService.placeOrderByCartId(cartItemId, request), HttpStatus.CREATED);
    }
}