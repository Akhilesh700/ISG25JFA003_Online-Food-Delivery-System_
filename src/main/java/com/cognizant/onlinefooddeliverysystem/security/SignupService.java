package com.cognizant.onlinefooddeliverysystem.security;

import com.cognizant.onlinefooddeliverysystem.dto.customer.CustomerSignUpRequestDto;
import com.cognizant.onlinefooddeliverysystem.dto.customer.CustomerSignUpResponseDto;
import com.cognizant.onlinefooddeliverysystem.dto.restaurant.RestaurantSignupRequestDto;
import com.cognizant.onlinefooddeliverysystem.dto.restaurant.RestaurantSignupResponseDto;
import com.cognizant.onlinefooddeliverysystem.exception.signup.UserAlreadyExistsException;
import com.cognizant.onlinefooddeliverysystem.model.Customer;
import com.cognizant.onlinefooddeliverysystem.model.Restaurant;
import com.cognizant.onlinefooddeliverysystem.model.User;
import com.cognizant.onlinefooddeliverysystem.repository.CustomerRepository;
import com.cognizant.onlinefooddeliverysystem.repository.RestaurantRepository;
import com.cognizant.onlinefooddeliverysystem.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SignupService {

    private final UserRepository userRepository;
    private final CustomerRepository customerRepository;
    private final RestaurantRepository restaurantRepository;

    public CustomerSignUpResponseDto customerSignUp(CustomerSignUpRequestDto customerSignUpRequestDto) {
        User user = userRepository.findUserByEmail(customerSignUpRequestDto.getEmail()).orElse(null);
        if(user != null) throw new UserAlreadyExistsException("User already exists with user ID : "+ user.getUserId());
        user = userRepository.save(User.builder()
                .email(customerSignUpRequestDto.getEmail())
                .password(customerSignUpRequestDto.getPassword())
                .role(User.UserRole.valueOf("ROLE_CUSTOMER"))
                .build()
        );
        Customer customer = customerRepository.save(Customer.builder()
                .dob(customerSignUpRequestDto.getDob())
                .name(customerSignUpRequestDto.getName())
                .phone(customerSignUpRequestDto.getPhone())
                .user(user)
                .build()
        );

        return new CustomerSignUpResponseDto(
                user.getEmail(),
                user.getRole(),
                customer.getDob(),
                user.getUserId(),
                customer.getPhone(),
                customer.getName()
        );
    }

    public RestaurantSignupResponseDto restaurantSignUp(RestaurantSignupRequestDto restaurantSignupRequestDto) {
        User user = userRepository.findUserByEmail(restaurantSignupRequestDto.getEmail()).orElse(null);
        if(user != null) throw new UserAlreadyExistsException("User already exists with user ID : "+ user.getUserId());
        user = userRepository.save(User.builder()
                .email(restaurantSignupRequestDto.getEmail())
                .password(restaurantSignupRequestDto.getPassword())
                .role(User.UserRole.valueOf("ROLE_RESTAURANT"))
                .build()
        );
        Restaurant restaurant = restaurantRepository.save(Restaurant.builder()
                .name(restaurantSignupRequestDto.getName())
                .openTime(restaurantSignupRequestDto.getOpenTime())
                .closeTime(restaurantSignupRequestDto.getCloseTime())
                .phone(restaurantSignupRequestDto.getPhone())
                .address(restaurantSignupRequestDto.getAddress())
                .user(user)
                .build()
        );

        return new RestaurantSignupResponseDto(
                user.getEmail(),
                user.getRole(),
                user.getUserId(),
                restaurant.getRestId()
        );
    }
}
