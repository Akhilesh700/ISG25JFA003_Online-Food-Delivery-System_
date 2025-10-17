package com.cognizant.onlinefooddeliverysystem.dto.user;

import com.cognizant.onlinefooddeliverysystem.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetUserRoleResponseDTO {
    User.UserRole role;
}
