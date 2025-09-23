package com.cognizant.onlinefooddeliverysystem.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private MenuItems menuItems;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id")
    @JsonBackReference// This will be the foreign key column in the CartItem table
    private Cart cart;

}
