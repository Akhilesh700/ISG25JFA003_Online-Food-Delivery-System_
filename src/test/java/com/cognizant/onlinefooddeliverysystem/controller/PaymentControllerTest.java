package com.cognizant.onlinefooddeliverysystem.controller;

import com.cognizant.onlinefooddeliverysystem.dto.payment.PaymentCallbackDTO;
import com.cognizant.onlinefooddeliverysystem.dto.payment.PaymentRequestDTO;
import com.cognizant.onlinefooddeliverysystem.dto.payment.PaymentResponseDTO;
import com.cognizant.onlinefooddeliverysystem.dto.payment.PaymentStatusDTO;
import com.cognizant.onlinefooddeliverysystem.exception.payment.PaymentException;
import com.cognizant.onlinefooddeliverysystem.repository.UserRepository;
import com.cognizant.onlinefooddeliverysystem.security.AuthUtil;
import com.cognizant.onlinefooddeliverysystem.service.PaymentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;

@WebMvcTest(PaymentController.class)
class PaymentControllerTest {

    private static final String API_BASE_PATH = "/api/v1/payments";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private PaymentService paymentService;

    @MockitoBean
    private AuthUtil authUtil;

    @MockitoBean
    private UserRepository userRepository;

    private PaymentRequestDTO paymentRequestDTO;
    private PaymentResponseDTO paymentResponseDTO;
    private PaymentCallbackDTO paymentCallbackDTO;

    @BeforeEach
    void setUp() {
        paymentRequestDTO = new PaymentRequestDTO();
        paymentRequestDTO.setOrderId(1);
        paymentRequestDTO.setPaymentMethod("Credit Card");

        paymentResponseDTO = new PaymentResponseDTO();
        paymentResponseDTO.setPaymentId(101);
        paymentResponseDTO.setPaymentStatus("Pending");

        paymentCallbackDTO = new PaymentCallbackDTO(101, "Credit Card", "1234-5678-9000", 1234, 100.0f);
    }

    //------------------------------------------
    // Tests for initiatePayment()
    //------------------------------------------

    @Test
    @WithMockUser(roles = {"CUSTOMER"})
    void testInitiatePayment_Success() throws Exception {
        // Arrange
        when(paymentService.initiatePayment(any(PaymentRequestDTO.class))).thenReturn(paymentResponseDTO);

        // Act & Assert
        mockMvc.perform(post(API_BASE_PATH + "/initiate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(paymentRequestDTO))
                        .with(csrf()))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.paymentId", is(101)))
                .andExpect(jsonPath("$.paymentStatus", is("Pending")));
    }

    @Test
    @WithMockUser(roles = {"CUSTOMER"})
    void testInitiatePayment_ThrowsPaymentException() throws Exception {
        // Arrange
        String errorMessage = "Order not found";
        when(paymentService.initiatePayment(any(PaymentRequestDTO.class))).thenThrow(new PaymentException(errorMessage));

        // Act & Assert
        mockMvc.perform(post(API_BASE_PATH + "/initiate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(paymentRequestDTO))
                        .with(csrf()))
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertInstanceOf(PaymentException.class, result.getResolvedException()))
                .andExpect(result -> assertEquals(errorMessage, Objects.requireNonNull(result.getResolvedException()).getMessage()));
    }


    //------------------------------------------
    // Tests for dummyCallback()
    //------------------------------------------

    @Test
    @WithMockUser(roles = {"CUSTOMER"})
    void testDummyCallback_Success() throws Exception {
        // Arrange
        String transactionId = "txn_12345abcde";
        when(paymentService.processPaymentResponse(any(PaymentCallbackDTO.class))).thenReturn(transactionId);

        // Act & Assert
        mockMvc.perform(post(API_BASE_PATH + "/dummy-callback")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(paymentCallbackDTO))
                        .with(csrf()))
                .andExpect(status().isAccepted())
                .andExpect(content().string("Callback processed payment's transaction ID : " + transactionId));
    }


    //------------------------------------------
    // Tests for getPaymentStatus()
    //------------------------------------------

    @Test
    @WithMockUser(roles = {"CUSTOMER", "ADMIN"})
    void testGetPaymentStatus_Success_WithResults() throws Exception {
        // Arrange
        Integer orderId = 1;
        List<PaymentStatusDTO> statusList = List.of(
                new PaymentStatusDTO(orderId, "Successful", "txn_123"),
                new PaymentStatusDTO(orderId, "Failed", "txn_456")
        );
        when(paymentService.getPaymentStatus(orderId)).thenReturn(statusList);

        // Act & Assert
        mockMvc.perform(get(API_BASE_PATH + "/status/order/{orderId}", orderId)
                        .accept(MediaType.APPLICATION_JSON)
                        .with(csrf()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].orderId", is(orderId)))
                .andExpect(jsonPath("$[0].paymentStatus", is("Successful")))
                .andExpect(jsonPath("$[1].transactionId", is("txn_456")));
    }

    @Test
    @WithMockUser(roles = {"CUSTOMER", "ADMIN"})
    void testGetPaymentStatus_Success_WithNoResults() throws Exception {
        // Arrange
        Integer orderId = 99;
        when(paymentService.getPaymentStatus(orderId)).thenReturn(Collections.emptyList());

        // Act & Assert
        mockMvc.perform(get(API_BASE_PATH + "/status/order/{orderId}", orderId)
                        .accept(MediaType.APPLICATION_JSON)
                        .with(csrf()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(0)));
    }
}
