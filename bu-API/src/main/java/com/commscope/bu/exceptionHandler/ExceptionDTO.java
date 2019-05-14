package com.commscope.bu.exceptionHandler;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public abstract  class ExceptionDTO {
	
	private String generalExceptionString;

	public String getGeneralExceptionString() {
		return generalExceptionString==null?"":generalExceptionString;
		
	}

	public void setGeneralExceptionString(String generalExceptionString) {
		this.generalExceptionString = generalExceptionString;
	}
	
}
