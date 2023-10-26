package com.example.productinformation.aspect;

import com.example.productinformation.exception.NoSuchFurnitureException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LoggerAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("execution(* com.example.furniture.controller.*.*(..))")
    public void beforeControllerMethodExecution(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        logger.info("@Before 메소드 : " + methodName + " 실행 ");
    }

    @Pointcut("execution(* com.example.furniture.controller.*.*(..))")
    private void controllerMethods() {}

    @After("controllerMethods()")
    public void afterControllerMethodExecution(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        logger.info("@After 메소드 : " + methodName + " 실행 ");
    }

    @Around("controllerMethods()")
    public Object aroundControllerMethodExecution(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        logger.info("Before executing " + methodName);

        try {
            Object result = joinPoint.proceed();
            logger.info("After executing " + methodName);
            return result;
        } catch (NoSuchFurnitureException ex) {
            logger.error("Exception in method " + methodName + ": " + ex.getMessage());
            throw ex;
        }
    }

    @AfterThrowing(pointcut = "execution(* com.example.furniture.service.*.*(..))", throwing = "ex")
    public void logException(JoinPoint joinPoint, Exception ex) {
        String methodName = joinPoint.getSignature().getName();
        logger.error("Exception in method " + methodName + ": " + ex.getMessage());
    }
}
