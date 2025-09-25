package com.cognizant.onlinefooddeliverysystem.dto.order;

import com.cognizant.onlinefooddeliverysystem.model.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AcceptRejectOrderResponseDto {
    private Status.StatusType updatedStatus;
    private String message;
}
