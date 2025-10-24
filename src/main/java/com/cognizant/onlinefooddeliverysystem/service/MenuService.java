package com.cognizant.onlinefooddeliverysystem.service;

import com.cognizant.onlinefooddeliverysystem.dto.menuitem.CreateMenuItemRequestDto;
import com.cognizant.onlinefooddeliverysystem.dto.menuitem.CreateMenuItemResponseDto;
import com.cognizant.onlinefooddeliverysystem.dto.menuitem.UpdateMenuItemRequestDto;
import com.cognizant.onlinefooddeliverysystem.dto.UpdateEntityResponseDto;
import com.cognizant.onlinefooddeliverysystem.dto.restaurant.RestaurantResponseDTO;
import com.cognizant.onlinefooddeliverysystem.exception.MenuItemNotFoundException;
import com.cognizant.onlinefooddeliverysystem.exception.ResourceNotFoundException;
import com.cognizant.onlinefooddeliverysystem.exception.menu.RestaurantNotFoundException;
import com.cognizant.onlinefooddeliverysystem.model.MenuItems;
import com.cognizant.onlinefooddeliverysystem.model.Restaurant;
import com.cognizant.onlinefooddeliverysystem.model.User;
import com.cognizant.onlinefooddeliverysystem.repository.MenuRepository;
import com.cognizant.onlinefooddeliverysystem.repository.RestaurantRepository;
import com.cognizant.onlinefooddeliverysystem.util.GetVerifiedUser;
import com.cognizant.onlinefooddeliverysystem.util.ReflectionFilterService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.time.LocalTime;
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
    private final GetVerifiedUser getVerifiedUser;

    public List<MenuItems> getAllMenu(){
        return menuRepository.findAll();
    }

    public List<MenuItems> getAllMenuByRestaurantJWT() throws Exception{
        User user = getVerifiedUser.getVerifiedUser();
        Restaurant restaurant = restaurantRepository.findByUser_UserId(user.getUserId());
        if(restaurant == null){
            throw new RestaurantNotFoundException("User is not a restaurant!");
        }
        return menuRepository.findByRestaurant_RestId(restaurant.getRestId());
    }

    public CreateMenuItemResponseDto addMenuItem(CreateMenuItemRequestDto createMenuItemRequestDto){
        User user = getVerifiedUser.getVerifiedUser();
        if(user == null){
            throw new ResourceNotFoundException("Restaurant not found by the user of JWT");
        }
        Restaurant restaurant = restaurantRepository.findByUser_UserId(user.getUserId());
        if(restaurant == null){
            throw new RestaurantNotFoundException( "Restaurant not found with id: " + user.getUserId());
        }
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
        User user = getVerifiedUser.getVerifiedUser();
        if(user == null) {
            throw  new RestaurantNotFoundException("User not found with JWT Token.");
        }
        Restaurant restaurant = restaurantRepository.findByUser_UserId(user.getUserId());
        if(restaurant == null) {
            throw  new RestaurantNotFoundException("User is not a Restaurant. with user id: " + user.getUserId());
        }
        Map<String, Object> nonNullMenuField;
        MenuItems menuItemToUpdate = menuRepository.findById(menuItemId).orElseThrow(
                () -> new MenuItemNotFoundException("Menu item not found with id: " + menuItemId)
        );
        // TODO: change the illegalArgumentException
        if(restaurant.getRestId() != menuItemToUpdate.getRestaurant().getRestId()) {
            throw new IllegalArgumentException("This menu item with id: " + menuItemId + " does not belongs to restaurant with id: " + restaurant.getRestId());
        }
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



    public RestaurantResponseDTO getRestaurantById(Integer restaurantId) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElseThrow(
                () -> new RestaurantNotFoundException( "Restaurant not found with id: " + restaurantId)
        );


        return RestaurantResponseDTO.builder()
                .restaurantId(restaurantId)
                .name(restaurant.getName())
                .address(restaurant.getAddress())
                .ETA(Math.max(20, restaurantId * 92874563 % 60))
                .rating(Math.max(2.3f, restaurantId * 237469234 % 5 ))
                .deliveryFee(Math.max(50f, restaurantId * 92874563 % 200))
                .isOpen(restaurant.getCloseTime().isBefore(LocalTime.now()))
                .logoUrl(restaurant.getImgUrl() == null ? "https://img.freepik.com/free-photo/top-view-fast-food-mix-mozzarella-sticks-club-sandwich-hamburger-mushroom-pizza-caesar-shrimp-salad-french-fries-ketchup-mayo-cheese-sauces-table_141793-3998.jpg" : restaurant.getImgUrl())
                .bannerUrl(restaurant.getImgUrl() == null ? "https://img.freepik.com/free-photo/top-view-fast-food-mix-mozzarella-sticks-club-sandwich-hamburger-mushroom-pizza-caesar-shrimp-salad-french-fries-ketchup-mayo-cheese-sauces-table_141793-3998.jpg" : restaurant.getImgUrl())
                .build();

    }
    public void deleteMenuItemById(Long menuItemId) {
        // First, check if the entity exists. This provides a better error message.
        User user = getVerifiedUser.getVerifiedUser();
        if(user == null) {
            throw  new RestaurantNotFoundException("User not found with JWT Token.");
        }
        Restaurant restaurant = restaurantRepository.findByUser_UserId(user.getUserId());
        if(restaurant == null) {
            throw  new RestaurantNotFoundException("User is not a Restaurant. with user id: " + user.getUserId());
        }
        if (!menuRepository.existsById(menuItemId)) {
            throw new MenuItemNotFoundException("Cannot delete. Menu item not found with id: " + menuItemId);
        }
        MenuItems menuItemToDelete = menuRepository.findById(menuItemId).orElseThrow(
                () -> new MenuItemNotFoundException("Menu item not found with id: " + menuItemId)
        );
        if(restaurant.getRestId() != menuItemToDelete.getRestaurant().getRestId()) {
            throw new IllegalArgumentException("This menu item with id: " + menuItemId + " does not belongs to restaurant with id: " + restaurant.getRestId());
        }

        menuRepository.deleteById(menuItemId);
    }

    public List<MenuItems> getAllMenuByRestaurantID(Integer restaurantId) {
        return menuRepository.findByRestaurant_RestId(restaurantId);
    }
}
