package com.commscope.exception.model;

/**
 * This DTO is used to send message to Notification Service so its wrapped data inside in it
 * @author RT1050
 *@since 8-Feb-2019
 */
public class AuditDTO extends ExceptionDTO {
	private String created_by ; //- Required
	private String created_date ;//- Required
	private String responseMSG ; //- Required
	private String responseType ; //- Optional
	private String senderID ; //- Required
	private String sourceName;  //- Required
	private String transactionType; //- Required
	private String idNumber;//- Required
	
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
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
	public String getResponseMSG() {
		return responseMSG;
	}
	public void setResponseMSG(String responseMSG) {
		this.responseMSG = responseMSG;
	}
	public String getResponseType() {
		return responseType;
	}
	public void setResponseType(String responseType) {
		this.responseType = responseType;
	}
	public String getSenderID() {
		return senderID;
	}
	public void setSenderID(String senderID) {
		this.senderID = senderID;
	}
	public String getSourceName() {
		return sourceName;
	}
	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}

	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	@Override
	public String toString() {
		return "AuditDTO [created_by=" + created_by + ", created_date=" + created_date + ", responseMSG=" + responseMSG
				+ ", responseType=" + responseType + ", senderID=" + senderID + ", sourceName=" + sourceName
				+ ", transactionType=" + transactionType + ", idNumber=" + idNumber +" ]";
	}
	
	
	
}
