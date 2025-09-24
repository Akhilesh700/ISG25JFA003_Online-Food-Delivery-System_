package com.cognizant.onlinefooddeliverysystem.controller;

import com.cognizant.onlinefooddeliverysystem.model.Customer;
import com.cognizant.onlinefooddeliverysystem.model.DeliveryAgent;
import com.cognizant.onlinefooddeliverysystem.model.Restaurant;
import com.cognizant.onlinefooddeliverysystem.model.User;
import com.cognizant.onlinefooddeliverysystem.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("${api.version.path}/admin")
public class AdminController {

    private final AdminService adminService;

    @GetMapping("all-users")
    public List<User> getAllUsers(){
        return adminService.getAllUsers();
    }

    @GetMapping("all-customers")
    public List<Customer> getAllCustomers(){
        return adminService.getAllCustomers();
    }

    @GetMapping("all-delivery-agents")
    public List<DeliveryAgent> getAllDeliveryAgents(){
        return adminService.getAllDeliveryAgents();
    }

    @GetMapping("all-restaurants")
    public List<Restaurant> getAllRestaurants(){
        return adminService.getAllRestaurants();
    }
}
