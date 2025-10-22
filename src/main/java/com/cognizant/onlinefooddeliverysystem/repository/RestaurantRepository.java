package com.cognizant.onlinefooddeliverysystem.repository;

import com.cognizant.onlinefooddeliverysystem.model.Restaurant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
    Restaurant findByUser_UserId(Integer userId);
    @Query("SELECT r FROM Restaurant r WHERE LOWER(r.name) LIKE LOWER(concat('%', :query, '%'))")
    Page<Restaurant> searchByName(@Param("query") String query, Pageable pageable);
}
