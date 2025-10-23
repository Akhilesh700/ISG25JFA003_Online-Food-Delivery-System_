package com.cognizant.onlinefooddeliverysystem.repository;

import com.cognizant.onlinefooddeliverysystem.dto.deliveryagent.DeliveryAgentProfileDTO;
import com.cognizant.onlinefooddeliverysystem.model.DeliveryAgent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface DeliverAgentRespository extends JpaRepository<DeliveryAgent, Integer> {

    DeliveryAgent findByUser_UserId(Integer userId);

    @Query("SELECT new com.cognizant.onlinefooddeliverysystem.dto.deliveryagent.DeliveryAgentProfileDTO(" +
            "a.agentId, " +
            "u.email, " +
            "a.phone, " +
            "a.status, " +
            "a.identityProofType, " +
            "a.identityProofNo) " +
            "FROM DeliveryAgent a " +
            "JOIN a.user u")
    DeliveryAgentProfileDTO findDeliveryAgentProfile(@Param("agentId") Integer agentId);

    @Query("SELECT status FROM DeliveryAgent")
    Optional<DeliveryAgent.Status> findDeliveryAgentStatus();
}
