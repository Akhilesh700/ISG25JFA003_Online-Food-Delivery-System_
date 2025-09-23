package com.cognizant.onlinefooddeliverysystem.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Table(name = "Menu_items")
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MenuItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ItemID")
    private Integer itemId;

    @Column(name = "Name", length = 100, nullable = false)
    private String name;

    @Column(name="imgUrl", length = 500, nullable = false)
    private String imgUrl;

    @Column(name = "CuisineType", length = 50, nullable = false)
    private String cuisineType;

    @Column(name = "isAvailable", nullable = false)
    private Boolean isAvailable;

    @Column(name = "isVegetarian", nullable = false)
    private Boolean isVegetarian;

    @Enumerated(EnumType.STRING)
    @Column(name = "Size", nullable = false)
    private MenuItemSize size;

    public enum MenuItemSize{
        small, medium, large, extraLarge
    }


    @Column(name = "Description", columnDefinition = "TEXT", nullable = false)
    private String description;

    @Column(name = "Price", precision = 10, scale = 2, nullable = false)
    private BigDecimal price;

    @Column(name = "PrepTime", nullable = false)
    private Integer prepTime; // Preparation time in minutes

    // --- Relationships ---

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RestID", nullable = false)
    @JsonBackReference()
    private Restaurant restaurant;

    @OneToMany(mappedBy = "menuItems",fetch = FetchType.LAZY)
    @JsonBackReference()
    private List<CartItem> cartItems;

}
