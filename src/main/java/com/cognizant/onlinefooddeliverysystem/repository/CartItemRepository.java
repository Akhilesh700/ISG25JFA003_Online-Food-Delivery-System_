package com.cognizant.onlinefooddeliverysystem.repository;


import com.cognizant.onlinefooddeliverysystem.model.CartItem;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
//    Method for returning cart items against a particular cart id
    List<CartItem> findByCartId(Long cartId);

    @Modifying
    @Transactional
    @Query("DELETE FROM CartItem c WHERE c.cart.id = :cartId")
    int deleteCartItemsByCartId(@Param("cartId") Long id);
}
