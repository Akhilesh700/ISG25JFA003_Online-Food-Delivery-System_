package com.cognizant.onlinefooddeliverysystem.logaop;

import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogManager {

    private static final Logger LOGGER = LoggerFactory.getLogger()

    public void logMethodCall(){

    }
}
