package com.cognizant.onlinefooddeliverysystem.service.serviceImpl;

import com.cognizant.onlinefooddeliverysystem.model.Customer;
import com.cognizant.onlinefooddeliverysystem.model.DeliveryAgent;
import com.cognizant.onlinefooddeliverysystem.model.Restaurant;
import com.cognizant.onlinefooddeliverysystem.model.User;
import com.cognizant.onlinefooddeliverysystem.repository.CustomerRepository;
import com.cognizant.onlinefooddeliverysystem.repository.DeliveryAgentDao;
import com.cognizant.onlinefooddeliverysystem.repository.RestaurantRepository;
import com.cognizant.onlinefooddeliverysystem.repository.UserRepository;
import com.cognizant.onlinefooddeliverysystem.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final UserRepository userRepository;
    private final CustomerRepository customerRepository;
    private final RestaurantRepository restaurantRepository;
    private final DeliveryAgentDao deliveryAgentDao;

    @Override
    public List<User> getAllUsers() {
        
        return List.of();
    }

    @Override
    public List<Customer> getAllCustomers() {
        return List.of();
    }

    @Override
    public List<DeliveryAgent> getAllDeliveryAgents() {
        return List.of();
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        return List.of();
    }
}
