package com.coforge.aspect;

import org.springframework.stereotype.Component;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.AfterReturning;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	// private Logger logger = LoggerFactory.getLogger(this.getClass());
	//private final org.slf4j.Logger logger = LoggerFactory.getLogger(AspectService.class);
	
	private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

	

	 @Before("execution(* com.example.flight.service.*.*(..))")
	    public void logBefore(JoinPoint joinPoint) {
	        logger.info("Executing: " + joinPoint.getSignature().getName());
	    }

	    @AfterReturning("execution(* com.example.flight.service.*.*(..))")
	    public void logAfter(JoinPoint joinPoint) {
	        logger.info("Completed: " + joinPoint.getSignature().getName());
	    }
	
}
