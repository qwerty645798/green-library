package com.library.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    // 세션이 없을 때 발생하는 예외
    @ExceptionHandler(SessionNotFoundException.class)
    public ModelAndView handleSessionNotFound(SessionNotFoundException ex) {
        logger.error("Session not found: {}", ex.getMessage());
        ModelAndView modelAndView = new ModelAndView("userLogin");
        modelAndView.addObject("error", true);
        modelAndView.setStatus(HttpStatus.UNAUTHORIZED);
        return modelAndView;
    }

    // 요청 파라미터가 없을 때 발생하는 예외
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ModelAndView handleMissingParams(MissingServletRequestParameterException ex) {
        logger.error("Missing request parameter: {}", ex.getParameterName());
        ModelAndView modelAndView = new ModelAndView("error/missingServletRequestParam");
        modelAndView.addObject("error", ex.getParameterName() + " parameter is missing");
        modelAndView.setStatus(HttpStatus.BAD_REQUEST);
        return modelAndView;
    }

    // 특정 쿼리의 결과가 없을 때 발생하는 예외
    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ModelAndView handleEmptyResultDataAccess(EmptyResultDataAccessException ex) {
        logger.error("Empty result data access: {}", ex.getMessage());
        ModelAndView modelAndView = new ModelAndView("userLogin");
        modelAndView.addObject("error", true);
        modelAndView.setStatus(HttpStatus.NOT_FOUND);
        return modelAndView;
    }

    // 데이터베이스 관련 최상위 예외
    @ExceptionHandler(DatabaseException.class)
    public ModelAndView handleDatabaseException(DatabaseException ex) {
        logger.error("Database error: {}", ex.getMessage());
        ModelAndView modelAndView = new ModelAndView("userLogin");
        modelAndView.addObject("error", true);
        modelAndView.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        return modelAndView;
    }

    // 사용자를 찾을 수 없을 때 발생하는 예외
    @ExceptionHandler(UsernameNotFoundException.class)
    public ModelAndView handleUsernameNotFoundException(UsernameNotFoundException ex) {
        logger.error("User not found: {}", ex.getMessage());
        ModelAndView modelAndView = new ModelAndView("userLogin");
        modelAndView.addObject("message", "유효하지 않은 정보입니다.");
        modelAndView.setStatus(HttpStatus.NOT_FOUND);
        return modelAndView;
    }

    // 그 외 모든 예외
    @ExceptionHandler(Exception.class)
    public ModelAndView handleGlobalException(Exception ex) {
        logger.error("An unexpected error occurred: {}", ex.getMessage());
        ModelAndView modelAndView = new ModelAndView("error/500");
        modelAndView.addObject("message", "오류가 발생했습니다. 잠시 후 다시 시도해주세요.");
        modelAndView.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        return modelAndView;
    }
}