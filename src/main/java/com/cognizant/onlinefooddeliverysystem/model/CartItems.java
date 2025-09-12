package com.cognizant.onlinefooddeliverysystem.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class CartItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_items_id")
    private long cartItemsId;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "notes")
    private String notes;

    //Relationship mapping
    @JoinColumn(name = "Menu_items_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private MenuItems menuItems;
}
