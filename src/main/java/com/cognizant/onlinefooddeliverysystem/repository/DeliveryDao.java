package com.cognizant.onlinefooddeliverysystem.repository;

import com.cognizant.onlinefooddeliverysystem.model.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DeliveryDao extends JpaRepository<Delivery, Integer> {


    @Query(value = "select s.status_name from status s \n" +
            "join `order` o \n" +
            "on s.statusid = o.statusid\n" +
            "where o.orderid = :orderId;", nativeQuery = true)
    Optional<String> getDeliveryStatus(@Param("orderId") Integer orderId);

}
