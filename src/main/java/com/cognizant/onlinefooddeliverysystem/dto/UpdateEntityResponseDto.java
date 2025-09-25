package com.cognizant.onlinefooddeliverysystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class UpdateEntityResponseDto {
    private int noOfAttributesUpdated;
    private Map<String, Object> updatedAttributes;
}
