package com.cognizant.onlinefooddeliverysystem.service;

import com.cognizant.onlinefooddeliverysystem.dto.user.GetUserRoleResponseDTO;
import com.cognizant.onlinefooddeliverysystem.model.Restaurant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    GetUserRoleResponseDTO getUserRole(Integer id);

    List<Restaurant> getAllRestaurants();
}
