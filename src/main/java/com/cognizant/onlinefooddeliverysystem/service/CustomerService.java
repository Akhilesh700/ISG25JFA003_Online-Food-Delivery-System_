package com.cognizant.onlinefooddeliverysystem.service;

import com.cognizant.onlinefooddeliverysystem.dto.UpdateEntityResponseDto;
import com.cognizant.onlinefooddeliverysystem.dto.customer.UpdateProfileCustomerRequestDto;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {
    UpdateEntityResponseDto updateCustomerProfile(UpdateProfileCustomerRequestDto requestDto);
}
