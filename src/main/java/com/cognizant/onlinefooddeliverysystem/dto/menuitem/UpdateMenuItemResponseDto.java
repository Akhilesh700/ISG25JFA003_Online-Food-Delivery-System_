package com.cognizant.onlinefooddeliverysystem.dto.menuitem;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class UpdateMenuItemResponseDto {
    private int noOfAttributesUpdated;
    private Map<String, Object> updatedAttributes;
}
