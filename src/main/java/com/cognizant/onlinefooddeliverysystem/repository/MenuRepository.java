package com.cognizant.onlinefooddeliverysystem.repository;

import com.cognizant.onlinefooddeliverysystem.model.MenuItems;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MenuRepository extends JpaRepository<MenuItems, Long> {
    //Searching MenuItems with restId
    List<MenuItems> findByRestaurant_RestId(int restId);

    @Query("select m from MenuItems m")
    Page<MenuItems> findAllMenuItems(Pageable pageable);

    Optional<MenuItems> findMenuItemsByItemId(Long menuItemId);
}
