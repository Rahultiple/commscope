package com.commscope.audit.model;

import java.util.List;

/*
 * This Input request model class
 */

public class ResponseAuditModel {
	
	private String statusCode;
	
	private String statusMSG;
	
	private List<ReadExcelDTO> listExcelMessage;	

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

	public List<ReadExcelDTO> getListExcelMessage() {
		return listExcelMessage;
	}

	public void setListExcelMessage(List<ReadExcelDTO> listExcelMessage) {
		this.listExcelMessage = listExcelMessage;
	}

}
