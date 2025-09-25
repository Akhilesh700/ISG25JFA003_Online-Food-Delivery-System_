package com.cognizant.onlinefooddeliverysystem.repository;

import com.cognizant.onlinefooddeliverysystem.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
    /**
     * Finds the maximum preparation time from all menu items of the order.
     * This is used to calculate the accurate food prep ETA.
     *
     * @param orderId The ID of the order.
     * @return The maximum preparation time in minutes as a Float, or null if the order has no items.
     */
    @Query("SELECT MAX(mi.prepTime) FROM OrderItem oi JOIN oi.menuItems mi WHERE oi.order.id = :orderId")
    Float findMaxPrepTimeByOrderId(@Param("orderId") Integer orderId);
}
