package com.commscope.audit.exceptionHandler;

import java.util.Map;
import java.util.Set;


/**
 * Request Error Data class for the validating the request
 * @author RT1050
 *
 */
public class ErrorData extends ExceptionDTO {
	private Map<String,String> response;
	private Map<String,Set<ExceptionResponse>> inputValidationResponse;
	public Map<String, String> getResponse() {
		return response;
	}

	public void setResponse(Map<String, String> response) {
		this.response = response;
	}

	public Map<String, Set<ExceptionResponse>> getInputValidationResponse() {
		return inputValidationResponse;
	}

	public void setInputValidationResponse(Map<String, Set<ExceptionResponse>> inputValidationResponse) {
		this.inputValidationResponse = inputValidationResponse;
	}

	
	
}
