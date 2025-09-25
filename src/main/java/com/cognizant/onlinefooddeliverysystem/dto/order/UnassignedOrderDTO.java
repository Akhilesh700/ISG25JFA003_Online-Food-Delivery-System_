package com.cognizant.onlinefooddeliverysystem.dto.order;

import com.cognizant.onlinefooddeliverysystem.model.Status;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Timestamp;


@Getter
@Setter
@AllArgsConstructor
@Builder
public class UnassignedOrderDTO {

    private Integer orderId;
    private Integer restId;

    private Timestamp orderTime;
    private String specialReq;
    private BigDecimal totalAmount;
    private String statusType;
    private String address;
    private String name;
    private String phone;
}
