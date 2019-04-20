package com.commscope.exception.model;

import java.util.Map;
import java.util.Set;

import com.commscope.exception.handleException.ExceptionResponse;

public class ErrorData<T> extends ExceptionDTO {
	private Map<String,T> response;
	private Map<String,Set<ExceptionResponse>> inputValidationResponse;
	
	public ErrorData() {
		
	}
	
	public ErrorData(Map<String, T> response) {
		super();
		this.response = response;
	}

	public Map<String, T> getResponse() {
		return response;
	}

	public void setResponse(Map<String, T> response) {
		this.response = response;
	}

	public Map<String, Set<ExceptionResponse>> getInputValidationResponse() {
		return inputValidationResponse;
	}

	public void setInputValidationResponse(Map<String, Set<ExceptionResponse>> inputValidationResponse) {
		this.inputValidationResponse = inputValidationResponse;
	}

	
	
}
