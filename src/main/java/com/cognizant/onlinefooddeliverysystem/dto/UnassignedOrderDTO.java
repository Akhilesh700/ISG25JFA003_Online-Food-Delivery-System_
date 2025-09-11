package com.cognizant.onlinefooddeliverysystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;


@Data
@AllArgsConstructor
public class UnassignedOrderDTO {

    private Integer orderId;
    private Integer restId;

    private Timestamp orderTime;
    private String specialReq;
    private BigDecimal totalAmount;
    private String statusName;
    private String address;
    private String name;
    private String phone;
}
