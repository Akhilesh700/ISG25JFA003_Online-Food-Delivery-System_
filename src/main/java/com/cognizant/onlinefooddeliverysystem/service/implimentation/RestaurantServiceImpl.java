package com.cognizant.onlinefooddeliverysystem.service.implimentation;

import com.cognizant.onlinefooddeliverysystem.dto.UpdateEntityResponseDto;
import com.cognizant.onlinefooddeliverysystem.dto.order.AcceptRejectOrderResponseDto;
import com.cognizant.onlinefooddeliverysystem.dto.restaurant.RestaurantOrderHistoryResponseDTO;
import com.cognizant.onlinefooddeliverysystem.dto.restaurant.RestaurantProfileUpdateRequestDto;
import com.cognizant.onlinefooddeliverysystem.exception.CustomerNotFoundException;
import com.cognizant.onlinefooddeliverysystem.exception.InvalidRequestException;
import com.cognizant.onlinefooddeliverysystem.exception.ResourceNotFoundException;
import com.cognizant.onlinefooddeliverysystem.exception.menu.RestaurantNotFoundException;
import com.cognizant.onlinefooddeliverysystem.model.*;
import com.cognizant.onlinefooddeliverysystem.repository.MenuItemRepository;
import com.cognizant.onlinefooddeliverysystem.repository.OrderRepository;
import com.cognizant.onlinefooddeliverysystem.repository.RestaurantRepository;
import com.cognizant.onlinefooddeliverysystem.repository.StatusRepository;
import com.cognizant.onlinefooddeliverysystem.service.RestaurantService;
import com.cognizant.onlinefooddeliverysystem.util.GetVerifiedUser;
import com.cognizant.onlinefooddeliverysystem.util.ReflectionFilterService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {

    private final GetVerifiedUser getVerifiedUser;
    private final RestaurantRepository restaurantRepository;
    private final OrderRepository orderRepository;
    private final StatusRepository statusRepository;
    private final MenuItemRepository menuItemRepository;
    private final ReflectionFilterService reflectionFilterService;
    private final ModelMapper modelMapper;

    @Override
    public List<RestaurantOrderHistoryResponseDTO> getOrderHistoryByRestaurant() {
        User user = getVerifiedUser.getVerifiedUser();
        if(user == null) {
            throw new ResourceNotFoundException("User Not Found from JWT token") ;
        }
        Restaurant restaurant = restaurantRepository.findByUser_UserId(user.getUserId());
        if(restaurant == null) {
            throw new ResourceNotFoundException("Restaurant Not Found with user id : " + user.getUserId()) ;
        }
        return orderRepository.findByRestaurant_RestId(restaurant.getRestId());
    }

    @Override
    @Transactional
    public AcceptRejectOrderResponseDto acceptOrder(int orderId, String action) {
        Status toBeUpdatedStatus;
        if (!action.equalsIgnoreCase("accept") && !action.equalsIgnoreCase("reject")){
            throw new InvalidRequestException("Invalid action value it can either be `ACCEPT` or `REJECT`");
        }
        else {
            String statusToUpdate = action.equalsIgnoreCase("accept") ? "PREPARING" : "NOT_ACCEPTED";
            User user = getVerifiedUser.getVerifiedUser();
            Restaurant restaurant = restaurantRepository.findByUser_UserId(user.getUserId());

            if (restaurant == null) {
                throw new RestaurantNotFoundException("Restaurant not found with user id : " + user.getUserId());
            }

            Order order = orderRepository.findOrderByOrderId(orderId).orElseThrow(() ->
                    new ResourceNotFoundException("Order not found with order id : " + orderId)
            );
            if (order.getRestaurant() != restaurant) {
                throw new InvalidRequestException("This order is not from your restaurant");
            } else {
                toBeUpdatedStatus = statusRepository.findByStatusType(Status.StatusType.valueOf(statusToUpdate.toUpperCase())).orElseThrow(() ->
                        new ResourceNotFoundException(statusToUpdate.toUpperCase() + " status not found in Status Table")
                );
                if(!order.getStatus().getStatusType().toString().equalsIgnoreCase("PLACED")){
                    throw new InvalidRequestException("This order is already in `" + order.getStatus().getStatusType() + "` state");
                }
                else {
                    order.setStatus(toBeUpdatedStatus);
                }
            }
        }

        return new AcceptRejectOrderResponseDto(
                toBeUpdatedStatus.getStatusType(),
                "Order has been successfully " + action + "ed"
        );
    }

    @Override
    public List<MenuItems> getMenuItems() {
        User user = getVerifiedUser.getVerifiedUser();
        Restaurant restaurant = restaurantRepository.findByUser_UserId(user.getUserId());
        if(restaurant == null){
            throw new ResourceNotFoundException("This user is not a restaurant with user id : " + user.getUserId());
        }

        return menuItemRepository.findByRestaurant_RestId(restaurant.getRestId());
    }

    @Override
    @Transactional
    public UpdateEntityResponseDto updateRestaurantProfile(RestaurantProfileUpdateRequestDto requestDto) {
        User user = getVerifiedUser.getVerifiedUser();
        Restaurant restaurantToUpdate = restaurantRepository.findByUser_UserId(user.getUserId());
        if(restaurantToUpdate == null){
            throw new RestaurantNotFoundException("Restaurant not found with user id : " + user.getUserId());
        }
        Map<String, Object> nonNullCustomerField = reflectionFilterService.getNonNullFields(requestDto);

        modelMapper.getConfiguration().setSkipNullEnabled(true);

        modelMapper.map(requestDto, restaurantToUpdate);
        user.setUpdatedAt(LocalDateTime.now());
        return new UpdateEntityResponseDto(
                nonNullCustomerField.size(),
                nonNullCustomerField
        );
    }
}
