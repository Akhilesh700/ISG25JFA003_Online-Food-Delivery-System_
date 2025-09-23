package com.cognizant.onlinefooddeliverysystem.repository;

import com.cognizant.onlinefooddeliverysystem.model.Cart;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    @Query("SELECT c FROM Cart c WHERE c.customer.custId = :customerId")
    Optional<Cart> findCartByCustId(Integer customerId);

    @Modifying
    @Transactional
    @Query("UPDATE Cart c SET c.totalPrice = null, c.note = null WHERE c.id = :id")
    int resetCartById(@Param("id") Long id);
}
