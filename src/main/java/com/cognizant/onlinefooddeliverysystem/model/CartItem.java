package com.cognizant.onlinefooddeliverysystem.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_item_id")
    private long cartItemId;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price")
    private float price;

    //Relationship mapping
    @JoinColumn(name = "menu_item_id")
    @OneToOne(fetch = FetchType.LAZY)
    private MenuItems menuItems;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id") // This will be the foreign key column in the CartItem table
    private Cart cart;

}
