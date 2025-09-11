package com.cognizant.onlinefooddeliverysystem.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "DeliveryAgent")
public class DeliveryAgent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AgentID")
    private Integer agentId;

    @Column(name = "Name", length = 100)
    private String name;

    @Column(name = "Phone", length = 15)
    private String phone;

    @Column(name = "Email", length = 100)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private  Status status;

    public enum Status {
        Available, InDelivery, Offline
    }

    @Column(name = "IdentityProofType", length = 50)
    private String identityProofType;

    @Column(name = "IdentityProofNo", length = 50)
    private String identityProofNo;

    // --- Relationships ---

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserID", referencedColumnName = "UserID", unique = true)
    @JsonBackReference
    private User user;

    @JsonBackReference
    @OneToMany(mappedBy = "deliveryAgent", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Delivery> deliveries;

    // Getters and Setters are now handled by Lombok
}
