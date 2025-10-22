package com.cognizant.onlinefooddeliverysystem.controller;


import com.cognizant.onlinefooddeliverysystem.dto.OrderResponseDTO;
import com.cognizant.onlinefooddeliverysystem.dto.order.UnassignedOrderDTO;
import com.cognizant.onlinefooddeliverysystem.model.DeliveryAgent;
import com.cognizant.onlinefooddeliverysystem.model.Status;
import com.cognizant.onlinefooddeliverysystem.repository.UserRepository;
import com.cognizant.onlinefooddeliverysystem.security.AuthUtil;
import com.cognizant.onlinefooddeliverysystem.service.implimentation.DeliveryServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;


import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;

@WebMvcTest(DeliveryController.class)
class DeliveryControllerTest {

    private static final String API_BASE_PATH = "/api/v1/deliveries"; // Assuming api.version.path=api/v1

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private DeliveryServiceImpl deliveryService;

    @MockitoBean
    private AuthUtil authUtil;

    @MockitoBean
    private UserRepository userRepository;

    private UnassignedOrderDTO unassignedOrderDTO;
    private DeliveryAgent deliveryAgent;
    private OrderResponseDTO orderResponseDTO;

    @BeforeEach
    void setUp() {
        unassignedOrderDTO =  UnassignedOrderDTO.builder()
                .orderId(101)
                .restId(1)
                .orderTime(Timestamp.from(Instant.now()))
                .specialReq("No Onions")
                .totalAmount(new BigDecimal("750.50"))
                .statusType(Status.StatusType.PLACED.toString())
                .address("456 Oak Avenue")
                .name("Jane Doe")
                .phone("555-0102")
                .build();

        deliveryAgent = DeliveryAgent.builder()
                .agentId(1)
                .name("John Doe")
                .status(DeliveryAgent.Status.Available)
                .build();

        orderResponseDTO = OrderResponseDTO.builder()
                .orderId(101)
                .totalAmount(BigDecimal.valueOf(500.0))
                .build();
    }

    @Test
    @WithMockUser(roles = {"RESTAURANT"})
    void testGetUnassignedOrders_Success() throws Exception {
        // Arrange
        Integer restaurantId = 1;
        List<UnassignedOrderDTO> unassignedOrders = List.of(unassignedOrderDTO);
        ResponseEntity<List<UnassignedOrderDTO>> responseEntity = new ResponseEntity<>(unassignedOrders, HttpStatus.OK);
        when(deliveryService.getUnassignedOrders()).thenReturn(responseEntity);

        // Act & Assert
        mockMvc.perform(get(API_BASE_PATH + "/unassigned")
                        .header("restId", restaurantId)
                        .accept(MediaType.APPLICATION_JSON)
                        .with(csrf()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].orderId", is(101)));
    }

    @Test
    @WithMockUser(roles = {"RESTAURANT"})
    void testGetAvailableDeliveryAgent_Success() throws Exception {
        // Arrange
        List<DeliveryAgent> availableAgents = List.of(deliveryAgent);
        ResponseEntity<List<DeliveryAgent>> responseEntity = new ResponseEntity<>(availableAgents, HttpStatus.OK);
        when(deliveryService.getAllAvailableDeliveryAgent()).thenReturn(responseEntity);

        // Act & Assert
        mockMvc.perform(get(API_BASE_PATH + "/getAvailableAgents")
                        .accept(MediaType.APPLICATION_JSON)
                        .with(csrf()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is("John Doe")));
    }

    @Test
    @WithMockUser(roles = {"RESTAURANT"})
    void testFindOrderById_Success() throws Exception {
        // Arrange
        Integer orderId = 101;
        ResponseEntity<OrderResponseDTO> responseEntity = new ResponseEntity<>(orderResponseDTO, HttpStatus.OK);
        when(deliveryService.findOrderById(orderId)).thenReturn(responseEntity);

        // Act & Assert
        mockMvc.perform(get(API_BASE_PATH + "/order/{id}", orderId)
                        .accept(MediaType.APPLICATION_JSON)
                        .with(csrf()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.orderId", is(101)))
                .andExpect(jsonPath("$.totalAmount", is(500.0)));
    }

    @Test
    @WithMockUser(roles = {"RESTAURANT"})
    void testAssignOrder_Success() throws Exception {
        // Arrange
        Integer orderId = 101;
        ResponseEntity<Boolean> responseEntity = new ResponseEntity<>(true, HttpStatus.OK);
        when(deliveryService.assignOrder(orderId)).thenReturn(responseEntity);

        // Act & Assert
        mockMvc.perform(post(API_BASE_PATH + "/assign-order/{orderId}", orderId)
                        .with(csrf()))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));
    }

    @Test
    @WithMockUser(roles = {"RESTAURANT", "DELIVERY_AGENT"})
    void testUpdateOrderStatus_Success() throws Exception {
        // Arrange
        Integer orderId = 101;
        Integer statusId = 3; // Example status ID for "Out for Delivery"
        ResponseEntity<Boolean> responseEntity = new ResponseEntity<>(true, HttpStatus.OK);
        when(deliveryService.updateOrderStatus(orderId, statusId)).thenReturn(responseEntity);

        // Act & Assert
        mockMvc.perform(put(API_BASE_PATH + "/{orderId}/status", orderId)
                        .header("statusid", statusId)
                        .with(csrf()))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));
    }

    @Test
    @WithMockUser(roles = {"CUSTOMER"})
    void testGetDeliveryStatus_Success() throws Exception {
        // Arrange
        Integer orderId = 101;
        String deliveryStatus = "Delivered";
        ResponseEntity<String> responseEntity = new ResponseEntity<>(deliveryStatus, HttpStatus.OK);
        when(deliveryService.findDeliveryStatus(orderId)).thenReturn(responseEntity);

        // Act & Assert
        mockMvc.perform(get(API_BASE_PATH + "/{orderId}/delivery-status", orderId)
                        .with(csrf()))
                .andExpect(status().isOk())
                .andExpect(content().string(deliveryStatus));
    }
}
