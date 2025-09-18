package com.cognizant.onlinefooddeliverysystem.model;

import jakarta.persistence.*;
import lombok.Cleanup;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private long id;

    @Column(name="note")
    private String note;

    @Column(name = "total_price", nullable = true)
    private Float totalPrice;

    //Relationship mapping
    @JoinColumn(name = "CustID", nullable = false)
    @OneToOne(fetch = FetchType.LAZY)
    private Customer customer;

    @OneToMany(mappedBy = "cart", fetch = FetchType.LAZY)
    private List<CartItem> cartItems;

}
