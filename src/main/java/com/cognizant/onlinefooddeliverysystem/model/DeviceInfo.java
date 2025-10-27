package com.cognizant.onlinefooddeliverysystem.model;


import java.io.Serializable;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeviceInfo implements Serializable {
    private String ip;
    private String name;
    private String browserName;
    private String browserVersion;
    private String timezone;
    private String deviceType;
}
