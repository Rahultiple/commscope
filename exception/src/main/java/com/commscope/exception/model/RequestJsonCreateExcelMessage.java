package com.commscope.exception.model;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement
public class RequestJsonCreateExcelMessage implements InputValidatorIntf{
	
	@NotNull(message="Internal_Error_Code is not blank or missing")
    @NotBlank(message="Internal_Error_Code is not blank or missing")
	@JsonProperty(value="Internal_Error_Code" )
	private String  internalErrorCode ; //- Required
				
	@NotNull(message="Error_Type is not blank or missing")
    @NotBlank(message="Error_Type is not blank or missing ")
	@JsonProperty(value="Error_Type")
	private String errorType ;//- Required

	@NotBlank(message="Exception_Message is not blank or missing ")
	@JsonProperty(value="Exception_Message")
	private String exceptionMessage;


	@NotNull(message="Level is not blank or missing")
    @NotBlank(message="Level is not blank or missing ")
	@JsonProperty(value="Level")
	private String level;
	
	
	public String getInternalErrorCode() {
		return internalErrorCode;
	}

	public void setInternalErrorCode(String internalErrorCode) {
		this.internalErrorCode = internalErrorCode;
	}

	public String getErrorType() {
		return errorType;
	}

	public void setErrorType(String errorType) {
		this.errorType = errorType;
	}

	public String getExceptionMessage() {
		return exceptionMessage;
	}

	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}
	
	@Override
	public String toString() {
		return "RequestJsonCreateExcelMessage [internalErrorCode=" + internalErrorCode + ", errorType=" + errorType
				+ ", exceptionMessage=" + exceptionMessage + ", level=" + level + "]";
	}
	
	
}
