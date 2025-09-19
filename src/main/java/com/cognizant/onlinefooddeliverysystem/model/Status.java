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

    @Enumerated(EnumType.STRING)
    @Column(name = "StatusType")
    private StatusType statusType;

    public enum StatusType {
        PLACED, NOT_ACCEPTED, PREPARING, OUT_FOR_DELIVERY, DELIVERED
    }

    // Getters and Setters are now handled by Lombok
}
