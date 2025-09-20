package com.cognizant.onlinefooddeliverysystem.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderItemId")
    private long orderItemId;

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
    @JoinColumn(name = "orderId")
    @JsonBackReference// This will be the foreign key column in the CartItem table
    private Order order;
}
