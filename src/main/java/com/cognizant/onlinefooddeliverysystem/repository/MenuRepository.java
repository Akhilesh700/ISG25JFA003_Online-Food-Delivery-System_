package com.cognizant.onlinefooddeliverysystem.repository;

<<<<<<< Updated upstream:src/main/java/com/cognizant/onlinefooddeliverysystem/repository/MenuRepository.java
import com.cognizant.onlinefooddeliverysystem.model.MenuItems;
=======
import com.Learnings.dine_cognizant.model.MenuItems;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
>>>>>>> Stashed changes:src/main/java/com/Learnings/dine_cognizant/repository/MenuRepository.java
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<MenuItems, Long> {
    //Searching MenuItems with restId
    List<MenuItems> findByRestaurant_RestId(int restId);

    @Query("select m from MenuItems m")
    Page<MenuItems> findAllMenuItems(Pageable pageable);
}
