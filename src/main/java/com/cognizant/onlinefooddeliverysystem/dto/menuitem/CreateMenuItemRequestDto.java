package com.cognizant.onlinefooddeliverysystem.dto.menuitem;

import com.cognizant.onlinefooddeliverysystem.model.MenuItems;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreateMenuItemRequestDto {
    private String name;
    private String imgUrl;
    private String cuisineType;
    private Boolean isAvailable;
    private Boolean isVegetarian;
    private MenuItems.MenuItemSize size;
    private String description;
    private BigDecimal price;
    private Integer prepTime;
}
