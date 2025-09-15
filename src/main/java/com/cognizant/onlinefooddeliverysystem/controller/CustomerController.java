package com.cognizant.onlinefooddeliverysystem.controller;

import com.cognizant.onlinefooddeliverysystem.dto.UserRegistrationDTO;
import com.cognizant.onlinefooddeliverysystem.model.User;
import com.cognizant.onlinefooddeliverysystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody UserRegistrationDTO registrationDTO) {
        User registeredUser = userService.registerUser(registrationDTO);
        return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<User> updateCustomer(@PathVariable Integer userId, @RequestBody UserRegistrationDTO registrationDTO) {
        User updatedUser = userService.updateCustomerProfile(userId, registrationDTO);
        if (updatedUser != null) {
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Integer userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}