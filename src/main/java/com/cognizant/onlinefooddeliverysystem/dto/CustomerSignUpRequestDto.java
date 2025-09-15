package com.cognizant.onlinefooddeliverysystem.dto;

import com.cognizant.onlinefooddeliverysystem.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerSignUpRequestDto {
    private String email;
    private String password;
    private LocalDate dob;
    private String phone;
    private String name;
}
