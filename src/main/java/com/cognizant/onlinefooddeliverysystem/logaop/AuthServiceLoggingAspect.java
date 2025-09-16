package com.cognizant.onlinefooddeliverysystem.logaop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuthServiceLoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthServiceLoggingAspect.class);

    ///////////////////////////////////////////////////////////////////////////
    //////                  Logger for method calls                      ///////
    /// ///////////////////////////////////////////////////////////////////////


    //Logging before the start of method call
    @Before("execution(* com.cognizant.onlinefooddeliverysystem.security.AuthService.*(..))")
    public void logBeforeMethodCall(JoinPoint jp){
        LOGGER.info("Method " + jp.getSignature().getName() + " called");
    }


    //Logging after the end of method call
    @After("execution(* com.cognizant.onlinefooddeliverysystem.security.AuthService.*(..))")
    public void logAfterMethodCall(JoinPoint jp){
        LOGGER.info("Method " + jp.getSignature().getName() + " call completed");
    }

    @AfterReturning("execution(* com.cognizant.onlinefooddeliverysystem.security.AuthService.*(..))")
    public void logAfterReturningMethodCall(JoinPoint jp){
        LOGGER.info("Method " + jp.getSignature().getName() + " executed successfully");
    }


    @AfterThrowing("execution(* com.cognizant.onlinefooddeliverysystem.security.AuthService.*(..))")
    public void logAfterThrowingMethodCall(JoinPoint jp){

        LOGGER.info("Method " + jp.getSignature().getName() + " has thrown error");
    }

    ///////////////////////////////////////////////////////////////////////////
    //////              Logger for performance monitoring               ///////
    /// ///////////////////////////////////////////////////////////////////////

    @Around("execution(* com.cognizant.onlinefooddeliverysystem.security.AuthService.*(..))")
    public Object logForPerformanceMonitoring(ProceedingJoinPoint jp) throws Throwable {
        long start = System.currentTimeMillis();

//      Proceeding for the method call and returning it in the form of object
        Object obj = jp.proceed();

        long end = System.currentTimeMillis();

        LOGGER.info("Method " + jp.getSignature().getName() + " took " + (end-start) + " ms");

        return obj;
    }

}
