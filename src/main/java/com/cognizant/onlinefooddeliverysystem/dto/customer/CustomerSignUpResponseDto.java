package com.cognizant.onlinefooddeliverysystem.dto.customer;

import com.cognizant.onlinefooddeliverysystem.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerSignUpResponseDto {
    private String email;
    private User.UserRole role;
    private Integer userId;
    private long createdCardId;
}
