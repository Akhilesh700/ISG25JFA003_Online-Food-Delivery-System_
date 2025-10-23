package com.cognizant.onlinefooddeliverysystem.service.implimentation;

import com.cognizant.onlinefooddeliverysystem.dto.UpdateEntityResponseDto;
import com.cognizant.onlinefooddeliverysystem.dto.customer.CustomerProfileResponseDto;
import com.cognizant.onlinefooddeliverysystem.dto.customer.UpdateProfileCustomerRequestDto;
import com.cognizant.onlinefooddeliverysystem.exception.CustomerNotFoundException;
import com.cognizant.onlinefooddeliverysystem.exception.ResourceNotFoundException;
import com.cognizant.onlinefooddeliverysystem.model.Customer;
import com.cognizant.onlinefooddeliverysystem.model.User;
import com.cognizant.onlinefooddeliverysystem.repository.CustomerRepository;
import com.cognizant.onlinefooddeliverysystem.service.CustomerService;
import com.cognizant.onlinefooddeliverysystem.util.GetVerifiedUser;
import com.cognizant.onlinefooddeliverysystem.util.ReflectionFilterService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final ReflectionFilterService reflectionFilterService;
    private final CustomerRepository customerRepository;
    private final GetVerifiedUser getVerifiedUser;
    private final ModelMapper modelMapper;

    @Override
    @Transactional
    public UpdateEntityResponseDto updateCustomerProfile(UpdateProfileCustomerRequestDto requestDto) {
        User user = getVerifiedUser.getVerifiedUser();
        Customer customerToUpdate = customerRepository.findByUser_UserId(user.getUserId());
        if(customerToUpdate == null){
            throw new CustomerNotFoundException("Customer not found with user id : " + user.getUserId());
        }
        Map<String, Object> nonNullCustomerField = reflectionFilterService.getNonNullFields(requestDto);

        modelMapper.getConfiguration().setSkipNullEnabled(true);

        modelMapper.map(requestDto, customerToUpdate);
        user.setUpdatedAt(LocalDateTime.now());
        return new UpdateEntityResponseDto(
                nonNullCustomerField.size(),
                nonNullCustomerField
        );
    }

    @Override
    public CustomerProfileResponseDto getProfile() {
        User user = getVerifiedUser.getVerifiedUser();
        Customer customer = customerRepository.findByUser_UserId(user.getUserId());
        if(customer == null){
            throw new ResourceNotFoundException("User is not a customer");
        }
        return new CustomerProfileResponseDto(
                customer.getName(),
                user.getEmail(),
                customer.getDob(),
                customer.getPhone(),
                customer.getAddress(),
                customer.getPreferredPayment()
        );
    }
}
