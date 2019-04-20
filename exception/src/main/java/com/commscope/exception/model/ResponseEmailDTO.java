package com.commscope.exception.model;

public class ResponseEmailDTO {
	
	private String statusCode;
	
	private String statusMSG;

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

	@Override
	public String toString() {
		return "ResponseEmailDTO [statusCode=" + statusCode + ", statusMSG=" + statusMSG + "]";
	}

	
	
	

}
