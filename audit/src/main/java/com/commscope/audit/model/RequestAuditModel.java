package com.commscope.audit.model;

import javax.validation.constraints.NotEmpty;

/*
 * This Input request model class
 */

public class RequestAuditModel {
	
	@NotEmpty(message="senderId is mandatory")
	private String senderID;
	
	@NotEmpty(message="transactionType is mandatory")
	private String transactionType;
	
	@NotEmpty(message="responseType is mandatory")
	private String responseType;
	
	@NotEmpty(message="responseMSG is mandatory")
	private String responseMSG;
	
	@NotEmpty(message="idNumber is mandatory")
	private String idNumber ;

	private String sourceName ;
	
	private String created_by;
	
	private String created_date;

	private String start_date;
	
	private String end_date;


	
	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public String getSenderID() {
		return senderID;
	}

	public void setSenderID(String senderID) {
		this.senderID = senderID;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transType) {
		this.transactionType = transType;
	}

	public String getResponseType() {
		return responseType;
	}

	public void setResponseType(String responseType) {
		this.responseType = responseType;
	}

	public String getResponseMSG() {
		return responseMSG;
	}

	public void setResponseMSG(String responseMSG) {
		this.responseMSG = responseMSG;
	}

	public String getCreated_by() {
		return created_by;
	}

	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}

	public String getCreated_date() {
		return created_date;
	}

	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}

	public String getSourceName() {
		return sourceName;
	}

	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	@Override
	public String toString() {
		return "RequestAuditModel [senderID=" + senderID + ", transactionType=" + transactionType + ", responseType="
				+ responseType + ", responseMSG=" + responseMSG + ", sourceName=" + sourceName + ", created_by="
				+ created_by + ", created_date=" + created_date + ", start_date=" + start_date + ", end_date="
				+ end_date + "]";
	}

	
	
	
	
	

}
