package com.cognizant.onlinefooddeliverysystem.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Status")
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "StatusID")
    private Integer statusId;

    @Column(name = "StatusName", length = 50)
    private String statusName;

    @Enumerated(EnumType.STRING)
    @Column(name = "EntityType")
    private EntityType entityType;

    public enum EntityType {
        Order, Payment, Delivery
    }

    // Getters and Setters are now handled by Lombok
}
