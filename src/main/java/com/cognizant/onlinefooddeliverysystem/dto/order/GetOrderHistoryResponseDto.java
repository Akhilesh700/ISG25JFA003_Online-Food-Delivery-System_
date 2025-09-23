package com.cognizant.onlinefooddeliverysystem.dto.order;

import com.cognizant.onlinefooddeliverysystem.model.MenuItems;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GetOrderHistoryResponseDto {
    private int orderId;
    private String restaurant;
    private String address;
    private float totalPrice;
    private List<MenuItems> menuItems;
    private String status;
    private String specialRequest;
}
