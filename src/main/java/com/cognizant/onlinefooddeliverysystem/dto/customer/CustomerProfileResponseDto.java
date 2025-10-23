package com.cognizant.onlinefooddeliverysystem.dto.customer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerProfileResponseDto {
    private String name;
    private String email;
    private LocalDate dob;
    private String phone;
    private String address;
    private String preferredPayment;
}
