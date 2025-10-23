package com.cognizant.onlinefooddeliverysystem.service;

import com.cognizant.onlinefooddeliverysystem.dto.deliveryagent.DeliveryAgentProfileDTO;
import com.cognizant.onlinefooddeliverysystem.model.DeliveryAgent;
import org.springframework.stereotype.Service;

@Service
public interface DeliveryAgentService {
    DeliveryAgentProfileDTO getDeliveryAgentProfile();
    DeliveryAgent.Status getDeliveryAgentStatus();
}
