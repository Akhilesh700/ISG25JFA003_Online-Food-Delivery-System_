package com.cognizant.onlinefooddeliverysystem.service;

import com.cognizant.onlinefooddeliverysystem.dto.menuitem.CreateMenuItemRequestDto;
import com.cognizant.onlinefooddeliverysystem.dto.menuitem.CreateMenuItemResponseDto;
import com.cognizant.onlinefooddeliverysystem.dto.menuitem.UpdateMenuItemRequestDto;
import com.cognizant.onlinefooddeliverysystem.dto.UpdateEntityResponseDto;
import com.cognizant.onlinefooddeliverysystem.exception.MenuItemNotFoundException;
import com.cognizant.onlinefooddeliverysystem.exception.menu.RestaurantNotFoundException;
import com.cognizant.onlinefooddeliverysystem.model.MenuItems;
import com.cognizant.onlinefooddeliverysystem.model.Restaurant;
import com.cognizant.onlinefooddeliverysystem.repository.MenuRepository;
import com.cognizant.onlinefooddeliverysystem.repository.RestaurantRepository;
import com.cognizant.onlinefooddeliverysystem.util.ReflectionFilterService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
@Transactional
public class MenuService {

    private final MenuRepository menuRepository;
    private final RestaurantRepository restaurantRepository;
    private ModelMapper mapper;
    private ReflectionFilterService reflectionFilterService;

    public List<MenuItems> getAllMenu(){
        return menuRepository.findAll();
    }
//  TODO: Write DTO's for each of the response
    public List<MenuItems> getAllMenuByRestaurantID(int restId) throws Exception{
        List<MenuItems> menuItemsList = menuRepository.findByRestaurant_RestId(restId);
        return menuItemsList;
    }
// TODO: Dynamic URL for menu searching
    public CreateMenuItemResponseDto addMenuItem(int restID, CreateMenuItemRequestDto createMenuItemRequestDto){
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
    @Transactional
    public UpdateEntityResponseDto updateMenuItemByMenuItemId(Long menuItemId, UpdateMenuItemRequestDto requestDto){
        Map<String, Object> nonNullMenuField;
        MenuItems menuItemToUpdate = menuRepository.findById(menuItemId).orElseThrow(
                () -> new MenuItemNotFoundException("Menu item not found with id: " + menuItemId)
        );
        nonNullMenuField = reflectionFilterService.getNonNullFields(requestDto);
        // 2. Configuring ModelMapper to skip null fields ------ This is used for partial updates
        mapper.getConfiguration().setSkipNullEnabled(true);

        // 3. Mapping the non-null properties from the DTO to the entity
        // ModelMapper will only copy values from requestDto that are not null.
        mapper.map(requestDto, menuItemToUpdate);
        return new UpdateEntityResponseDto(
                nonNullMenuField.size(),
                nonNullMenuField
        );
    }

    // TODO: Dynamic URL for Restaurant searching


}
