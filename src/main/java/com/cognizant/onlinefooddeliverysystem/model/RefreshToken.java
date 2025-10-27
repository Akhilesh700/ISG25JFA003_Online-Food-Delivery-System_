package com.cognizant.onlinefooddeliverysystem.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode; // Import for explicit JSON mapping
import org.hibernate.type.SqlTypes;          // Import for SqlTypes.JSON

import java.time.Instant;

@Entity
@Table(name = "refresh_tokens")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RefreshToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String token;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private Instant expiryDate;

    @Column(nullable = false, updatable = false)
    private Instant createdAt;

    @Column
    private Instant lastUsedAt;

    // Use @Builder.Default with @Builder to ensure the default value is applied
    @Column(nullable = false)
    @Builder.Default
    private boolean isRevoked = false;

    // --- JSON Mapping Update ---
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "json")
    private DeviceInfo deviceInfo;
    // --- End Update ---

    // --- Lifecycle Callbacks ---

    @PrePersist
    protected void onCreate() {
        createdAt = Instant.now();
    }

}