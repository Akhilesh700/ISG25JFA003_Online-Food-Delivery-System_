package com.cognizant.onlinefooddeliverysystem.controller;

import com.cognizant.onlinefooddeliverysystem.dto.UpdateEntityResponseDto;
import com.cognizant.onlinefooddeliverysystem.dto.customer.UpdateProfileCustomerRequestDto;
import com.cognizant.onlinefooddeliverysystem.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("${api.version.path}/customer")
public class CustomerController {
    private final CustomerService customerService;

    @PutMapping("update-profile")
    public ResponseEntity<UpdateEntityResponseDto> updateCustomerProfile(@RequestBody UpdateProfileCustomerRequestDto requestDto){
        return new ResponseEntity<>(customerService.updateCustomerProfile(requestDto), HttpStatus.ACCEPTED);
    }
}
