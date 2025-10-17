package com.cognizant.onlinefooddeliverysystem.service;

import com.cognizant.onlinefooddeliverysystem.dto.user.GetUserRoleResponseDTO;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    GetUserRoleResponseDTO getUserRole(Integer id);
}
