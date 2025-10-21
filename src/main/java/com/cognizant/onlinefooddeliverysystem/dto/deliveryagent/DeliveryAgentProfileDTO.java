package com.cognizant.onlinefooddeliverysystem.dto.deliveryagent;

import com.cognizant.onlinefooddeliverysystem.model.DeliveryAgent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryAgentProfileDTO {
    private Integer agentId;
    private String email;
    private String phone;
    private DeliveryAgent.Status status;
    private String identityProofType;
    private String identityProofNo;
}
