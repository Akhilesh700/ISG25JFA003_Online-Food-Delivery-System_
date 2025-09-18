package com.cognizant.onlinefooddeliverysystem.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "Restaurant")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RestID")
    private Integer restId;

    @Column(name = "Name", length = 100, nullable = false)
    private String name;

    @Column(name="imgUrl", length = 500)
    private String imgUrl;

    @Column(name = "Address", columnDefinition = "TEXT", nullable = false)
    private String address;

    @Column(name = "Phone", length = 15, nullable = false)
    private String phone;

    @Column(name = "Rating", precision = 2, scale = 1, columnDefinition = "DECIMAL(2,1) DEFAULT 0.0")
    private BigDecimal rating;

    @Column(name = "OpenTime", nullable = false)
    private LocalTime openTime;

    @Column(name = "CloseTime", nullable = false)
    private LocalTime closeTime;

    // --- Relationships ---

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserID",nullable = false, referencedColumnName = "UserID", unique = true)
    private User user;

    @JsonManagedReference("restaurant-menu")
    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<MenuItems> menuItems;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Order> orders;

    // Getters and Setters are now handled by Lombok
}