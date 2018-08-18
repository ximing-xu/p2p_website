package com.ud.base.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	@ExceptionHandler(NullPointerException.class)
	public String handleException(NullPointerException e,Model model){
		logger.warn("GloabalExceptionHandler handing a Exception: "+e.getMessage());
		e.printStackTrace();
//		model.addAttribute("exception",e.getMessage());
		//model.addAttribute("error",e);
		return "exception/nullPointerException";
	}
}
