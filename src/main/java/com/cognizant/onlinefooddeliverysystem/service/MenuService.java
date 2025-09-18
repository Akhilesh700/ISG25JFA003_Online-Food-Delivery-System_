package com.cognizant.onlinefooddeliverysystem.service;

import com.cognizant.onlinefooddeliverysystem.dto.menuitem.CreateMenuItemRequestDto;
import com.cognizant.onlinefooddeliverysystem.dto.menuitem.CreateMenuItemResponseDto;
import com.cognizant.onlinefooddeliverysystem.exception.menu.RestaurantNotFoundException;
import com.cognizant.onlinefooddeliverysystem.model.MenuItems;
import com.cognizant.onlinefooddeliverysystem.model.Restaurant;
import com.cognizant.onlinefooddeliverysystem.repository.MenuRepository;
import com.cognizant.onlinefooddeliverysystem.repository.RestaurantRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class MenuService {

    private final MenuRepository menuRepository;
    private final RestaurantRepository restaurantRepository;
    private ModelMapper mapper;

    public List<MenuItems> getAllMenu(){
        return menuRepository.findAll();
    }

    public List<MenuItems> getAllMenuByRestaurantID(int restId) throws Exception{
        List<MenuItems> menuItemsList = null;
        try{
            menuItemsList = menuRepository.findByRestaurant_RestId(restId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return menuItemsList;
    }

    public CreateMenuItemResponseDto addMenuItem(int restID, CreateMenuItemRequestDto createMenuItemRequestDto) throws Exception {
            Restaurant restaurant = restaurantRepository.findById(restID).orElseThrow(
                    () -> new RestaurantNotFoundException( "Restaurant not found with id: " + restID)
            );
        MenuItems menuItem = mapper.map(createMenuItemRequestDto, MenuItems.class);

        // Setting the relationship with the restaurant.
        menuItem.setRestaurant(restaurant);

        // Saving menuItem to the database.
        MenuItems savedItem = menuRepository.save(menuItem);
        return new CreateMenuItemResponseDto(
                restaurant.getRestId(),
                savedItem.getItemId(),
                restaurant.getName()
        );
    }


}
