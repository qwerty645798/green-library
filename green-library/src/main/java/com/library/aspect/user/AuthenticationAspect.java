package com.library.aspect.user;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.library.exception.SessionNotFoundException;

import java.util.Arrays;

@Aspect
@Component
public class AuthenticationAspect {

    private final Logger logger = LoggerFactory.getLogger(AuthenticationAspect.class);

    @Around("execution(* com.library.controller.user.UserController.*(..))")
    public Object authenticateAndProceed(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("AuthenticationAspect is called");

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            throw new SessionNotFoundException("Session not found or user is not authenticated");
        }

        String userId = authentication.getName();
        logger.info("userid: " + userId);
        Object[] args = joinPoint.getArgs();
        logger.info("Original method arguments: " + Arrays.toString(args));

        for (int i = 0; i < args.length; i++) {
        	logger.info("Argument " + i + ": type = " + args[i].getClass().getName() + ", value = " + args[i]);
            if (args[i] instanceof String && "abc".equals(args[i])) {
                args[i] = userId;
                logger.info("Aspect replaced userIdPlaceholder with: " + userId);
            }
        }

        logger.info("Modified method arguments: " + Arrays.toString(args));

        return joinPoint.proceed(args);
    }
}