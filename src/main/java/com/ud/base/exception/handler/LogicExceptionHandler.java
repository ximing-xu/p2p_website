package com.ud.base.exception.handler;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ud.base.exception.LogicException;

@ControllerAdvice
public class LogicExceptionHandler {
	
	@ExceptionHandler(LogicException.class)
	public String handleLogicException(LogicException e,Model model){
		
		model.addAttribute("error", e);
		
		return "exception/error_logic";
	}
}
