package com.cognizant.onlinefooddeliverysystem.controller;

import com.cognizant.onlinefooddeliverysystem.dto.admin.AdminSignUpRequestDto;
import com.cognizant.onlinefooddeliverysystem.dto.admin.AdminSignUpResponseDto;
import com.cognizant.onlinefooddeliverysystem.dto.customer.CustomerSignUpResponseDto;
import com.cognizant.onlinefooddeliverysystem.dto.deliveryagent.DeliveryAgentSignUpRequestDto;
import com.cognizant.onlinefooddeliverysystem.dto.deliveryagent.DeliveryAgentSignUpResponseDto;
import com.cognizant.onlinefooddeliverysystem.dto.login.LoginRequestDto;
import com.cognizant.onlinefooddeliverysystem.dto.login.LoginResponseDto;
import com.cognizant.onlinefooddeliverysystem.dto.customer.CustomerSignUpRequestDto;
import com.cognizant.onlinefooddeliverysystem.dto.restaurant.RestaurantSignupRequestDto;
import com.cognizant.onlinefooddeliverysystem.dto.restaurant.RestaurantSignupResponseDto;
import com.cognizant.onlinefooddeliverysystem.security.LoginService;
import com.cognizant.onlinefooddeliverysystem.security.SignupService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("${api.version.path}/auth")
@RequiredArgsConstructor
@RestController
public class AuthController {

    private final LoginService loginService;
    private final SignupService signupService;

    @PostMapping("login")
    public ResponseEntity<LoginResponseDto> login(@Valid @RequestBody LoginRequestDto loginRequestDto){
        return ResponseEntity.ok(loginService.login(loginRequestDto));
    }
/// ///////////////////////////////////////////////////////////////////////////////
//////                           Signup endpoints                       ///////////
///////////////////////////////////////////////////////////////////////////////////

    @PostMapping("/customer/sign-up")
    public ResponseEntity<CustomerSignUpResponseDto> customerSignUp(@Valid @RequestBody CustomerSignUpRequestDto customerSignUpRequestDto){
        return ResponseEntity.ok(signupService.customerSignUp(customerSignUpRequestDto));
    }

    @PostMapping("/restaurant/sign-up")
    public ResponseEntity<RestaurantSignupResponseDto> restaurantSignUp(@Valid @RequestBody RestaurantSignupRequestDto restaurantSignupRequestDto){
        return ResponseEntity.ok(signupService.restaurantSignUp(restaurantSignupRequestDto));
    }

    @PostMapping("/delivery-agent/sign-up")
    public ResponseEntity<DeliveryAgentSignUpResponseDto> deliveryAgentSignUp(@Valid @RequestBody DeliveryAgentSignUpRequestDto deliveryAgentSignUpRequestDto){
        return ResponseEntity.ok(signupService.deliveryAgentSignUp(deliveryAgentSignUpRequestDto));
    }

    @PostMapping("/admin/sign-up")
    public ResponseEntity<AdminSignUpResponseDto> deliveryAgentSignUp(@Valid @RequestBody AdminSignUpRequestDto requestDto){
        return ResponseEntity.ok(signupService.adminSignUp(requestDto));
    }

}
