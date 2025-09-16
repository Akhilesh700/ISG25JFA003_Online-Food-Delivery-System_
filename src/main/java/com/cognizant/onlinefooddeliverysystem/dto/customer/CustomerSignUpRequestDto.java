package com.cognizant.onlinefooddeliverysystem.dto.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerSignUpRequestDto {
    private String email;
    private String password;
    private LocalDate dob;
    private String phone;
    private String name;
}
