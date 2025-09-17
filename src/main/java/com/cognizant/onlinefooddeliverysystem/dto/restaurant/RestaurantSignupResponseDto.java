package com.cognizant.onlinefooddeliverysystem.dto.restaurant;

import com.cognizant.onlinefooddeliverysystem.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantSignupResponseDto {
    private String email;
    private User.UserRole role;
    private int userId;
    private int restId;
}
