package com.cognizant.onlinefooddeliverysystem.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserID")
    private Integer userId;

    @Column(name = "Email", unique = true, nullable = false, length = 100)
    private String email;

    @Column(name = "Password", nullable = false, length = 255)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "Role", nullable = false)
    private UserRole role;

    // --- Relationships ---

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Customer customer;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Restaurant restaurant;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private DeliveryAgent deliveryAgent;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    // --- Enum for Role ---
    public enum UserRole {
        Customer, Restaurant, DeliveryAgent, Admin
    }

    // Getters and Setters are now handled by Lombok
}
