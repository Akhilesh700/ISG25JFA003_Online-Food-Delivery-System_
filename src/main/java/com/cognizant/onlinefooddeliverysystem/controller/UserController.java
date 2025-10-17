package com.cognizant.onlinefooddeliverysystem.controller;

import com.cognizant.onlinefooddeliverysystem.dto.user.GetUserRoleResponseDTO;
import com.cognizant.onlinefooddeliverysystem.model.Restaurant;
import com.cognizant.onlinefooddeliverysystem.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("${api.version.path}/user")
public class UserController {

    private final UserService service;
    @GetMapping("{id}")
    public ResponseEntity<GetUserRoleResponseDTO> getUserRole(@PathVariable("id") Integer id){
        return new ResponseEntity<>(service.getUserRole(id), HttpStatus.OK);
    }
    @GetMapping("all-restaurants")
    public List<Restaurant> getAllRestaurants(){
        return service.getAllRestaurants();
    }
}
