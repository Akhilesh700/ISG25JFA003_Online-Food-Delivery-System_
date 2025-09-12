package com.cognizant.onlinefooddeliverysystem.model;

import jakarta.persistence.*;

@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private long id;

    //Relationship mapping
    @JoinColumn(name = "CustID", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;

    @JoinColumn(name = "cart_items_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private CartItems cartItems;

}
