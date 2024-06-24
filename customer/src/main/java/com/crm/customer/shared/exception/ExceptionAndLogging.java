package com.crm.customer.shared.exception;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExceptionAndLogging {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    // Define pointcut to include all methods within com.crm.customer package
    @Pointcut("within(com.crm.customer..*)")
    public void applicationPackagePointcut() {
    }

    // Advice to log method entry
    @Before("applicationPackagePointcut()")
    public void logBefore(JoinPoint joinPoint) {
        logger.info("Entering: {}", joinPoint.getSignature().toShortString());
    }

    // Advice to log method exit
    @After("applicationPackagePointcut()")
    public void logAfter(JoinPoint joinPoint) {
        logger.info("Exiting: {}", joinPoint.getSignature().toShortString());
    }

    // Advice to log successful method execution
    @AfterReturning(pointcut = "applicationPackagePointcut()", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        logger.info("Method {} successfully executed with result: {}", joinPoint.getSignature().toShortString(), result);
    }

    // Advice to handle exceptions and log error
    @AfterThrowing(pointcut = "applicationPackagePointcut()", throwing = "ex")
    public void logAfterThrowing(Exception ex) {
        logger.error("Exception occurred: {}", ex.getMessage());
        // Optionally, you can perform additional handling or notification here
    }

    // Additional advice for logging warnings
    @AfterThrowing(pointcut = "applicationPackagePointcut()", throwing = "ex")
    public void logWarnAfterThrowing(Exception ex) {
        logger.warn("Exception occurred (warn level): {}", ex.getMessage());
        // Optionally, you can perform additional handling or notification here
    }
}
