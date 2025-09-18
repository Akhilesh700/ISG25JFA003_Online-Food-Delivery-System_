package com.cognizant.onlinefooddeliverysystem.controller;


import com.cognizant.onlinefooddeliverysystem.dto.cart.CartRequestDto;
import com.cognizant.onlinefooddeliverysystem.service.CartServiceImp;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${api.version.path}/cart")
@AllArgsConstructor
public class CartController {

    private final CartServiceImp cartService;



    @PostMapping("/add")
    public ResponseEntity<Long> addToCart(@RequestHeader("customerId") Integer customerId, @RequestBody CartRequestDto request) {
        Long cartId = cartService.addToCart(customerId, request);
        return new ResponseEntity<>(cartId, HttpStatus.OK);
    }


}
