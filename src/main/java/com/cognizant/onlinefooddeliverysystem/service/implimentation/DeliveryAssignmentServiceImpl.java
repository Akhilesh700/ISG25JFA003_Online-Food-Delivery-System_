package com.cognizant.onlinefooddeliverysystem.service.implimentation;

import com.cognizant.onlinefooddeliverysystem.exception.InvalidRequestException;
import com.cognizant.onlinefooddeliverysystem.exception.ResourceNotFoundException;
import com.cognizant.onlinefooddeliverysystem.exception.delivery.NoAvailableAgentsException;
import com.cognizant.onlinefooddeliverysystem.model.Delivery;
import com.cognizant.onlinefooddeliverysystem.model.DeliveryAgent;
import com.cognizant.onlinefooddeliverysystem.model.Order;
import com.cognizant.onlinefooddeliverysystem.repository.DeliveryAgentDao;
import com.cognizant.onlinefooddeliverysystem.repository.DeliveryDao;
import com.cognizant.onlinefooddeliverysystem.repository.OrderItemRepository;
import com.cognizant.onlinefooddeliverysystem.repository.OrderRepository;
import com.cognizant.onlinefooddeliverysystem.util.OrderIdDeliveryId;
import com.cognizant.onlinefooddeliverysystem.util.ProbabilisticQuantum;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DeliveryAssignmentServiceImpl {

    private static final Logger logger = LoggerFactory.getLogger(DeliveryAssignmentServiceImpl.class);

    private static final int PICKUP_TIME_OFFSET_MINUTES = 10;
    private static final int ESTIMATED_TRAVEL_TIME_MINUTES = 12;

    private final OrderRepository orderRepository;
    private final DeliveryAgentDao deliveryAgentDao;
    private final DeliveryDao deliveryDao;
    private final OrderItemRepository orderItemRepository;

    /**
     * Main method to assign an order to a delivery agent.
     * @param orderId The id of the order that will be assigned
     * @return delivery Object
     */

    @Transactional
    public Delivery assignOrder(Integer orderId) {
        logger.info("Attempting to assign order with ID: {}", orderId);

        // 1. Validate that the order exists and is not already assigned
        validateOrderIsAssignable(orderId);

        // 2. Fetch the full order details
        Order order = orderRepository.findOrderByOrderId(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order with orderId: " + orderId + " not found."));

        // 3. Find and select an available delivery agent
        DeliveryAgent selectedAgent = findAndSelectAvailableAgent();

        // 4. Create and save the new delivery record
        Delivery newDelivery = createDelivery(order, selectedAgent);
        deliveryDao.save(newDelivery);

        logger.info("Successfully assigned order {} to delivery agent {}", orderId, selectedAgent.getAgentId());
        return newDelivery;
    }

    /**
     * This private method is a help for the main assign method
     * solo purpose of this method is to check deliveryId against orderId is null
     * @param orderId The id of Order
     * @throws ResourceNotFoundException if no order projection is found
     * @throws InvalidRequestException   if the order already has a delivery assigned.
     */

    private void validateOrderIsAssignable(Integer orderId) {
        OrderIdDeliveryId orderInfo = orderRepository.findOrderIdDeliveryID(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("No order found for ID: " + orderId));

        if (orderInfo.getDeliveryId() != null) {
            logger.warn("Order {} is already assigned to a delivery.", orderId);
            throw new InvalidRequestException("Order with orderId: " + orderId + " already has a delivery assigned.");
        }
    }

    /**
     * Finds all available delivery agents and selects one randomly.
     *
     * @return The selected DeliveryAgent.
     * @throws NoAvailableAgentsException if no agents are available.
     * @throws ResourceNotFoundException  if the selected agent's ID is invalid.
     */

    private DeliveryAgent findAndSelectAvailableAgent() {
        List<Integer> availableAgentIds = deliveryAgentDao.findAllAvailableDeliveryAgents();
        if (availableAgentIds.isEmpty()) {
            logger.error("No delivery agents are available for assignment.");
            throw new NoAvailableAgentsException("No delivery agents are currently available.");
        }

        Integer selectedAgentId = ProbabilisticQuantum.selectRandomElement(availableAgentIds);

        return deliveryAgentDao.findDeliveryAgentByAgentId(selectedAgentId)
                .orElseThrow(() -> new ResourceNotFoundException("Selected delivery agent with ID: " + selectedAgentId + " not found."));
    }

    /**
     * Creates new Delivery entity.
     * @param order The order to be delivered.
     * @param agent The agent assigned to the delivery.
     * @return The Delivery object, ready to be saved.
     */

    private Delivery createDelivery(Order order, DeliveryAgent agent) {
        Delivery delivery = new Delivery();
        LocalDateTime now = LocalDateTime.now();

        LocalDateTime pickupTime = now.plusMinutes(PICKUP_TIME_OFFSET_MINUTES);

        // The total ETA is from now until the food is delivered.
        Float maxPreparationTime = orderItemRepository.findMaxPrepTimeByOrderId(order.getOrderId());
        float totalEtaMinutes =  maxPreparationTime + ESTIMATED_TRAVEL_TIME_MINUTES;
        LocalDateTime eta = now.plusMinutes((long) totalEtaMinutes);

        delivery.setOrder(order);
        delivery.setDeliveryAgent(agent);
        delivery.setPickupTime(pickupTime);
        delivery.setEta(eta);
        delivery.setDeliveryTime(null); // Delivery is not yet completed.

        return delivery;
    }


}
