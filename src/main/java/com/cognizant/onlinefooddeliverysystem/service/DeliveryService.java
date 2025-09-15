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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class DeliveryService {

    @Autowired
    OrderDao orderDao;

    @Autowired
    DeliveryDao deliveryDao;

    @Autowired
    DeliveryAgentDao deliveryAgentDao;

    public ResponseEntity<List<UnassignedOrderDTO>> getUnassignedOrders(Integer id) {
        List<UnassignedOrderDTO> unassignedOrderDTOS = orderDao.findUnassignedOrders(id);
        return new ResponseEntity<>(unassignedOrderDTOS, HttpStatus.OK);
    }

    public ResponseEntity<List<DeliveryAgent>> getAllAvailableDeliveryAgent() {
        List<DeliveryAgent> deliveryAgents = deliveryAgentDao.findAllAvailableDeliveryAgent();
        return new ResponseEntity<>(deliveryAgents, HttpStatus.OK);
    }


    public ResponseEntity<Order> findOrderById(Integer id) {
        Order order = null;
        try{
            Optional<Order> optionalOrder =  orderDao.findOrderByOrderId(id);
            if(optionalOrder.isPresent()) {
                order = optionalOrder.get();
            }else {
                throw new Exception("Error while fetching Order");
            }
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
                    //TODO: Add the delivery assignment logic.
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
                        // total time of delivery = (20 - 10) + 12 ==> 22m
                        LocalDateTime eta = LocalDateTime.now().plusMinutes(22);

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
