package com.cognizant.onlinefooddeliverysystem.repository;

import com.cognizant.onlinefooddeliverysystem.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
