package com.cognizant.onlinefooddeliverysystem.dto.customer;

import com.cognizant.onlinefooddeliverysystem.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerSignUpResponseDto {
    private String email;
    private User.UserRole role;
    private LocalDate dob;
    private int userId;
    private String phone;
    private String name;
    private Long createdCartId;
}
