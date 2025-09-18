package com.cognizant.onlinefooddeliverysystem.service;

import com.cognizant.onlinefooddeliverysystem.dto.cart.CartRequestDto;
import com.cognizant.onlinefooddeliverysystem.dto.cart.OrderItemDto;
import com.cognizant.onlinefooddeliverysystem.exception.CartNotFoundException;
import com.cognizant.onlinefooddeliverysystem.exception.CustomerNotFoundException;
import com.cognizant.onlinefooddeliverysystem.exception.EmptyCartException;
import com.cognizant.onlinefooddeliverysystem.exception.MenuItemNotFoundException;
import com.cognizant.onlinefooddeliverysystem.model.Cart;
import com.cognizant.onlinefooddeliverysystem.model.CartItem;
import com.cognizant.onlinefooddeliverysystem.model.Customer;
import com.cognizant.onlinefooddeliverysystem.model.MenuItems;
import com.cognizant.onlinefooddeliverysystem.repository.CartItemRepository;
import com.cognizant.onlinefooddeliverysystem.repository.CartRepository;
import com.cognizant.onlinefooddeliverysystem.repository.CustomerRepository;
import com.cognizant.onlinefooddeliverysystem.repository.MenuRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.internal.Pair;
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
    CustomerRepository customerRepository;
    MenuRepository menuRepository;


    private Pair<List<CartItem>, Float> cartItemHelper(List<OrderItemDto> menuItems, Cart cart) {

        List<CartItem> result;
        final float[] totalPrice = {0.0f};

        result = menuItems.stream()
                .map(item -> {
                    Long menuItemId = item.getMenuItemId();
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

        return Pair.of(result, totalPrice[0]);
    }


    @Override
    @Transactional
    public Long addToCart(Integer customerId,CartRequestDto request){


        List<OrderItemDto> menuItems = Optional.ofNullable(request.getOrderItems())
                .filter(list -> !list.isEmpty())
                .orElseThrow(() -> new EmptyCartException("no menu items found."));



        Cart cart = cartRepository.findCartByCustId(customerId)
                .orElseThrow(() -> new CartNotFoundException("No cart found against customer id: " + customerId ));


        Pair<List<CartItem>, Float> pair = cartItemHelper(menuItems, cart);
        List<CartItem> cartItems = pair.getLeft();
        Float totalPrice = pair.getRight();

        cart.setCartItems(cartItems);
        cart.setNote(request.getNote());
        cart.setTotalPrice(totalPrice);


        cartItemRepository.saveAll(cartItems);
        cartRepository.save(cart);

        return cart.getId();
    }
}
