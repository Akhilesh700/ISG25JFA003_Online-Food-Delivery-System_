package com.cognizant.onlinefooddeliverysystem.controller;

import com.cognizant.onlinefooddeliverysystem.dto.menuitem.CreateMenuItemRequestDto;
import com.cognizant.onlinefooddeliverysystem.dto.menuitem.CreateMenuItemResponseDto;
import com.cognizant.onlinefooddeliverysystem.dto.menuitem.UpdateMenuItemRequestDto;
import com.cognizant.onlinefooddeliverysystem.dto.UpdateEntityResponseDto;
import com.cognizant.onlinefooddeliverysystem.dto.restaurant.RestaurantResponseDTO;
import com.cognizant.onlinefooddeliverysystem.model.MenuItems;
import com.cognizant.onlinefooddeliverysystem.service.MenuService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
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
    @PostMapping("/")
    public ResponseEntity<CreateMenuItemResponseDto> addMenuItemByRestaurantId( @RequestBody CreateMenuItemRequestDto createMenuItemRequestDto){

        return ResponseEntity.ok(service.addMenuItem(createMenuItemRequestDto));
    }

    // Method 3: Endpoint for getting the menu items of a particular restaurant by restaurant from JWT Token
    @GetMapping("/")
    public  List<MenuItems> getAllMenuItemsByRestaurantJWT() throws Exception {
            return service.getAllMenuByRestaurantJWT();
    }

    // Method 3: Endpoint for getting the menu items of a particular restaurant by restaurant ID
    @GetMapping("/{restaurantId}")
    public  List<MenuItems> getAllMenuItemsByRestaurantID(@PathVariable Integer restaurantId) throws Exception {
        return service.getAllMenuByRestaurantID(restaurantId);
    }

    @PutMapping("/update-menu/{menuItemId}")
    public ResponseEntity<UpdateEntityResponseDto> updateMenuItemByMenuItemId(@PathVariable Long menuItemId, @RequestBody UpdateMenuItemRequestDto requestDto){
        return ResponseEntity.ok(service.updateMenuItemByMenuItemId(menuItemId, requestDto));
    }

    @GetMapping("/restaurant/{id}")
    public ResponseEntity<RestaurantResponseDTO> getRestaurantById(@PathVariable Integer id){
        return  ResponseEntity.ok(service.getRestaurantById(id));
    }
    @DeleteMapping("/delete/{menuItemId}")
    public ResponseEntity<String> deleteMenuItem(@PathVariable Long menuItemId) {
        service.deleteMenuItemById(menuItemId);
        return ResponseEntity.ok("Menu item with ID " + menuItemId + " was deleted successfully.");
    }
}
