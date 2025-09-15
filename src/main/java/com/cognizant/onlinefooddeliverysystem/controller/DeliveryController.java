package com.cognizant.onlinefooddeliverysystem.controller;

import com.cognizant.onlinefooddeliverysystem.model.DeliveryAgent;
import com.cognizant.onlinefooddeliverysystem.model.Order;
import com.cognizant.onlinefooddeliverysystem.dto.UnassignedOrderDTO;
import com.cognizant.onlinefooddeliverysystem.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.version.path}/deliveries")
public class DeliveryController {

    @Autowired
    DeliveryService deliveryService;

    //For the manager's dashboard to display orders ready for delivery.
    @GetMapping("/unassigned")
    public ResponseEntity<List<UnassignedOrderDTO>> getUnassignedOrders(@RequestHeader("restId") Integer restId) {
        return deliveryService.getUnassignedOrders(restId);
    }


    @GetMapping("/getAvailableAgents")
    public ResponseEntity<List<DeliveryAgent>> getAvailableDeliveryAgent() {
        return deliveryService.getAllAvailableDeliveryAgent();
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<Order> findOrderById(@PathVariable("id") Integer id) {
        return deliveryService.findOrderById(id);
    }

    @PostMapping("/assign-order/{orderId}")
    public ResponseEntity<Boolean> assignOrder(@PathVariable("id") Integer id) {
        return deliveryService.assignOrder(id);
    }


    @PutMapping("{orderId}/status")
    public ResponseEntity<Boolean> updateOrderStatus(@PathVariable("orderId") Integer orderId , @RequestHeader("statusid") Integer statusId){
        return deliveryService.updateOrderStatus(orderId, statusId);
    }


    @GetMapping("{orderId}/delivery-status")
    public ResponseEntity<String> getDeliveryStatus(@PathVariable("orderId") Integer orderId){
        return deliveryService.findDeliveryStatus(orderId);
    }

}
