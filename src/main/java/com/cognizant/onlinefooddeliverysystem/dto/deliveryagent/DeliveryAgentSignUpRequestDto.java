package com.cognizant.onlinefooddeliverysystem.dto.deliveryagent;

import com.cognizant.onlinefooddeliverysystem.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryAgentSignUpRequestDto {
    private String email;
    private String password;
    private String name;
    private String phone;
    private String identityProofType;
    private String identityProofNo;
}
