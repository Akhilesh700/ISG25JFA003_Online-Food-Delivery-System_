package com.cognizant.onlinefooddeliverysystem.controller;

import com.cognizant.onlinefooddeliverysystem.dto.cart.CartRequestDto;
import com.cognizant.onlinefooddeliverysystem.dto.cart.CartResponseDto;
import com.cognizant.onlinefooddeliverysystem.dto.cart.OrderItemDto;
import com.cognizant.onlinefooddeliverysystem.exception.payment.CartNotFoundException;
import com.cognizant.onlinefooddeliverysystem.model.Cart;
import com.cognizant.onlinefooddeliverysystem.model.Customer;
import com.cognizant.onlinefooddeliverysystem.repository.UserRepository;
import com.cognizant.onlinefooddeliverysystem.security.AuthUtil;
import com.cognizant.onlinefooddeliverysystem.service.implimentation.CartServiceImp;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Objects;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.any;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CartController.class)
public class CartControllerTest {

    private static final String API_BASE_PATH = "/api/v1/cart";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private  ObjectMapper objectMapper;

    @MockitoBean
    private CartServiceImp cartServiceImp;

    @MockitoBean
    private AuthUtil authUtil;

    @MockitoBean
    private UserRepository userRepository;

    private CartRequestDto cartRequestDto;
    private CartResponseDto cartResponseDto;
    private Cart cart;
    private Integer customerId;


    @BeforeEach
    void setUp() {
        customerId = 1;

        // Setup for addToCart tests
        OrderItemDto orderItem1 = new OrderItemDto(1L, 2);
        cartRequestDto = new CartRequestDto();
        cartRequestDto.setOrderItems(List.of(orderItem1));
        cartRequestDto.setNote("Please deliver quickly.");

        cartResponseDto = new CartResponseDto(101L); // Assuming the cart ID is 101

        // Setup for getCartByCustomerId tests
        Customer customer = new Customer();
        customer.setCustId(customerId);
        cart = new Cart();
        cart.setId(101);
        cart.setCustomer(customer);
        cart.setTotalPrice(500.0f);
    }


    //------------------------------------------
    // Tests for addToCart()
    //------------------------------------------

    @Test
    @WithMockUser(roles = {"CUSTOMER"})
    void testAddToCart_Success() throws Exception {
        // Arrange: Mock the service to return a successful response
        when(cartServiceImp.addToCart(eq(customerId), any(CartRequestDto.class))).thenReturn(cartResponseDto);

        // Act & Assert
        mockMvc.perform(post(API_BASE_PATH + "/add")
                        .header("customerId", customerId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(cartRequestDto))
                        .with(csrf()))
                .andExpect(status().isOk());


    }

    @Test
    @WithMockUser(roles = {"CUSTOMER"})
    void testAddToCart_MissingCustomerIdHeader() throws Exception {
        // Act & Assert: Perform the request without the required header
        mockMvc.perform(post(API_BASE_PATH + "/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(cartRequestDto))
                        .with(csrf()))
                .andExpect(status().isInternalServerError());
    }

    //------------------------------------------
    // Tests for getCartByCustomerId()
    //------------------------------------------

    @Test
    @WithMockUser(roles = {"CUSTOMER"})
    void testGetCartByCustomerId_Success() throws Exception {
        // Arrange: Mock the service to return a cart
        when(cartServiceImp.getCartByCustomerId(customerId)).thenReturn(cart);

        // Act & Assert
        mockMvc.perform(get(API_BASE_PATH + "/get-cart-by-customer/{customerId}", customerId)
                        .accept(MediaType.APPLICATION_JSON)
                        .with(csrf()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(cart.getId()))
                .andExpect(jsonPath("$.note").value(cart.getNote()))
                .andExpect(jsonPath("$.totalPrice").value(cart.getTotalPrice()));
    }


    @Test
    @WithMockUser(roles = {"CUSTOMER", "ADMIN"})
    void testGetCartByCustomerId_NotFound() throws Exception {
        // Arrange: Mock the service to throw a CartNotFoundException
        int nonExistentCustomerId = 999;
        String expectedErrorMessage = "No cart for customer " + nonExistentCustomerId;
        when(cartServiceImp.getCartByCustomerId(nonExistentCustomerId))
                .thenThrow(new CartNotFoundException(expectedErrorMessage));

        // Act & Assert
        mockMvc.perform(get(API_BASE_PATH + "/get-cart-by-customer/{customerId}", nonExistentCustomerId)
                        .accept(MediaType.APPLICATION_JSON)
                        .with(csrf()))
                // Note: The default behavior for an uncaught exception is a 500 Internal Server Error.
                // If you have a @ControllerAdvice to handle CartNotFoundException and return a 404,
                // you would change this expectation to .andExpect(status().isNotFound()).
                .andExpect(status().isNotFound())
                .andExpect(result -> Assertions.assertInstanceOf(CartNotFoundException.class, result.getResolvedException()))
                .andExpect(result -> Assertions.assertEquals(expectedErrorMessage, Objects.requireNonNull(result.getResolvedException()).getMessage()));
    }











}
