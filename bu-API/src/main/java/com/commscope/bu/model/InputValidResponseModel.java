package com.commscope.bu.model;

import java.util.Map;

import com.commscope.bu.exceptionHandler.ExceptionDTO;




public class InputValidResponseModel {
	
	private String statusCode;
	
	private String statusMSG;
	
	private Map<String,? extends ExceptionDTO> data;

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusMSG() {
		return statusMSG;
	}

	public void setStatusMSG(String statusMSG) {
		this.statusMSG = statusMSG;
	}

	public Map<String, ? extends ExceptionDTO> getData() {
		return data;
	}

	public void setData(Map<String, ? extends ExceptionDTO> data) {
		this.data = data;
	}

	
	
	

}
