package com.cognizant.onlinefooddeliverysystem.controller;

import com.cognizant.onlinefooddeliverysystem.dto.menuitem.CreateMenuItemRequestDto;
import com.cognizant.onlinefooddeliverysystem.dto.menuitem.CreateMenuItemResponseDto;
import com.cognizant.onlinefooddeliverysystem.dto.menuitem.UpdateMenuItemRequestDto;
import com.cognizant.onlinefooddeliverysystem.dto.UpdateEntityResponseDto;
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
    @PostMapping("/{restID}")
    public ResponseEntity<CreateMenuItemResponseDto> addMenuItemByRestaurantId(@PathVariable Integer restID, @RequestBody CreateMenuItemRequestDto createMenuItemRequestDto) throws Exception {

        return ResponseEntity.ok(service.addMenuItem(restID, createMenuItemRequestDto));
    }

    // Method 3: Endpoint for getting the menu items of a particular restaurant by restaurant ID
    @GetMapping("/{restID}")
    public  List<MenuItems> getAllMenuItemsByRestaurantID(@PathVariable Integer restID) throws Exception {
            return service.getAllMenuByRestaurantID(restID);
    }

//    TODO: To Implement menu update api
    @PostMapping("/update-menu/{menuItemId}")
    public ResponseEntity<UpdateEntityResponseDto> updateMenuItemByMenuItemId(@PathVariable Long menuItemId, @RequestBody UpdateMenuItemRequestDto requestDto){
        return ResponseEntity.ok(service.updateMenuItemByMenuItemId(menuItemId, requestDto));
    }

//    TODO: To implement like query for dynamic searching of menu and along with typing of user

}
