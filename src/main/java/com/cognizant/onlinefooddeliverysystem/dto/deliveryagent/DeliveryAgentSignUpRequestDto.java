package com.cognizant.onlinefooddeliverysystem.deliveryagent;

import com.cognizant.onlinefooddeliverysystem.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryAgentSignUpDto {
    private String email;
    private String password;
    private String name;
    private String phone;
    private String identityProofType;
    private String identityProofNo;
    private User user;
}
