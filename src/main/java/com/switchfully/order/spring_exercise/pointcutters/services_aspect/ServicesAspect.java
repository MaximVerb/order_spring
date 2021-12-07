package com.switchfully.order.spring_exercise.pointcutters.services_aspect;

import com.switchfully.order.spring_exercise.pointcutters.repositories_aspect.RepositoriesAspect;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServicesAspect {
    private Logger logger = LoggerFactory.getLogger(ServicesAspect.class);

    @Pointcut("execution(* com.switchfully.order.spring_exercise.services.*.*.*(..))")
    public void allServices() {}

    @Before("allServices()")
    public void logInfoBeforeAllServiceMethods(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().toShortString();
        logger.info("Calling method: " + method);
    }

    @After("allServices()")
    public void logInfoAfterAllServiceMethods(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().toShortString();
        logger.info("Finished method: " + method);
    }
}
