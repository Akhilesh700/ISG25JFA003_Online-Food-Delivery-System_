package com.cognizant.onlinefooddeliverysystem.repository;

import com.cognizant.onlinefooddeliverysystem.model.DeliveryAgent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface DeliveryAgentDao extends JpaRepository<DeliveryAgent, Integer> {


    @Query(value = "Select * \n" +
            "FROM delivery_agent \n" +
            "WHERE status = \"Available\";", nativeQuery = true)
    List<DeliveryAgent> findAllAvailableDeliveryAgent();

    @Query(value = "select agentid from delivery_agent \n" +
            "where status = \"Available\";", nativeQuery = true)
    List<Integer> findAllAvailableDeliveryAgents();

    Optional<DeliveryAgent> findDeliveryAgentByAgentId(Integer id);

}
