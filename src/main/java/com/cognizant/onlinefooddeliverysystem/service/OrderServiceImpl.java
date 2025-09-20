package com.cognizant.onlinefooddeliverysystem.service;

import com.cognizant.onlinefooddeliverysystem.dto.order.PlaceOrderRequestDto;
import com.cognizant.onlinefooddeliverysystem.dto.order.PlaceOrderResponseDto;
import com.cognizant.onlinefooddeliverysystem.exception.ResourceNotFoundException;
import com.cognizant.onlinefooddeliverysystem.exception.order.CartItemNotFoundWithCartIdException;
import com.cognizant.onlinefooddeliverysystem.model.*;
import com.cognizant.onlinefooddeliverysystem.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CartRepository cartRepository;
    private final StatusRepository statusRepository;
    private final CartItemRepository cartItemRepository;
    private final OrderItemRepository orderItemRepository;

    private Order createOrder(Cart cart, List<CartItem> cartItems, Status placedStatus, PlaceOrderRequestDto request){
        Order newOrder = new Order();
        newOrder.setCustomer(cart.getCustomer());
        newOrder.setRestaurant(cartItems.getFirst().getMenuItems().getRestaurant());
        newOrder.setStatus(placedStatus);
        newOrder.setTotalAmount(BigDecimal.valueOf(cart.getTotalPrice()));
        newOrder.setSpecialReq(request.getNote());
        return orderRepository.save(newOrder);
    }

    private List<OrderItem> mapOrderItems(List<CartItem> cartItems, Order placedOrder){
        return cartItems.stream().map(cartItem -> {
            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(placedOrder);
            orderItem.setQuantity(cartItem.getQuantity());
            orderItem.setPrice(cartItem.getPrice());
            orderItem.setMenuItems(cartItem.getMenuItems());
            return orderItem;
        } ).toList();
    }

    @Override
    @Transactional
    public PlaceOrderResponseDto placeOrderByCartId(Long cartId, PlaceOrderRequestDto request) {

            Cart cart = cartRepository.findById(cartId)
                    .orElseThrow(() -> new ResourceNotFoundException("Cart not found with ID: " + cartId));

            List<CartItem> cartItems = cartItemRepository.findByCartId(cartId.intValue());
            if(cartItems.isEmpty()){
                throw new CartItemNotFoundWithCartIdException("Cart item not found with cart id");
            }
            Status placedStatus = statusRepository.findById(1)
                    .orElseThrow(() -> new ResourceNotFoundException("Status 'PLACED' not found."));

//            Step 1 : Creation of order
            Order placedOrder = createOrder(cart, cartItems, placedStatus, request);
//            Step 2 : Mapping list of cartItems
            List<OrderItem> orderedItems = mapOrderItems(cartItems, placedOrder);
//          Step 3 : Saving the list of ordered items to database
            orderItemRepository.saveAll(orderedItems);

//            Step 4 : Deleting cart items after the order is placed
            int rowsAffected = cartItemRepository.deleteCartItemsByCartId(cartId);
//            Step 5 : Making the cart empty || Resetting the cart
            cartRepository.resetCartById(cartId);

        return new PlaceOrderResponseDto(
                rowsAffected,
                "Order placed successfully!"
        );
    }
}