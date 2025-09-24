package com.cognizant.onlinefooddeliverysystem.dto.menuitem;

import com.cognizant.onlinefooddeliverysystem.model.MenuItems;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
public class UpdateMenuItemRequestDto {
    private String name = null;
    private String imgUrl  = null;
    private String cuisineType = null;
    private Boolean isAvailable = null;
    private Boolean isVegetarian = null;
    private MenuItems.MenuItemSize size = null;
    private String description = null;
    private BigDecimal price = null;
    private Integer prepTime = null;
}
