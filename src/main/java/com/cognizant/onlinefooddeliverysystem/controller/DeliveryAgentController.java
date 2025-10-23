package com.cognizant.onlinefooddeliverysystem.controller;

import com.cognizant.onlinefooddeliverysystem.dto.deliveryagent.DeliveryAgentProfileDTO;
import com.cognizant.onlinefooddeliverysystem.dto.order.GetOrderHistoryByDeliveryAgentResponse;
import com.cognizant.onlinefooddeliverysystem.model.DeliveryAgent;
import com.cognizant.onlinefooddeliverysystem.service.DeliveryAgentService;
import com.cognizant.onlinefooddeliverysystem.service.DeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("${api.version.path}/delivery-agent")
public class DeliveryAgentController {

    private final DeliveryService deliveryService;
    private final DeliveryAgentService deliveryAgentService;
    @PatchMapping("/change-status")
    public ResponseEntity<String> updateDeliveryAgentStatus(@RequestParam DeliveryAgent.Status newStatus){
        return deliveryService.updateDeliveryAgentStatus(newStatus);
    }

    @GetMapping("/order-history")
    public List<GetOrderHistoryByDeliveryAgentResponse> getOrderHistoryByDeliveryAgent(){
        return deliveryService.getOrderHistoryByDeliveryAgent();
    }

    @GetMapping("/profile")
    public DeliveryAgentProfileDTO getDeliveryAgentProfile(){
        return deliveryAgentService.getDeliveryAgentProfile();
    }

    @GetMapping("/status")
    public ResponseEntity<DeliveryAgent.Status> getDeliveryAgentStatus() {
        return ResponseEntity.ok(deliveryAgentService.getDeliveryAgentStatus());
    }

}
