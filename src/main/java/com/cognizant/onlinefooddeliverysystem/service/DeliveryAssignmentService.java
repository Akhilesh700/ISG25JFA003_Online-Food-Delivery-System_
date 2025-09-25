package com.cognizant.onlinefooddeliverysystem.service;

import com.cognizant.onlinefooddeliverysystem.model.Delivery;
import com.cognizant.onlinefooddeliverysystem.model.DeliveryAgent;
import com.cognizant.onlinefooddeliverysystem.model.Order;
import jakarta.transaction.Transactional;


public interface DeliveryAssignmentService {

    @Transactional
    public Delivery assignOrder(Integer orderId);

    public void validateOrderIsAssignable(Integer orderId);

    public DeliveryAgent findAndSelectAvailableAgent();

    public Delivery createDelivery(Order order, DeliveryAgent agent);

}
