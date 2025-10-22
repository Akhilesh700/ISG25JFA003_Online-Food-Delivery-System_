package com.cognizant.onlinefooddeliverysystem.dto.search;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data // Includes @Getter, @Setter, @ToString, @EqualsAndHashCode, @RequiredArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL) // Don't include null fields in JSON
public class SearchResultItemDto {
    private String type; // "restaurant" or "menuItem"
    private Integer id;
    private String name;
    private String imageUrl;

    // Restaurant specific
    private String address;
    private BigDecimal rating;

    // MenuItem specific
    private String description;
    private BigDecimal price;
    private Integer restaurantId;
    private String restaurantName;

    // Constructor for Restaurant
    public SearchResultItemDto(Integer id, String name, BigDecimal rating, String address, String imageUrl) {
        this.type = "restaurant";
        this.id = id;
        this.name = name;
        this.address = address;
        this.rating = rating;
        this.imageUrl = imageUrl;
    }

    // Constructor for MenuItem
    public SearchResultItemDto(Integer id, String name, String description, BigDecimal price, Integer restaurantId, String restaurantName, String imageUrl) {
        this.type = "menuItem";
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.restaurantId = restaurantId;
        this.restaurantName = restaurantName;
        this.imageUrl = imageUrl;
    }
}