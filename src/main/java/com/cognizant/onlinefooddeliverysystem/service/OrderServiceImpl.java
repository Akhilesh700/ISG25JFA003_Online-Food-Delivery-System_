package com.cognizant.onlinefooddeliverysystem.service;

import com.cognizant.onlinefooddeliverysystem.dto.order.PlaceOrderRequestDto;
import com.cognizant.onlinefooddeliverysystem.exception.ResourceNotFoundException;
import com.cognizant.onlinefooddeliverysystem.model.Cart;
import com.cognizant.onlinefooddeliverysystem.model.Order;
import com.cognizant.onlinefooddeliverysystem.model.Status;
import com.cognizant.onlinefooddeliverysystem.repository.CartRepository;
import com.cognizant.onlinefooddeliverysystem.repository.OrderRepository;
import com.cognizant.onlinefooddeliverysystem.repository.StatusRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CartRepository cartRepository;
    private final StatusRepository statusRepository;

    @Override
    @Transactional
    public Order placeOrderByCartId(Long cartId, PlaceOrderRequestDto request) {

            Cart cart = cartRepository.findById(Math.toIntExact(Long.valueOf(cartId)))
                    .orElseThrow(() -> new ResourceNotFoundException("Cart not found with ID: " + cartId));

            Status placedStatus = statusRepository.findById(1)
                    .orElseThrow(() -> new ResourceNotFoundException("Status 'PLACED' not found."));

            Order newOrder = new Order();
            newOrder.setCustomer(cart.getCustomer());

            if (cart.getCartItems() != null && !cart.getCartItems().isEmpty()) {
                newOrder.setRestaurant(cart.getCartItems().getFirst().getMenuItems().getRestaurant());
            } else {
                throw new IllegalArgumentException("Cannot place an order for an empty cart.");
            }
            BigDecimal totalAmount = BigDecimal.valueOf(cart.getTotalPrice());

            newOrder.setTotalAmount(totalAmount);
            newOrder.setOrderTime(LocalDateTime.now());
            newOrder.setStatus(placedStatus);
            newOrder.setCart(cart);

        return orderRepository.save(newOrder);
    }
}