package com.cognizant.onlinefooddeliverysystem.service;


import com.cognizant.onlinefooddeliverysystem.exception.InvalidRequestException;
import com.cognizant.onlinefooddeliverysystem.model.Delivery;
import com.cognizant.onlinefooddeliverysystem.model.DeliveryAgent;
import com.cognizant.onlinefooddeliverysystem.repository.DeliveryDao;
import com.cognizant.onlinefooddeliverysystem.util.OrderId_DeliveryId;
import com.cognizant.onlinefooddeliverysystem.model.Order;
import com.cognizant.onlinefooddeliverysystem.dto.UnassignedOrderDTO;
import com.cognizant.onlinefooddeliverysystem.repository.DeliveryAgentDao;
import com.cognizant.onlinefooddeliverysystem.repository.OrderDao;
import com.cognizant.onlinefooddeliverysystem.util.ProbabilisticQuantum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class DeliveryService {

    // Defining Logger
    private static final Logger logger = LoggerFactory.getLogger(DeliveryService.class);


    // Defining constants for magic numbers
    private static final int PICKUP_TIME_OFFSET_MINUTES = 10;
    private static final int ESTIMATED_TRAVEL_TIME_MINUTES = 12;


    OrderDao orderDao;
    DeliveryDao deliveryDao;
    DeliveryAgentDao deliveryAgentDao;

    @Autowired
    public DeliveryService(OrderDao orderDao, DeliveryDao deliveryDao, DeliveryAgentDao deliveryAgentDao){
        this.orderDao = orderDao;
        this.deliveryDao = deliveryDao;
        this.deliveryAgentDao = deliveryAgentDao;
    }



    public ResponseEntity<List<UnassignedOrderDTO>> getUnassignedOrders(Integer restaurantId) {

        logger.info("Fetching unassigned orders for restaurant ID: {}", restaurantId);
        List<UnassignedOrderDTO> unassignedOrderDTOS = orderDao.findUnassignedOrders(restaurantId);
        return new ResponseEntity<>(unassignedOrderDTOS, HttpStatus.OK);
    }

    public ResponseEntity<List<DeliveryAgent>> getAllAvailableDeliveryAgent() {
        logger.info("Fetching all available delivery agents");
        List<DeliveryAgent> deliveryAgents = deliveryAgentDao.findAllAvailableDeliveryAgent();
        return new ResponseEntity<>(deliveryAgents, HttpStatus.OK);
    }


    public ResponseEntity<Order> findOrderById(Integer orderId)  {

        logger.info("Fetching order with ID: {}", orderId);

        Order order = null;

        try{
            order = orderDao.findOrderByOrderId(orderId)
                .orElseThrow(() -> new Exception("Error while fetching Order"));
//            Optional<Order> optionalOrder =  orderDao.findOrderByOrderId(orderId);
//            if(optionalOrder.isPresent()) {
//                order = optionalOrder.get();
//            }else {
//                throw new Exception("Error while fetching Order");
//            }
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return new ResponseEntity<>(order,HttpStatus.OK);
    }

    public ResponseEntity<Boolean> assignOrder(Integer id) {
        boolean flag = false;
        try{
            Optional<OrderId_DeliveryId> optionalOrderIdDeliveryId = orderDao.findOrderIdDeliveryID(id);
            if(optionalOrderIdDeliveryId.isPresent()) {
                OrderId_DeliveryId orderIdDeliveryId = optionalOrderIdDeliveryId.get();
                if(orderIdDeliveryId.getDeliveryId() != null) {
                    throw new InvalidRequestException("Order with orderId: " + id + " Already has a delivery assigned");
                }else {

                    Integer orderId = orderIdDeliveryId.getOrderId();


                    List<Integer> deliveryAgentsIds = deliveryAgentDao.findAllAvailableDeliveryAgents();

                    Integer AgentId = ProbabilisticQuantum.selectRandomElement(deliveryAgentsIds);

                    Optional<DeliveryAgent> optionalDeliveryAgent = deliveryAgentDao.findDeliveryAgentByAgentId(AgentId);
                    Optional<Order> optionalOrder = orderDao.findOrderByOrderId(orderId);
                    if(optionalDeliveryAgent.isPresent() && optionalOrder.isPresent()) {
                        DeliveryAgent deliveryAgent = optionalDeliveryAgent.get();
                        Order order = optionalOrder.get();

                        Delivery delivery = new Delivery();

                        LocalDateTime pickupTime = LocalDateTime.now().plusMinutes(10);
                        LocalDateTime DeliveryTime = null;
                        // TODO: add the food preparation time now hardcoding it
                        // pickupTime -> 10m, food prep time -> 20m, -> toDeliverTime -> 12m
                        // total time of delivery = ( 20 ) + 12 ==> 22m
                        LocalDateTime eta = LocalDateTime.now().plusMinutes(32);

                        // will get from UUID
//                        delivery.setDeliveryId(1221);
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

    public ResponseEntity<Boolean> updateOrderStatus(Integer orderId, Integer statusId) {
        boolean flag = false;
        try{
            int numberOfRowsAffected = orderDao.updateOrderStatus(orderId, statusId);
            if(numberOfRowsAffected == 0) {
                throw  new Exception("Status Not Changed");
            }else {
                flag = true;
            }
        } catch (Exception e) {
            System.out.println("Error while updating order " + e.getMessage());
        }

        return new ResponseEntity<>(flag, HttpStatus.OK);
    }

    public ResponseEntity<String> findDeliveryStatus(Integer orderId) {
        String status = null;
        try{
            Optional<String> optionalStatus = deliveryDao.getDeliveryStatus(orderId);
            if(optionalStatus.isPresent()) {
                status = optionalStatus.get();
            }else{
                throw new Exception("Did not found the Status for Id: " + orderId);
            }
        }catch (Exception e) {
            System.out.println("Error while fetching delivery status." + e.getMessage());
        }
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

}
