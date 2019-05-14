package com.commscope.bu.model;

import java.util.Date;

public class ReadExcelDTO{
	private String senderID;
	private String transactionType;
	private String responseType;
	private String createdById;
	private java.util.Date dateCellValue;
	private String responseMessage;
	private String source;
	private String idNumber;
	public ReadExcelDTO(String senderID,String source ,String transactionType, String responseType,String idNumber, String createdById,Date dateCellValue) {
		super();
		this.senderID = senderID;
		this.transactionType = transactionType;
		this.responseType = responseType;
		this.createdById = createdById;
		this.dateCellValue = dateCellValue;
		this.source=source;
		this.idNumber=idNumber;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getSenderID() {
		return senderID;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public void setSenderID(String senderID) {
		this.senderID = senderID;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getResponseType() {
		return responseType;
	}

	public void setResponseType(String responseType) {
		this.responseType = responseType;
	}

	public String getCreatedById() {
		return createdById;
	}

	public void setCreatedById(String createdById) {
		this.createdById = createdById;
	}

	public java.util.Date getDateCellValue() {
		return dateCellValue;
	}

	public void setDateCellValue(java.util.Date dateCellValue) {
		this.dateCellValue = dateCellValue;
	}
	
}
