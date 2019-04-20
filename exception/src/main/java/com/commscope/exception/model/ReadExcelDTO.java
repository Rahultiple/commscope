package com.commscope.exception.model;

public class ReadExcelDTO extends ExceptionDTO{
	private String internalErrorCode;
	private String errorType;
	private String exceptionMessage;
	private String level;
	
	
	public ReadExcelDTO(String internalErrorCode, String errorType, String exceptionMessage, String level) {
		super();
		this.internalErrorCode = internalErrorCode;
		this.errorType = errorType;
		this.exceptionMessage = exceptionMessage;
		this.level = level;
	}
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((internalErrorCode == null) ? 0 : internalErrorCode.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReadExcelDTO other = (ReadExcelDTO) obj;
		if (internalErrorCode == null) {
			if (other.internalErrorCode != null)
				return false;
		} else if (!internalErrorCode.equals(other.internalErrorCode))
			return false;
		return true;
	}
	
	
	
}
