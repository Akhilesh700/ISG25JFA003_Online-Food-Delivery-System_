package com.cognizant.onlinefooddeliverysystem.dto.restaurant;


import com.cognizant.onlinefooddeliverysystem.model.MenuItems;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class RestaurantResponseDTO {

    private Integer restaurantId;
    private String name;
    private String address;
    private String bannerUrl;
    private String logoUrl;
    private Float rating;
    private Integer ETA = 30;
    private Boolean isOpen;
    private Float deliveryFee;

}
