package com.commscope.exception.model;

import java.util.Map;

/**
 * This is DTO having wrapped response having the data for the Customer 
 * @author RT1050
 *@since 8-Feb-2019
 */
public class ResponseDTO  {
	private String status;
	private String code;
	private Map<String,? extends ExceptionDTO> data;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Map<String, ? extends ExceptionDTO> getData() {
		return data;
	}
	public void setData(Map<String, ? extends ExceptionDTO> data) {
		this.data = data;
	}
	
}
