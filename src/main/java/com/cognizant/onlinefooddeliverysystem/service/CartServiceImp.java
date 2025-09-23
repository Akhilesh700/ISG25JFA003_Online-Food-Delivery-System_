package com.cognizant.onlinefooddeliverysystem.service;

import com.cognizant.onlinefooddeliverysystem.dto.cart.CartRequestDto;
import com.cognizant.onlinefooddeliverysystem.dto.cart.CartResponseDto;
import com.cognizant.onlinefooddeliverysystem.dto.cart.OrderItemDto;
import com.cognizant.onlinefooddeliverysystem.exception.*;
import com.cognizant.onlinefooddeliverysystem.model.*;
import com.cognizant.onlinefooddeliverysystem.repository.*;
import lombok.AllArgsConstructor;
import org.modelmapper.internal.Pair;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CartServiceImp implements CartService {

    CartItemRepository cartItemRepository;
    CartRepository cartRepository;
    MenuRepository menuRepository;
    private final CustomerRepository customerRepository;
    private final UserRepository userRepository;
    private final GetVerifiedUser getVerifiedUser;


    private Pair<List<CartItem>, Float> cartItemHelper(List<OrderItemDto> menuItems, Cart cart) {

        List<CartItem> result;
        final float[] totalPrice = {0.0f};

        result = menuItems.stream()
                .map(item -> {

                    Long menuItemId = item.getMenuItemId();
                    System.out.println(menuItemId);
                    Integer quantity = item.getQuantity();
                    MenuItems menuItem = menuRepository.findMenuItemsByItemId(menuItemId)
                            .orElseThrow(() -> new MenuItemNotFoundException("Menu item for Id: " + menuItemId + " not found"));

                    float price = quantity * menuItem.getPrice().toBigInteger().floatValue();

                    totalPrice[0] += price;
                    CartItem cartItem = new CartItem();

                    cartItem.setCart(cart);
                    cartItem.setMenuItems(menuItem);
                    cartItem.setQuantity(quantity);
                    cartItem.setPrice(price);
                    return cartItem;
                })
                .toList();

        return Pair.of(result,totalPrice[0]);
    }


    @Override
    @Transactional
    public CartResponseDto addToCart(Integer customerIdd, CartRequestDto request){
        List<OrderItemDto> menuItems = Optional.ofNullable(request.getOrderItems())
                .filter(list -> !list.isEmpty())
                .orElseThrow(() -> new EmptyCartException("no menu items found."));

        User user = getVerifiedUser.getVerifiedUser();
        Customer customer = customerRepository.findByUser_UserId(user.getUserId());
        int customerId = customer.getCustId();

        Cart cart = cartRepository.findCartByCustId(customerId)
                .orElseThrow(() -> new CartNotFoundException("No cart found against customer id: " + customerId ));


        Pair<List<CartItem>, Float> pair = cartItemHelper(menuItems, cart);

        List<CartItem> cartItems = pair.getLeft();
        Float price = pair.getRight();

        cart.setCartItems(cartItems);
        cart.setNote(request.getNote());
        cart.setTotalPrice(price);

        cartItemRepository.saveAll(cartItems);

        return new CartResponseDto(cart.getId());
    }

    public Cart getCartByCustomerId(Integer customerId) {
        return cartRepository.findCartByCustId(customerId)
                .orElseThrow(() -> new CartNotFoundException("No cart found against customer id: " + customerId ));
    }

    public Cart getCartByVerifiedUser(){
        User user = getVerifiedUser.getVerifiedUser();
        Customer customer = customerRepository.findByUser_UserId(user.getUserId());
        int customerId = customer.getCustId();
        return getCartByCustomerId(customerId);
    }

}
