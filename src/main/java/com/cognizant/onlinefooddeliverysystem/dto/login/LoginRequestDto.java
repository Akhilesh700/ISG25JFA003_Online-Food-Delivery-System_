package com.cognizant.onlinefooddeliverysystem.dto.login;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class LoginRequestDto {
    @NotBlank(message = "Username (email) cannot be blank")
    @Email(message = "Username must be a valid email address")
    private String username;
    private Boolean rememberMe;
    private String deviceName;
    private String browserName;
    private String browserVersion;
    private String timezone;
    private String deviceType;

    @NotBlank(message = "Password cannot be blank")
    @Size(min = 5, message = "Password must be at least 5 characters long")
    private String password;
}
