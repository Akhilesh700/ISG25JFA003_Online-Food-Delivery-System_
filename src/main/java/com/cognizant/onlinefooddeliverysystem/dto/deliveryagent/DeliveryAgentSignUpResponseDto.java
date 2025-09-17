package com.cognizant.onlinefooddeliverysystem.dto.deliveryagent;

import com.cognizant.onlinefooddeliverysystem.model.DeliveryAgent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryAgentSignUpResponseDto {
    private int agentId;
    private DeliveryAgent.Status status;
}
