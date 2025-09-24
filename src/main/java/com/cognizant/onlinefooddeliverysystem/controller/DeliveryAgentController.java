package com.cognizant.onlinefooddeliverysystem.controller;

import com.cognizant.onlinefooddeliverysystem.model.DeliveryAgent;
import com.cognizant.onlinefooddeliverysystem.service.DeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("${api.version.path}/delivery-agent")
public class DeliveryAgentController {

    private final DeliveryService deliveryService;

    @PatchMapping("/change-status")
    public ResponseEntity<String> updateDeliveryAgentStatus(@RequestParam DeliveryAgent.Status newStatus){
        return deliveryService.updateDeliveryAgentStatus(newStatus);
    }

}
