package com.cognizant.onlinefooddeliverysystem.service;

import com.cognizant.onlinefooddeliverysystem.model.Customer;
import com.cognizant.onlinefooddeliverysystem.model.DeliveryAgent;
import com.cognizant.onlinefooddeliverysystem.model.Restaurant;
import com.cognizant.onlinefooddeliverysystem.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminService {

    List<User> getAllUsers();

    List<Customer> getAllCustomers();

    List<DeliveryAgent> getAllDeliveryAgents();

    List<Restaurant> getAllRestaurants();
}
