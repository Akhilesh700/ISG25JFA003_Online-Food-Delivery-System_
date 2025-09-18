package com.cognizant.onlinefooddeliverysystem.controller;

import com.cognizant.onlinefooddeliverysystem.dto.menuitem.CreateMenuItemRequestDto;
import com.cognizant.onlinefooddeliverysystem.dto.menuitem.CreateMenuItemResponseDto;
import com.cognizant.onlinefooddeliverysystem.model.MenuItems;
import com.cognizant.onlinefooddeliverysystem.service.MenuService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("${api.version.path}/menu")
public class
MenuController {
    private final MenuService service;

    // Method 1: Endpoint for getting all the menu items irrespective of restaurant
    @GetMapping("")
    public List<MenuItems> getAllMenu(){
        return service.getAllMenu();
    }


    // Method 2: Endpoint for adding menu to a restaurant by restId
    @PostMapping("/{restID}")
    public ResponseEntity<CreateMenuItemResponseDto> addMenuItemByRestaurantId(@PathVariable Integer restID, @RequestBody CreateMenuItemRequestDto createMenuItemRequestDto) throws Exception {

        return ResponseEntity.ok(service.addMenuItem(restID, createMenuItemRequestDto));
    }

    // Method 3: Endpoint for getting the menu items of a particular restaurant by restaurant ID
    @GetMapping("/{restID}")
    public  List<MenuItems> getAllMenuItemsByRestaurantID(@PathVariable Integer restID) throws Exception {
            return service.getAllMenuByRestaurantID(restID);
    }

}
