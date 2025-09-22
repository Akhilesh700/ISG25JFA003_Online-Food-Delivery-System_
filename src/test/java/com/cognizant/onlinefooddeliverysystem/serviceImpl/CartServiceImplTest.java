package com.cognizant.onlinefooddeliverysystem.serviceImpl;


import com.cognizant.onlinefooddeliverysystem.dto.cart.CartRequestDto;
import com.cognizant.onlinefooddeliverysystem.dto.cart.CartResponseDto;
import com.cognizant.onlinefooddeliverysystem.dto.cart.OrderItemDto;
import com.cognizant.onlinefooddeliverysystem.exception.payment.CartNotFoundException;
import com.cognizant.onlinefooddeliverysystem.exception.EmptyCartException;
import com.cognizant.onlinefooddeliverysystem.exception.MenuItemNotFoundException;
import com.cognizant.onlinefooddeliverysystem.model.Cart;
import com.cognizant.onlinefooddeliverysystem.model.CartItem;
import com.cognizant.onlinefooddeliverysystem.model.Customer;
import com.cognizant.onlinefooddeliverysystem.model.MenuItems;
import com.cognizant.onlinefooddeliverysystem.repository.CartItemRepository;
import com.cognizant.onlinefooddeliverysystem.repository.CartRepository;
import com.cognizant.onlinefooddeliverysystem.repository.MenuRepository;
import com.cognizant.onlinefooddeliverysystem.service.CartServiceImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.never;

@ExtendWith(MockitoExtension.class)
public class CartServiceImplTest {

    @Mock
    private CartItemRepository cartItemRepository;

    @Mock
    private CartRepository cartRepository;

    @Mock
    private MenuRepository menuRepository;

    @InjectMocks
    private CartServiceImp cartServiceImp;

    private Customer customer;
    private Cart cart;
    private MenuItems menuItem1, menuItem2;
    private CartRequestDto cartRequestDto;

    @BeforeEach
    void setUp() {
        customer = new Customer();
        customer.setCustId(1);

        cart = new Cart();
        cart.setId(101);
        cart.setCustomer(customer);

        menuItem1 = new MenuItems();
        menuItem1.setItemId(1);
        menuItem1.setName("Pizza");
        menuItem1.setPrice(BigDecimal.valueOf(250.00));

        menuItem2 = new MenuItems();
        menuItem2.setItemId(2);
        menuItem2.setName("Burger");
        menuItem2.setPrice(BigDecimal.valueOf(150.00));

        OrderItemDto orderItem1 = new OrderItemDto(1L, 2); // 2 * 250 = 500
        OrderItemDto orderItem2 = new OrderItemDto(2L, 1); // 1 * 150 = 150
        cartRequestDto = new CartRequestDto();
        cartRequestDto.setOrderItems(List.of(orderItem1, orderItem2));
        cartRequestDto.setNote("Extra cheese");
    }


    //------------------------------------------
    // Tests for addToCart()
    //------------------------------------------


    @Test
    void testAddToCart_Success(){
        // mock the behaviour of repo methods
        when(cartRepository.findCartByCustId(1)).thenReturn(Optional.of(cart));
        when(menuRepository.findMenuItemsByItemId(1L)).thenReturn(Optional.of(menuItem1));
        when(menuRepository.findMenuItemsByItemId(2L)).thenReturn(Optional.of(menuItem2));

        // calling service method
        CartResponseDto response = cartServiceImp.addToCart(1, cartRequestDto);

        // verify result
        Assertions.assertNotNull(response);
        Assertions.assertEquals(cart.getId(), response.getCartId());

        // use ArgumentCaptor to capture the list passed to saveAll
        ArgumentCaptor<List<CartItem>> cartItemCaptor = ArgumentCaptor.forClass(List.class);
        verify(cartItemRepository).saveAll(cartItemCaptor.capture());
        List<CartItem> savedCartItems = cartItemCaptor.getValue();

        // check the captured values

        Assertions.assertEquals(2, savedCartItems.size());
        Assertions.assertEquals(650.00f, cart.getTotalPrice()); // 500 + 150
        Assertions.assertEquals("Extra cheese", cart.getNote());


        // verifying repo called as expected
        verify(cartRepository, times(1)).findCartByCustId(1);
        verify(menuRepository, times(2)).findMenuItemsByItemId(anyLong());

    }

    @Test
    void testAddToCart_ThrowsEmptyCartException_WhenOrderItemsAreNull() {
        // create
        CartRequestDto emptyRequest = new CartRequestDto();
        emptyRequest.setOrderItems(null);

        // Act & Assert
        Exception exception = Assertions.assertThrows(EmptyCartException.class, () -> {
            cartServiceImp.addToCart(1, emptyRequest);
        });
        Assertions.assertEquals("no menu items found.", exception.getMessage());

        // Verify that no repository methods were called
        verifyNoInteractions(cartRepository, menuRepository, cartItemRepository);
    }

    @Test
    void testAddToCart_ThrowsEmptyCartException_WhenOrderItemsAreEmpty() {
        // Arrange
        CartRequestDto emptyRequest = new CartRequestDto();
        emptyRequest.setOrderItems(Collections.emptyList());

        // Act & Assert
        Exception exception = Assertions.assertThrows(EmptyCartException.class, () -> {
            cartServiceImp.addToCart(1, emptyRequest);
        });
        Assertions.assertEquals("no menu items found.", exception.getMessage());
        verifyNoInteractions(cartRepository, menuRepository, cartItemRepository);
    }


    @Test
    void testAddToCart_ThrowsCartNotFoundException() {
        // Arrange
        when(cartRepository.findCartByCustId(99)).thenReturn(Optional.empty());

        // Act & Assert
        Exception exception = Assertions.assertThrows(CartNotFoundException.class, () -> {
            cartServiceImp.addToCart(99, cartRequestDto);
        });
        Assertions.assertEquals("No cart found against customer id: 99", exception.getMessage());

        // Verify only cartRepository was called
        verify(cartRepository, times(1)).findCartByCustId(99);
        verifyNoInteractions(menuRepository, cartItemRepository);
    }


    @Test
    void testAddToCart_ThrowsMenuItemNotFoundException() {
        // Arrange: Mock one of the menu items as not found
        when(cartRepository.findCartByCustId(1)).thenReturn(Optional.of(cart));
        when(menuRepository.findMenuItemsByItemId(1L)).thenReturn(Optional.of(menuItem1));
        when(menuRepository.findMenuItemsByItemId(2L)).thenReturn(Optional.empty()); // Item not found

        // Act & Assert
        Exception exception = Assertions.assertThrows(MenuItemNotFoundException.class, () -> {
            cartServiceImp.addToCart(1, cartRequestDto);
        });
        Assertions.assertEquals("Menu item for Id: 2 not found", exception.getMessage());

        // Verify saveAll was never called
        verify(cartItemRepository, never()).saveAll(any());
    }


    //------------------------------------------
    // Tests for getCartByCustomerId()
    //------------------------------------------

    @Test
    void testGetCartByCustomerId_Success() {
        // Arrange
        when(cartRepository.findCartByCustId(1)).thenReturn(Optional.of(cart));

        // Act
        Cart foundCart = cartServiceImp.getCartByCustomerId(1);

        // Assert
        Assertions.assertNotNull(foundCart);
        Assertions.assertEquals(cart.getId(), foundCart.getId());
        Assertions.assertEquals(customer.getCustId(), foundCart.getCustomer().getCustId());
        verify(cartRepository, times(1)).findCartByCustId(1);
    }

    @Test
    void testGetCartByCustomerId_ThrowsCartNotFoundException() {
        // Arrange
        when(cartRepository.findCartByCustId(99)).thenReturn(Optional.empty());

        // Act & Assert
        Exception exception = Assertions.assertThrows(CartNotFoundException.class, () -> {
            cartServiceImp.getCartByCustomerId(99);
        });
        Assertions.assertEquals("No cart found against customer id: 99", exception.getMessage());
        verify(cartRepository, times(1)).findCartByCustId(99);
    }

}
