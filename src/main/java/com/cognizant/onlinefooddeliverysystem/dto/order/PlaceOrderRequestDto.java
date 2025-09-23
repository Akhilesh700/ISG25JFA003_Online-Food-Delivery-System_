package com.cognizant.onlinefooddeliverysystem.dto.order;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PlaceOrderRequestDto {
    @NotNull
    private String note;
}