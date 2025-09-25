package com.cognizant.onlinefooddeliverysystem.dto.customer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class UpdateProfileCustomerRequestDto {
    private LocalDate dob = null;
    private String phone = null;
    private String name = null;
    private String address = null;
    private String preferredPayment = null;
}
