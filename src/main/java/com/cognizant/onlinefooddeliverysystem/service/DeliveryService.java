package com.cognizant.onlinefooddeliverysystem.service;


import com.cognizant.onlinefooddeliverysystem.exception.InvalidRequestException;
import com.cognizant.onlinefooddeliverysystem.model.DeliveryAgent;
import com.cognizant.onlinefooddeliverysystem.util.OrderId_DeliveryId;
import com.cognizant.onlinefooddeliverysystem.model.Order;
import com.cognizant.onlinefooddeliverysystem.dto.UnassignedOrderDTO;
import com.cognizant.onlinefooddeliverysystem.repository.DeliveryAgentDao;
import com.cognizant.onlinefooddeliverysystem.repository.DeliveryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeliveryService {

    @Autowired
    DeliveryDao deliveryDao;

    @Autowired
    DeliveryAgentDao deliveryAgentDao;

    public ResponseEntity<List<UnassignedOrderDTO>> getUnassignedOrders(Integer id) {
        List<UnassignedOrderDTO> unassignedOrderDTOS = deliveryDao.findUnassignedOrders(id);
        return new ResponseEntity<>(unassignedOrderDTOS, HttpStatus.OK);
    }

    public ResponseEntity<List<DeliveryAgent>> getAllAvailableDeliveryAgent() {
        List<DeliveryAgent> deliveryAgents = deliveryAgentDao.findAllAvailableDeliveryAgent();
        return new ResponseEntity<>(deliveryAgents, HttpStatus.OK);
    }


    public ResponseEntity<Order> findOrderById(Integer id) {
        Order order = null;
        try{
            Optional<Order> optionalOrder =  deliveryDao.findOrderByOrderId(id);
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
            Optional<OrderId_DeliveryId> optionalOrderIdDeliveryId = deliveryDao.findOrderIdDeliveryID(id);
            if(optionalOrderIdDeliveryId.isPresent()) {
                OrderId_DeliveryId orderIdDeliveryId = optionalOrderIdDeliveryId.get();
                if(orderIdDeliveryId.getDeliveryId() != null) {
                    throw new InvalidRequestException("Order with orderId: " + id + " Already has a delivery assigned");
                }else {
                    List<DeliveryAgent> deliveryAgents = deliveryAgentDao.findAllAvailableDeliveryAgent();
                    //TODO: Add the delivery assignment logic.
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



}
