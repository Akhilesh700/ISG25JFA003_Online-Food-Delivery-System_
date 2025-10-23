package com.cognizant.onlinefooddeliverysystem.controller;
import com.cognizant.onlinefooddeliverysystem.dto.order.*;
import com.cognizant.onlinefooddeliverysystem.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.version.path}/customer/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("place")
    public ResponseEntity<PlaceOrderResponseDto> placeOrder(@RequestBody PlaceOrderRequestDto request) {
        return new ResponseEntity<>(orderService.placeOrderByCartId(request), HttpStatus.CREATED);
    }

    @GetMapping("history")
    public List<GetOrderHistoryResponseDto> getOrderHistoryByCustomerId(){
        return orderService.getOrderHistoryByCustomerId();
    }

    @PutMapping("/{orderId}/payment")
    public ResponseEntity<Void> updatePaymentStatus(@PathVariable Integer orderId, @RequestBody UpdatePaymentRequestDto request) {
        orderService.updateOrderPaymentStatus(orderId, request);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderInfoResponseDto> getOrderInfo(@PathVariable Integer orderId) {
        return ResponseEntity.ok(orderService.getOrderInfo(orderId));
    }
}