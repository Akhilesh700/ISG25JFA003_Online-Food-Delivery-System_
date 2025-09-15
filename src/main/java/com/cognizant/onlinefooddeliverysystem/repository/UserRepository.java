package com.cognizant.onlinefooddeliverysystem.repository;

import com.cognizant.onlinefooddeliverysystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    // You can add custom query methods here if needed,
    // for example, to find a user by email for login.
    User findByEmail(String email);

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findUserByEmail(String username);
}
