package com.cognizant.onlinefooddeliverysystem.controller;


import com.cognizant.onlinefooddeliverysystem.dto.cart.CartRequestDto;
import com.cognizant.onlinefooddeliverysystem.dto.cart.CartResponseDto;
import com.cognizant.onlinefooddeliverysystem.model.Cart;
import com.cognizant.onlinefooddeliverysystem.service.implimentation.CartServiceImp;
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
//    @PreAuthorize("hasAuthority('ROLE_CUSTOMER')")
    public ResponseEntity<CartResponseDto> addToCart(@RequestBody CartRequestDto request) {
        CartResponseDto cartId= cartService.addToCart(request);
        return new ResponseEntity<>(cartId, HttpStatus.OK);
    }

    @GetMapping("/get-cart-by-customer/{customerId}")
    //@PreAuthorize("hasAnyAuthority('ROLE_CUSTOMER', 'ROLE_ADMIN')")
    public ResponseEntity<Cart> getCartByCustomerId(@PathVariable("customerId") Integer customerId ) {
        Cart cart = cartService.getCartByCustomerId(customerId);
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

    @GetMapping("/get-cart")
        //@PreAuthorize("hasAnyAuthority('ROLE_CUSTOMER', 'ROLE_ADMIN')")
        public ResponseEntity<Cart> getCartByCustomerId() {
            Cart cart = cartService.getCartByVerifiedUser();
            return new ResponseEntity<>(cart, HttpStatus.OK);
        }


}
