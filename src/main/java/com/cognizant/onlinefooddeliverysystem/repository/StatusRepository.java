package com.cognizant.onlinefooddeliverysystem.repository;

import com.cognizant.onlinefooddeliverysystem.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StatusRepository extends JpaRepository<Status, Integer> {

//    @Query(value = "SELECT * FROM STATUS", nativeQuery = true)
    Optional<Status> findByStatusType(Status.StatusType status);

    Optional<Status> findByStatusId(int statusId);
}