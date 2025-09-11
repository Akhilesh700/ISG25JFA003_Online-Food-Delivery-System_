package com.cognizant.onlinefooddeliverysystem.repository;

import com.cognizant.onlinefooddeliverysystem.model.DeliveryAgent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DeliveryAgentDao extends JpaRepository<DeliveryAgent, Integer> {


    @Query(value = "Select * \n" +
            "FROM delivery_agent \n" +
            "WHERE status = \"Available\";", nativeQuery = true)
    public List<DeliveryAgent> findAllAvailableDeliveryAgent();



}
