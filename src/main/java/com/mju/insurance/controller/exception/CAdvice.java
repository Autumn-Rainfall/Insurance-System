package com.mju.insurance.controller.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class CAdvice {
	private Logger logger = LoggerFactory.getLogger(CAdvice.class);
	
	@ExceptionHandler(Exception.class)
	public String handleException(Exception exception, Model model) {
		logger.error("Exception Occurred : {}", exception.getMessage());
		model.addAttribute("msg", "Please try again in a moment");
		model.addAttribute("content", exception.getMessage());
		return "exception/error";
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public String handle404(NoHandlerFoundException exception, Model model) {
		logger.error("404 Request Occurred", exception.getRequestURL());
		model.addAttribute("msg", "There is no such page");
		model.addAttribute("content", "No mapping found for HTTP request with URI" + "'" + exception.getRequestURL() + "'");
		return "exception/error";
	}
}
