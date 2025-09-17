package com.cognizant.onlinefooddeliverysystem.controller;

import com.cognizant.onlinefooddeliverysystem.dto.customer.CustomerSignUpResponseDto;
import com.cognizant.onlinefooddeliverysystem.dto.login.LoginRequestDto;
import com.cognizant.onlinefooddeliverysystem.dto.login.LoginResponseDto;
import com.cognizant.onlinefooddeliverysystem.dto.customer.CustomerSignUpRequestDto;
import com.cognizant.onlinefooddeliverysystem.dto.restaurant.RestaurantSignupRequestDto;
import com.cognizant.onlinefooddeliverysystem.dto.restaurant.RestaurantSignupResponseDto;
import com.cognizant.onlinefooddeliverysystem.security.LoginService;
import com.cognizant.onlinefooddeliverysystem.security.SignupService;
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
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequestDto){
        System.out.println("In login");
        return ResponseEntity.ok(loginService.login(loginRequestDto));
    }
/// ///////////////////////////////////////////////////////////////////////////////
//////                           Signup endpoints                       ///////////
///////////////////////////////////////////////////////////////////////////////////

    @PostMapping("/customer/sign-up")
    public ResponseEntity<CustomerSignUpResponseDto> customerSignUp(@RequestBody CustomerSignUpRequestDto customerSignUpRequestDto){
        System.out.println("Inside signup");
        return ResponseEntity.ok(signupService.customerSignUp(customerSignUpRequestDto));
    }

    @PostMapping("/restaurant/sign-up")
    public ResponseEntity<RestaurantSignupResponseDto> restaurantSignUp(@RequestBody RestaurantSignupRequestDto restaurantSignupRequestDto){
        return ResponseEntity.ok(signupService.restaurantSignUp(restaurantSignupRequestDto));
    }


}
