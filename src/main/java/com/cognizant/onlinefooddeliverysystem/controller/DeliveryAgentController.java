package com.cognizant.onlinefooddeliverysystem.controller;

import com.cognizant.onlinefooddeliverysystem.model.DeliveryAgent;
import com.cognizant.onlinefooddeliverysystem.service.DeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("${api.version.path}/delivery-agent")
public class DeliveryAgentController {

    private final DeliveryService deliveryService;

    @PatchMapping("/change-status")
    public ResponseEntity<String> updateDeliveryAgentStatus(DeliveryAgent.Status status){
        return deliveryService.updateDeliveryAgentStatus(status);
    }

}
