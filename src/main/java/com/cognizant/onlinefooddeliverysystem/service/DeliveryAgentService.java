package com.cognizant.onlinefooddeliverysystem.service;

import com.cognizant.onlinefooddeliverysystem.dto.deliveryagent.DeliveryAgentProfileDTO;
import org.springframework.stereotype.Service;

@Service
public interface DeliveryAgentService {
    DeliveryAgentProfileDTO getDeliveryAgentProfile();
}
