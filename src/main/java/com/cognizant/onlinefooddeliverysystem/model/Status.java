package com.cognizant.onlinefooddeliverysystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Status")
@NoArgsConstructor
@AllArgsConstructor
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "StatusID")
    private Integer statusId;

    @Enumerated(EnumType.STRING)
    @Column(name = "StatusType", unique = true)
    private StatusType statusType;

    public enum StatusType {
        PLACED, PENDING, FAILED, NOT_ACCEPTED, PREPARING, OUT_FOR_DELIVERY, DELIVERED
    }

    // Getters and Setters are now handled by Lombok
}
