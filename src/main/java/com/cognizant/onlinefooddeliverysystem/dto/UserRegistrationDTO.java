package com.cognizant.onlinefooddeliverysystem.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserRegistrationDTO {

    private String email;
    private String password;
    private String name;
    private String phone;
    private String address;
    private String preferredPayment;
    private String role; // Role for the user (e.g., "Customer", "Restaurant")

}