package com.cognizant.onlinefooddeliverysystem.controller;

import com.cognizant.onlinefooddeliverysystem.model.MenuItems;
import com.cognizant.onlinefooddeliverysystem.service.MenuService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Data
@RestController
@AllArgsConstructor
public class MenuController {
    private final MenuService service;

    // Method 1: Created Endpoint for getting all the menu items irrespective of restaurant
    @GetMapping("/menu")
    public List<MenuItems> getAllMenu() throws Exception{
        try {
            return service.getAllMenu();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    // Method 2: Created Endpoint for getting all the menu items by restaurant ID
    @PostMapping("/menu/{restID}")
    public ResponseEntity<MenuItems> getMenuItemById(@PathVariable Integer restID, @RequestBody MenuItems menuItems) throws Exception {
        try {
            MenuItems savedMenu = service.addMenuItem(restID, menuItems);
            return new ResponseEntity<>(savedMenu, HttpStatus.CREATED);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // Method 3: Created Endpoint for adding the menu items to a particular restaurant by restaurant ID
    @GetMapping("/menu/{restID}")
    public  List<MenuItems> getAllMenuItemsByRestaurantID(@PathVariable Integer restID) throws Exception {
        try {
            return service.getAllMenuByRestaurantID(restID);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
