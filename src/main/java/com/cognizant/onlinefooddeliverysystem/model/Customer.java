package com.cognizant.onlinefooddeliverysystem.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "Customer")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CustID")
    private Integer custId;

    @Column(name = "Name", length = 100)
    private String name;

    @Column(name = "Phone", length = 15)
    private String phone;

    @Column(name = "Address", columnDefinition = "TEXT")
    private String address;

    @Column(name = "DOB")
    private LocalDate dob;

    @Column(name = "PreferredPayment", length = 50)
    private String preferredPayment;

    // --- Relationships ---

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserID", referencedColumnName = "UserID", unique = true)
    private User user;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Order> orders;

    // Getters and Setters are now handled by Lombok
}
