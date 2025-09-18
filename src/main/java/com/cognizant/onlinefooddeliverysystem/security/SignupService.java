package com.cognizant.onlinefooddeliverysystem.security;

import com.cognizant.onlinefooddeliverysystem.dto.customer.CustomerSignUpRequestDto;
import com.cognizant.onlinefooddeliverysystem.dto.customer.CustomerSignUpResponseDto;
import com.cognizant.onlinefooddeliverysystem.dto.deliveryagent.DeliveryAgentSignUpRequestDto;
import com.cognizant.onlinefooddeliverysystem.dto.deliveryagent.DeliveryAgentSignUpResponseDto;
import com.cognizant.onlinefooddeliverysystem.dto.restaurant.RestaurantSignupRequestDto;
import com.cognizant.onlinefooddeliverysystem.dto.restaurant.RestaurantSignupResponseDto;
import com.cognizant.onlinefooddeliverysystem.exception.signup.UserAlreadyExistsException;
import com.cognizant.onlinefooddeliverysystem.model.Customer;
import com.cognizant.onlinefooddeliverysystem.model.DeliveryAgent;
import com.cognizant.onlinefooddeliverysystem.model.Restaurant;
import com.cognizant.onlinefooddeliverysystem.model.User;
import com.cognizant.onlinefooddeliverysystem.repository.CustomerRepository;
import com.cognizant.onlinefooddeliverysystem.repository.DeliveryAgentDao;
import com.cognizant.onlinefooddeliverysystem.repository.RestaurantRepository;
import com.cognizant.onlinefooddeliverysystem.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Transactional
public class SignupService {

    private final UserRepository userRepository;
    private final CustomerRepository customerRepository;
    private final RestaurantRepository restaurantRepository;
    private final DeliveryAgentDao deliveryAgentDao;
    private final PasswordEncoder passwordEncoder;
    public User createUser(String email, String password, User.UserRole role){
        User user = userRepository.findUserByEmail(email).orElse(null);
        if(user != null) throw new UserAlreadyExistsException("User already exists with user ID : "+ user.getUserId());
        user = userRepository.save(User.builder()
                .email(email)
                .password(passwordEncoder.encode(password))
                .role(role)
                .build()
        );
        return user;
    }

    public CustomerSignUpResponseDto customerSignUp(CustomerSignUpRequestDto customerSignUpRequestDto) {
        User user = createUser(
                customerSignUpRequestDto.getEmail(),
                customerSignUpRequestDto.getPassword(),
                User.UserRole.valueOf("ROLE_CUSTOMER")
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
        User user = createUser(
                restaurantSignupRequestDto.getEmail(),
                restaurantSignupRequestDto.getPassword(),
                User.UserRole.valueOf("ROLE_RESTAURANT")
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

    public DeliveryAgentSignUpResponseDto deliveryAgentSignUp(DeliveryAgentSignUpRequestDto deliveryAgentSignUpRequestDto) {
        User user = createUser(
                deliveryAgentSignUpRequestDto.getEmail(),
                deliveryAgentSignUpRequestDto.getPassword(),
                User.UserRole.valueOf("ROLE_DELIVERY_AGENT")
        );

        DeliveryAgent agent = deliveryAgentDao.save(DeliveryAgent.builder()
                        .name(deliveryAgentSignUpRequestDto.getName())
                        .identityProofNo(deliveryAgentSignUpRequestDto.getIdentityProofNo())
                        .identityProofType(deliveryAgentSignUpRequestDto.getIdentityProofType())
                        .phone(deliveryAgentSignUpRequestDto.getPhone())
                        .status(DeliveryAgent.Status.Offline)
                        .user(user)
                .build()
        );
        return new DeliveryAgentSignUpResponseDto(
                agent.getAgentId(),
                agent.getStatus()
        );

    }
}
