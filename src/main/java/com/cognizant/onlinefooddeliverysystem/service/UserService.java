package com.cognizant.onlinefooddeliverysystem.service;

import com.cognizant.onlinefooddeliverysystem.dto.UserRegistrationDTO;
import com.cognizant.onlinefooddeliverysystem.model.Customer;
import com.cognizant.onlinefooddeliverysystem.model.User;
import com.cognizant.onlinefooddeliverysystem.repository.CustomerRepository;
import com.cognizant.onlinefooddeliverysystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Transactional
    public User registerUser(UserRegistrationDTO registrationDTO) {
        // ... (existing registration code) ...
        User user = new User();
        user.setEmail(registrationDTO.getEmail());
        user.setPassword(passwordEncoder.encode(registrationDTO.getPassword()));
        user.setRole(User.UserRole.valueOf(registrationDTO.getRole()));

        User savedUser = userRepository.save(user);

        Customer customer = new Customer();
        customer.setName(registrationDTO.getName());
        customer.setPhone(registrationDTO.getPhone());
        customer.setAddress(registrationDTO.getAddress());
        customer.setPreferredPayment(registrationDTO.getPreferredPayment());
        customer.setUser(savedUser);

        customerRepository.save(customer);
        return savedUser;
    }

    @Transactional
    public User updateCustomerProfile(Integer userId, UserRegistrationDTO registrationDTO) {
        // Find the user and customer by ID
        Optional<User> userOptional = userRepository.findById(userId);
        // Corrected method name to findByUser_UserId
        Optional<Customer> customerOptional = customerRepository.findByUser_UserId(userId);

        if (userOptional.isPresent() && customerOptional.isPresent()) {
            User user = userOptional.get();
            Customer customer = customerOptional.get();

            // Update user details
            if (registrationDTO.getEmail() != null) {
                user.setEmail(registrationDTO.getEmail());
            }

            // Update customer details
            if (registrationDTO.getName() != null) {
                customer.setName(registrationDTO.getName());
            }
            if (registrationDTO.getPhone() != null) {
                customer.setPhone(registrationDTO.getPhone());
            }
            if (registrationDTO.getAddress() != null) {
                customer.setAddress(registrationDTO.getAddress());
            }
            if (registrationDTO.getPreferredPayment() != null) {
                customer.setPreferredPayment(registrationDTO.getPreferredPayment());
            }

            // Save the updated entities
            userRepository.save(user);
            customerRepository.save(customer);

            return user;
        }
        return null; // Handle not found case
    }

    @Transactional
    public void deleteUser(Integer userId) {
        userRepository.deleteById(userId);
    }
}