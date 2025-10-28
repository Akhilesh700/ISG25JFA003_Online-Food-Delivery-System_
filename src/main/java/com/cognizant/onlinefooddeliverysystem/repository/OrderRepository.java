package com.cognizant.onlinefooddeliverysystem.repository;

import com.cognizant.onlinefooddeliverysystem.dto.order.GetOrderHistoryByDeliveryAgentResponse;
import com.cognizant.onlinefooddeliverysystem.dto.restaurant.OrderHistoryByRestaurant;
import com.cognizant.onlinefooddeliverysystem.util.OrderIdDeliveryId;
import com.cognizant.onlinefooddeliverysystem.model.Order;
import com.cognizant.onlinefooddeliverysystem.dto.order.UnassignedOrderDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Query(value = "SELECT o.orderid, r.restid, o.order_time, o.special_req, o.total_amount, s.status_type, c.address, c.name, c.phone\n" +
            "FROM `order` o \n" +
            "JOIN status s \n" +
            "ON o.status=s.statusid\n" +
            "JOIN restaurant r\n" +
            "ON o.restid=r.restid\n" +
            "JOIN customer c\n" +
            "ON o.custid = c.custid\n" +
            "WHERE (s.status_type = \"PREPARING\" or s.status_type = \"NOT_ACCEPTED\") and r.restId = :id; ", nativeQuery = true)
    public List<UnassignedOrderDTO> findUnassignedOrders(Integer id);


    Optional<Order> findOrderByOrderId(Integer id);

    @Query(value = "select o.orderid, d.deliveryid from `order` o\n" +
            "left join delivery d\n" +
            "on o.orderid = d.orderid\n" +
            "where o.orderid = :id ", nativeQuery = true)
    Optional<OrderIdDeliveryId> findOrderIdDeliveryID(@Param("id") Integer id);


    @Transactional
    @Modifying
    @Query(value = "Update `order`\n" +
            "set status = :statusid\n" +
            "where orderid = :orderid;", nativeQuery = true)
    int updateOrderStatus(@Param("orderid") Integer orderId, @Param("statusid") Integer statusId);


    List<Order> findByCustomer_CustId(Integer orderId);

    @Query("SELECT new com.cognizant.onlinefooddeliverysystem.dto.restaurant.OrderHistoryByRestaurant(" +
            "    o.orderId, " +
            "    o.orderTime, " +
            "    o.specialReq, " +
            "    o.totalAmount, " +
            "    c.name, " +
            "    c.phone, " +
            "    s.statusType" +
            ") " +
            "FROM Order o " +
            "JOIN o.customer c " +
            "JOIN o.status s " +
            "JOIN o.restaurant r " +
            "WHERE r.restId = :restId")
    List<OrderHistoryByRestaurant> findByRestaurant_RestId(@Param("restId") Integer restId);

    @Query("SELECT NEW com.cognizant.onlinefooddeliverysystem.dto.order.GetOrderHistoryByDeliveryAgentResponse(\n" +
            "    o.id,\n" +
            "    r.name,\n" +
            "    c.name,\n" +
            "    c.phone,\n" +
            "    o.orderTime,\n" +
            "    r.address,\n" +
            "    c.address,\n" +
            "    s.statusType,\n" +
            "    o.totalAmount,\n" +
            "(SELECT COUNT(item.id) FROM OrderItem item WHERE item.order = o)\n" +
            ")\n" +
            "FROM Order o\n" +
            "JOIN o.delivery d\n" +
            "JOIN o.customer c\n" +
            "JOIN o.status s\n" +
            "JOIN o.restaurant r\n" +
            "JOIN d.deliveryAgent a\n" +
            "WHERE a.agentId = :agentId")
    List<GetOrderHistoryByDeliveryAgentResponse> findOrderHistory(@Param("agentId") Integer agentId);

    @Query("SELECT o FROM Order o " +
            "JOIN FETCH o.customer c " +
            "JOIN FETCH o.restaurant r " +
            "JOIN FETCH o.status s " +
            "WHERE o.orderId = :orderId")
    Optional<Order> findOrderInfoById(@Param("orderId") Integer orderId);
}
