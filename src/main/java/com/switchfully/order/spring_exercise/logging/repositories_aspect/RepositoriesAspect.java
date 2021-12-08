package com.switchfully.order.spring_exercise.logging.repositories_aspect;

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
public class RepositoriesAspect {
    private Logger logger = LoggerFactory.getLogger(RepositoriesAspect.class);

    @Pointcut("execution(* com.switchfully.order.spring_exercise.repositories.*.*.*(..))")
    public void allRepos() {}

    @Before("allRepos()")
    public void logInfoBeforeAllRepositoryMethods(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().toShortString();
        logger.debug("Calling method: " + method);
    }

    @After("allRepos()")
    public void logInfoAfterAllRepositoryMethods(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().toShortString();
        logger.debug("Finished method: " + method);
    }
}
