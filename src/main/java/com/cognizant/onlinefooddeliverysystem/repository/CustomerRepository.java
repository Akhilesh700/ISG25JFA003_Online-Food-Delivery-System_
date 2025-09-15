package com.cognizant.onlinefooddeliverysystem.repository;

import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    // The correct method to find a Customer by the User's ID
    Optional<Customer> findByUser_UserId(Integer userId);
}
