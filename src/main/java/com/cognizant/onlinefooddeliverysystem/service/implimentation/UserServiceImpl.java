package com.cognizant.onlinefooddeliverysystem.service.implimentation;

import com.cognizant.onlinefooddeliverysystem.dto.user.GetUserRoleResponseDTO;
import com.cognizant.onlinefooddeliverysystem.exception.ResourceNotFoundException;
import com.cognizant.onlinefooddeliverysystem.model.Restaurant;
import com.cognizant.onlinefooddeliverysystem.model.User;
import com.cognizant.onlinefooddeliverysystem.repository.RestaurantRepository;
import com.cognizant.onlinefooddeliverysystem.repository.UserRepository;
import com.cognizant.onlinefooddeliverysystem.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final RestaurantRepository restaurantRepository;
    @Override
    public GetUserRoleResponseDTO getUserRole(Integer id) {
        User user = repository.findById(id).orElseThrow(() -> {
            throw new ResourceNotFoundException("User not found with ID : " + id);
        });

        return new GetUserRoleResponseDTO(
                user.getRole()
        );
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }
}
