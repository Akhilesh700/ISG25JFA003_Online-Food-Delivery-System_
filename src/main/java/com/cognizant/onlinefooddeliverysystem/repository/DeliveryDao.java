package com.cognizant.onlinefooddeliverysystem.repository;

import com.cognizant.onlinefooddeliverysystem.util.OrderId_DeliveryId;
import com.cognizant.onlinefooddeliverysystem.model.Order;
import com.cognizant.onlinefooddeliverysystem.dto.UnassignedOrderDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DeliveryDao extends JpaRepository<Order, Integer> {

    @Query(value = "SELECT o.orderid, r.restid, o.order_time, o.special_req, o.total_amount, s.status_name, c.address, c.name, c.phone\n" +
            "FROM `order` o \n" +
            "JOIN status s \n" +
            "ON o.statusid=s.statusid\n" +
            "JOIN restaurant r\n" +
            "ON o.restid=r.restid\n" +
            "JOIN customer c\n" +
            "ON o.custid = c.custid\n" +
            "WHERE (s.status_name = \"Preparing\" or s.status_name = \"Not_Accepted\") and r.restId = :id; ", nativeQuery = true)
    public List<UnassignedOrderDTO> findUnassignedOrders(Integer id);


    Optional<Order> findOrderByOrderId(Integer id);

    @Query(value = "select o.orderid, d.deliveryid from `order` o\n" +
            "left join delivery d\n" +
            "on o.orderid = d.orderid\n" +
            "where o.orderid = :id;", nativeQuery = true)
    Optional<OrderId_DeliveryId> findOrderIdDeliveryID(Integer id);

}
