package com.cognizant.onlinefooddeliverysystem.controller;

import com.cognizant.onlinefooddeliverysystem.dto.OrderResponseDTO;
import com.cognizant.onlinefooddeliverysystem.model.DeliveryAgent;
import com.cognizant.onlinefooddeliverysystem.dto.order.UnassignedOrderDTO;
import com.cognizant.onlinefooddeliverysystem.service.serviceImpl.DeliveryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.version.path}/deliveries")
public class DeliveryController {

    DeliveryServiceImpl deliveryServiceImpl;

    @Autowired
    DeliveryController(DeliveryServiceImpl deliveryServiceImpl){
        this.deliveryServiceImpl = deliveryServiceImpl;
    }


    //For the manager's dashboard to display orders ready for delivery.
    @GetMapping("/unassigned")
    public ResponseEntity<List<UnassignedOrderDTO>> getUnassignedOrders(@RequestHeader("restId") Integer restId) {
        return deliveryServiceImpl.getUnassignedOrders(restId);
    }


    @GetMapping("/getAvailableAgents")
    public ResponseEntity<List<DeliveryAgent>> getAvailableDeliveryAgent() {
        return deliveryServiceImpl.getAllAvailableDeliveryAgent();
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<OrderResponseDTO> findOrderById(@PathVariable("id") Integer id) {
        return deliveryServiceImpl.findOrderById(id);
    }

    @PostMapping("/assign-order/{orderId}")
    public ResponseEntity<Boolean> assignOrder(@PathVariable("orderId") Integer id) {
        return deliveryServiceImpl.assignOrder(id);
    }


    @PutMapping("{orderId}/status")
    public ResponseEntity<Boolean> updateOrderStatus(@PathVariable("orderId") Integer orderId , @RequestHeader("statusid") Integer statusId){
        return deliveryServiceImpl.updateOrderStatus(orderId, statusId);
    }


    @GetMapping("{orderId}/delivery-status")
    public ResponseEntity<String> getDeliveryStatus(@PathVariable("orderId") Integer orderId){
        return deliveryServiceImpl.findDeliveryStatus(orderId);
    }

}
