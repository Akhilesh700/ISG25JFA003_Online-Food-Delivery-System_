package com.cognizant.onlinefooddeliverysystem.repository;

import com.cognizant.onlinefooddeliverysystem.model.MenuItems;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MenuItemRepository extends JpaRepository<MenuItems, Integer> {

    List<MenuItems> findByRestaurant_RestId(Integer restId);
    @Query("SELECT mi FROM MenuItems mi JOIN FETCH mi.restaurant r WHERE LOWER(mi.name) LIKE LOWER(concat('%', :query, '%')) OR LOWER(mi.description) LIKE LOWER(concat('%', :query, '%'))")
    Page<MenuItems> searchByNameOrDescription(@Param("query") String query, Pageable pageable);
}
