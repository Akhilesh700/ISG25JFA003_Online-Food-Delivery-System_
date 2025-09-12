package com.cognizant.onlinefooddeliverysystem.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "Delivery")
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DeliveryID")
    private Integer deliveryId;

    @Column(name = "PickupTime")
    private LocalDateTime pickupTime;

    @Column(name = "DeliveryTime")
    private LocalDateTime deliveryTime;

    @Column(name = "ETA")
    private LocalDateTime eta;

    @Column(name = "TrackingLink", length = 255)
    private String trackingLink;

    // --- Relationships ---

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OrderID", nullable = false)
    @JsonBackReference
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AgentID")
    @JsonBackReference
    private DeliveryAgent deliveryAgent;


    // Getters and Setters are now handled by Lombok
}