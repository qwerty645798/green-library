package com.library.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
		ModelAndView modelAndView = new ModelAndView("public/userLogin");
		modelAndView.addObject("message", "인증된 사용자가 존재하지 않습니다.");
		modelAndView.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		return modelAndView;
	}

	// 요청 파라미터가 없을 때 발생하는 예외
	@ExceptionHandler(MissingServletRequestParameterException.class)
	public void handleMissingParams(MissingServletRequestParameterException ex) {
		logger.error("Missing request parameter: {}", ex.getParameterName());
	}

	// 데이터베이스 커스텀 예외
	@ExceptionHandler(DatabaseException.class)
	public void handleDatabaseException(DatabaseException ex) {
		logger.error("Database error: {}", ex.getMessage());
	}
	
	// 유저 로그인 실패시 발생하는 예외
	@ExceptionHandler(UsernameNotFoundException.class)
	public void handleUsernameNotFoundException(UsernameNotFoundException ex) {
		logger.error("Username not found: {}", ex.getMessage());
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