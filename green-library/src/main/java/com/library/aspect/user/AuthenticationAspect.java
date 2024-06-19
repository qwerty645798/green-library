package com.library.aspect.user;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.library.exception.SessionNotFoundException;

@Aspect
@Component
@Order(1)
public class AuthenticationAspect {
	
	private final Logger logger = LoggerFactory.getLogger(AuthenticationAspect.class);

	@Around("execution(* com.library.controller.user.UserController.*(..))")
    public Object authenticateAndProceed(ProceedingJoinPoint joinPoint) throws Throwable {
    	logger.info("AuthenticationAspect is called");
    	logger.info("Class: " + joinPoint.getTarget().getClass().getName());
    	logger.info("Method: " + joinPoint.getSignature().getName());
        logger.info("Arguments: " + Arrays.toString(joinPoint.getArgs()));
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            throw new SessionNotFoundException("Session not found or user is not authenticated");
        }
        String userId = authentication.getName();

        Object[] args = joinPoint.getArgs();
        for (int i = 0; i < args.length; i++) {
            if (args[i] instanceof String && "userIdPlaceholder".equals(args[i])) {
                args[i] = userId;
                logger.info("Aspect replaced userIdPlaceholder with: " + userId);
            }
        }
        return joinPoint.proceed(args);
    }
}