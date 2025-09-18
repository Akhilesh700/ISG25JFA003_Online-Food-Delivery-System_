package com.cognizant.onlinefooddeliverysystem.dto.menuitem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateMenuItemResponseDto {
    private int restId;
    private int itemId;
    private String name;
}
