package com.cognizant.onlinefooddeliverysystem.dto.cart;

import com.cognizant.onlinefooddeliverysystem.model.MenuItems;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CartRequestDto {

    private List<OrderItemDto> orderItems;
    private String note;

}
