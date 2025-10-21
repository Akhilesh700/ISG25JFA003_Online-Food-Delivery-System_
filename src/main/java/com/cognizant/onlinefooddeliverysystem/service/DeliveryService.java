package com.cognizant.onlinefooddeliverysystem.service;

import com.cognizant.onlinefooddeliverysystem.dto.OrderResponseDTO;
import com.cognizant.onlinefooddeliverysystem.dto.order.GetOrderHistoryByDeliveryAgentResponse;
import com.cognizant.onlinefooddeliverysystem.dto.order.UnassignedOrderDTO;
import com.cognizant.onlinefooddeliverysystem.exception.StatusNotChangedException;
import com.cognizant.onlinefooddeliverysystem.model.DeliveryAgent;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface DeliveryService {

    ResponseEntity<List<UnassignedOrderDTO>> getUnassignedOrders();

    ResponseEntity<List<DeliveryAgent>> getAllAvailableDeliveryAgent();

    ResponseEntity<OrderResponseDTO> findOrderById(Integer orderId);

    @Transactional
    ResponseEntity<Boolean> assignOrder(Integer id);

    @Transactional
    ResponseEntity<Boolean> updateOrderStatus(Integer orderId, Integer statusId) throws StatusNotChangedException;

    ResponseEntity<String> findDeliveryStatus(Integer orderId);

    @Transactional
    ResponseEntity<String> updateDeliveryAgentStatus(DeliveryAgent.Status status);

    List<GetOrderHistoryByDeliveryAgentResponse> getOrderHistoryByDeliveryAgent();
}
