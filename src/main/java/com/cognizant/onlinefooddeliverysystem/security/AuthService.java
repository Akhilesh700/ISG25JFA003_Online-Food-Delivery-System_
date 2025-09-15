package com.cognizant.onlinefooddeliverysystem.security;

import com.cognizant.onlinefooddeliverysystem.dto.LoginRequestDto;
import com.cognizant.onlinefooddeliverysystem.dto.LoginResponseDto;
import com.cognizant.onlinefooddeliverysystem.dto.CustomerSignUpRequestDto;
import com.cognizant.onlinefooddeliverysystem.dto.CustomerSignUpResponseDto;
import com.cognizant.onlinefooddeliverysystem.model.Customer;
import com.cognizant.onlinefooddeliverysystem.model.User;
import com.cognizant.onlinefooddeliverysystem.repository.CustomerRepository;
import com.cognizant.onlinefooddeliverysystem.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final AuthUtil authUtil;
    private final CustomerRepository customerRepository;
    private final AuthenticationManager authenticationManager;

    public LoginResponseDto login(LoginRequestDto loginRequestDto) {
//        Authentication of User from DAO
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequestDto.getUsername(), loginRequestDto.getPassword())
        );
        User user = (User) authentication.getPrincipal();

//      Generating the auth token with user object
        String authToken = authUtil.generateJwtToken(user);


//      Returning the loginResonseDto object with authToken and userId
        return new LoginResponseDto(authToken, user.getUserId());
    }

    public CustomerSignUpResponseDto signUp(CustomerSignUpRequestDto customerSignUpRequestDto) {
        User user = userRepository.findUserByEmail(customerSignUpRequestDto.getEmail()).orElse(null);
        if(user != null) throw new IllegalArgumentException("User already exists with user ID : "+ user.getUserId());
        String role = "Customer";
        user = userRepository.save(User.builder()
                .email(customerSignUpRequestDto.getEmail())
                .password(customerSignUpRequestDto.getPassword())
                .role(User.UserRole.valueOf("Customer"))
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
}
