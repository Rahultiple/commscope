package com.commscope.bu.exceptionHandler;

import org.springframework.core.MethodParameter;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;

public class TestMethodArgumentNotValidException extends MethodArgumentNotValidException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String argumentValue; 
	
	public TestMethodArgumentNotValidException(MethodParameter parameter, BindingResult bindingResult) {
		super(parameter, bindingResult);
		// TODO Auto-generated constructor stub
	}
	public String getArgumentValue() {
		return argumentValue;
	}
	public void setArgumentValue(String argumentValue) {
		this.argumentValue = argumentValue;
	}
	
}
