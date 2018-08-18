package com.ud.base.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Getter;
import lombok.Setter;


@Getter@Setter
@ResponseStatus(value=HttpStatus.NOT_FOUND,reason="the resources your find is missing!!!")
public class LogicException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8796882352077998509L;
	
	private int errorCode;//错误代码
	
	
	public LogicException(String msg){
		super(msg);
	}
	

	public LogicException(int errorCode) {
		super();
		this.errorCode = errorCode;
	}


	public LogicException() {
		super();
	}


	public LogicException(String msg,int errorCode) {
		super(msg);
		this.errorCode = errorCode;
	}
}
