package com.commscope.bu.exceptionHandler;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Request Error Data class for the validating the request
 * @author RT1050
 *
 */
public class ExceptionResponse extends ExceptionDTO{
	private String timestamp;
	private String message;
	private String details;
	private String fieldName;
	private String action;
	
	public ExceptionResponse( String message, String details) {
		super();
		this.message = message;
		this.details = details;
	}

	public ExceptionResponse(String fieldName, String details,String message) {
		super();
		this.fieldName = fieldName;
		this.details = details;
		this.message=message;
	}

	
	public String getTimestamp() {
		 return  new SimpleDateFormat("MM-dd-yyyy").format(new Date());
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}


	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fieldName == null) ? 0 : fieldName.hashCode());
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
		ExceptionResponse other = (ExceptionResponse) obj;
		if (fieldName == null) {
			if (other.fieldName != null)
				return false;
		} else if (!fieldName.equals(other.fieldName))
			return false;
		return true;
	}

	

}
