package com.cognizant.onlinefooddeliverysystem.repository;

import com.cognizant.onlinefooddeliverysystem.model.MenuItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MenuItemRepository extends JpaRepository<MenuItems, Integer> {
    @Query("SELECT m FROM MenuItems m JOIN m.orderItems oi WHERE oi.order.orderId = :orderId")
    List<MenuItems> findByOrderItem_OrderId(@Param("orderId") Long orderID);
}
