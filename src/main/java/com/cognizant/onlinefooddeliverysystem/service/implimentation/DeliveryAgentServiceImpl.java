package com.cognizant.onlinefooddeliverysystem.service.implimentation;

import com.cognizant.onlinefooddeliverysystem.dto.deliveryagent.DeliveryAgentProfileDTO;
import com.cognizant.onlinefooddeliverysystem.exception.ResourceNotFoundException;
import com.cognizant.onlinefooddeliverysystem.model.DeliveryAgent;
import com.cognizant.onlinefooddeliverysystem.model.User;
import com.cognizant.onlinefooddeliverysystem.repository.DeliverAgentRespository;
import com.cognizant.onlinefooddeliverysystem.service.DeliveryAgentService;
import com.cognizant.onlinefooddeliverysystem.util.GetVerifiedUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeliveryAgentServiceImpl implements DeliveryAgentService {
    private final GetVerifiedUser getVerifiedUser;
    private final DeliverAgentRespository deliverAgentRespository;

    @Override
    public DeliveryAgentProfileDTO getDeliveryAgentProfile() {
        User user = getVerifiedUser.getVerifiedUser();
        DeliveryAgent agent = deliverAgentRespository.findByUser_UserId(user.getUserId());
        if(agent == null) {
            throw new ResourceNotFoundException("This user is not a delivery agent");
        }

        return deliverAgentRespository.findDeliveryAgentProfile(agent.getAgentId());
    }

    @Override
    public DeliveryAgent.Status getDeliveryAgentStatus(){
        User user = getVerifiedUser.getVerifiedUser();
        DeliveryAgent agent = deliverAgentRespository.findByUser_UserId(user.getUserId());
        if(agent == null) {
            throw new ResourceNotFoundException("This user is not a delivery agent");
        }

        DeliveryAgent.Status status = deliverAgentRespository.findDeliveryAgentStatus()
                .orElseThrow(() ->new ResourceNotFoundException("Delivery Status not found for agent ID: " + agent.getAgentId()));

        return status;
    }
}
