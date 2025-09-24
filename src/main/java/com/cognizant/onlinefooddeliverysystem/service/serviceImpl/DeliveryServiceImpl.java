package com.cognizant.onlinefooddeliverysystem.service.serviceImpl;


import com.cognizant.onlinefooddeliverysystem.dto.OrderResponseDTO;
import com.cognizant.onlinefooddeliverysystem.exception.InvalidRequestException;
import com.cognizant.onlinefooddeliverysystem.exception.ResourceNotFoundException;
import com.cognizant.onlinefooddeliverysystem.exception.StatusNotChangedException;
import com.cognizant.onlinefooddeliverysystem.model.*;
import com.cognizant.onlinefooddeliverysystem.repository.DeliveryDao;
import com.cognizant.onlinefooddeliverysystem.repository.UserRepository;
import com.cognizant.onlinefooddeliverysystem.service.DeliveryService;
import com.cognizant.onlinefooddeliverysystem.service.GetVerifiedUser;
import com.cognizant.onlinefooddeliverysystem.util.OrderIdDeliveryId;
import com.cognizant.onlinefooddeliverysystem.dto.order.UnassignedOrderDTO;
import com.cognizant.onlinefooddeliverysystem.repository.DeliveryAgentDao;
import com.cognizant.onlinefooddeliverysystem.repository.OrderRepository;
import com.cognizant.onlinefooddeliverysystem.util.ProbabilisticQuantum;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DeliveryServiceImpl implements DeliveryService {

    // Defining Logger
    private static final Logger logger = LoggerFactory.getLogger(DeliveryServiceImpl.class);


    // Defining constants for magic numbers
    private static final int PICKUP_TIME_OFFSET_MINUTES = 10;
    private static final int ESTIMATED_TRAVEL_TIME_MINUTES = 12;


    private final OrderRepository orderRepository;
    private final DeliveryDao deliveryDao;
    private final DeliveryAgentDao deliveryAgentDao;
    private final ModelMapper modelMapper;
    private final GetVerifiedUser getVerifiedUser;


    @Override
    public ResponseEntity<List<UnassignedOrderDTO>> getUnassignedOrders(Integer restaurantId) {

        logger.info("Fetching unassigned orders for restaurant ID: {}", restaurantId);
        List<UnassignedOrderDTO> unassignedOrderDTOS = orderRepository.findUnassignedOrders(restaurantId);
        return new ResponseEntity<>(unassignedOrderDTOS, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<DeliveryAgent>> getAllAvailableDeliveryAgent() {
        logger.info("Fetching all available delivery agents");
        List<DeliveryAgent> deliveryAgents = deliveryAgentDao.findAllAvailableDeliveryAgent();
        return new ResponseEntity<>(deliveryAgents, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<OrderResponseDTO> findOrderById(Integer orderId)  {

        logger.info("Fetching order with ID: {}", orderId);
        Order order = orderRepository.findOrderByOrderId(orderId)
            .orElseThrow(() -> new ResourceNotFoundException("Error while fetching Order"));
        OrderResponseDTO orderResponseDTO = modelMapper.map(order, OrderResponseDTO.class);
        return new ResponseEntity<>(orderResponseDTO,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Boolean> assignOrder(Integer id) {

        logger.info("Attempting to assign order with ID: {}", id);


        boolean flag = false;
        try{
            Optional<OrderIdDeliveryId> optionalOrderIdDeliveryId = orderRepository.findOrderIdDeliveryID(id);
            if(optionalOrderIdDeliveryId.isPresent()) {
                OrderIdDeliveryId orderIdDeliveryId = optionalOrderIdDeliveryId.get();
                if(orderIdDeliveryId.getDeliveryId() != null) {
                    throw new InvalidRequestException("Order with orderId: " + id + " Already has a delivery assigned");
                }else {

                    Integer orderId = orderIdDeliveryId.getOrderId();


                    List<Integer> deliveryAgentsIds = deliveryAgentDao.findAllAvailableDeliveryAgents();

                    Integer agentId = ProbabilisticQuantum.selectRandomElement(deliveryAgentsIds);

                    Optional<DeliveryAgent> optionalDeliveryAgent = deliveryAgentDao.findDeliveryAgentByAgentId(agentId);
                    Optional<Order> optionalOrder = orderRepository.findOrderByOrderId(orderId);
                    if(optionalDeliveryAgent.isPresent() && optionalOrder.isPresent()) {
                        DeliveryAgent deliveryAgent = optionalDeliveryAgent.get();
                        Order order = optionalOrder.get();

                        Delivery delivery = new Delivery();

                        LocalDateTime pickupTime = LocalDateTime.now().plusMinutes(10);

                        // TODO: add the food preparation time now hardcoding it
                        // pickupTime -> 10m, food prep time -> 20m, -> toDeliverTime -> 12m
                        // total time of delivery = ( 20 ) + 12 ==> 22m
                        int totalETA = (20 - PICKUP_TIME_OFFSET_MINUTES ) + PICKUP_TIME_OFFSET_MINUTES + ESTIMATED_TRAVEL_TIME_MINUTES;
                        LocalDateTime eta = LocalDateTime.now().plusMinutes(totalETA);

                        // delivery Id get from UUID
                        delivery.setDeliveryTime(null);
                        delivery.setPickupTime(pickupTime);
                        delivery.setEta(eta);
                        delivery.setOrder(order);
                        delivery.setDeliveryAgent(deliveryAgent);

                        deliveryDao.save(delivery);

                    }else{
                        throw new Exception("Agent or Order is not present");
                    }


                    flag = true;
                }
            }else{
                throw new Exception("No row found");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return new ResponseEntity<>(flag, HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity<Boolean> updateOrderStatus(Integer orderId, Integer statusId) throws StatusNotChangedException {

        logger.info("Updating status for order ID: {} to status ID: {}", orderId, statusId);

        boolean flag = false;

        int numberOfRowsAffected = orderRepository.updateOrderStatus(orderId, statusId);

        if(numberOfRowsAffected == 0) {
              throw new StatusNotChangedException("Status Not Changed");
        }else {
            flag = true;
        }


        return new ResponseEntity<>(flag, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> findDeliveryStatus(Integer orderId) {
        logger.info("Fetching delivery status for order ID: {}", orderId);

        String status = deliveryDao.getDeliveryStatus(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("No status for order id: " + orderId ));
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> updateDeliveryAgentStatus(DeliveryAgent.Status status){
        if(status == null) {
            throw new StatusNotChangedException("Invalid Status.");
        }
        User user = getVerifiedUser.getVerifiedUser();
        DeliveryAgent deliveryAgent = deliveryAgentDao.findDeliveryAgentByUserId(user.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("Delivery Agent with User ID: " + user.getUserId() + " Not Found."));


        deliveryAgent.setStatus(status);

        return new ResponseEntity<>("Status Has Been Changed to  " + status.toString() + ".", HttpStatus.OK);
    }


}
