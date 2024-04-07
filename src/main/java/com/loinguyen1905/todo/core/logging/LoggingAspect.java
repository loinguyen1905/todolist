package com.loinguyen1905.todo.core.logging;
//https://romanglushach.medium.com/java-rest-api-logging-best-practices-and-guidelines-bf5982ee4180
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.loinguyen1905.todo.core.interceptor.RestTemplateFilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//A technique that allows you to inject cross-cutting concerns (such as logging) into your code without modifying it.
@Aspect
@Component
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestTemplateFilter.class);

    @Pointcut("within(@org.springframework.web.bind.annotation.RestController *)")
    public void restController() {}

    @Around("restController()")
    public Object logRequest(ProceedingJoinPoint joinPoint) throws Throwable {
        LOGGER.info("Request/: {}", joinPoint.getSignature().getName());
        Object result = joinPoint.proceed();
        LOGGER.info("Response/: {}", result.toString());
        return result;
    }
}