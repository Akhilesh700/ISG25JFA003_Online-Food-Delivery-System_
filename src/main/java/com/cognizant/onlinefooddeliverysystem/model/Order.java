package com.cognizant.onlinefooddeliverysystem.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@Entity
// "Order" is a reserved keyword in SQL, so we must quote it.
@Table(name = "`Order`")
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OrderID")
    private Integer orderId;

    @Column(name = "SpecialReq", columnDefinition = "TEXT")
    private String specialReq;

//    Ordertime will be created automatically and it is not mutable
    @Column(name = "OrderTime", updatable = false, nullable = false)
    @CreationTimestamp
    private LocalDateTime orderTime;

    @Column(name = "TotalAmount", precision = 10, scale = 2, nullable = false)
    private BigDecimal totalAmount;

    // --- Relationships ---

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CustID", nullable = false)
    @JsonBackReference
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RestID", nullable = false)
    @JsonBackReference
    private Restaurant restaurant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Status")
    @JsonBackReference
    private Status status;

//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "cart_id")
//    @JsonBackReference
//    private Cart cart;


    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonBackReference
    private Delivery delivery;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonBackReference
    private Set<Payment> payments;

    // Getters and Setters are now handled by Lombok
}

