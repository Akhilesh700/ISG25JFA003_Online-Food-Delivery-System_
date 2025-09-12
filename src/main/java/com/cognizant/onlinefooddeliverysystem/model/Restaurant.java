package com.cognizant.onlinefooddeliverysystem.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "Restaurant")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RestID")
    private Integer restId;

    @Column(name = "Name", length = 100, nullable = false)
    private String name;

    @Column(name="imgUrl", length = 500, nullable = false)
    private String imgUrl;

    @Column(name = "Address", columnDefinition = "TEXT", nullable = false)
    private String address;

    @Column(name = "Phone", length = 15, nullable = false)
    private String phone;

    @Column(name = "Rating", precision = 2, scale = 1, nullable = false)
    private BigDecimal rating;

    @Column(name = "OpenTime", nullable = false)
    private LocalTime openTime;

    @Column(name = "CloseTime", nullable = false)
    private LocalTime closeTime;

    // --- Relationships ---

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserID", referencedColumnName = "UserID", unique = true)
    private User user;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<MenuItems> menuItems;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Order> orders;

    // Getters and Setters are now handled by Lombok
}