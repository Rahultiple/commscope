package com.commscope.exception.model;

/**
 * This DTO is used to send message to Notification Service so its wrapped data inside in it
 * @author RT1050
 *@since 8-Feb-2019
 */
public class NotificationDTO extends ExceptionDTO {
	private String senderID ; //- Required
	private String recipientID ;//- Required
	private String errorType ; //- Required
	private String errorMSG;  //- Required
	private String transType; //- Required
	private String messageType ; //- Required
	private String sourceName ; //- Optional
	private String messageBody ;//- Required
	private String subject ;//- Required
	private String idNumber;//- Required
	
	public String getSenderID() {
		return senderID;
	}
	public void setSenderID(String senderID) {
		this.senderID = senderID;
	}
	public String getRecipientID() {
		return recipientID;
	}
	public void setRecipientID(String recipientID) {
		this.recipientID = recipientID;
	}
	
	public String getErrorType() {
		return errorType;
	}
	public void setErrorType(String errorType) {
		this.errorType = errorType;
	}
	public String getErrorMSG() {
		return errorMSG;
	}
	public void setErrorMSG(String errorMSG) {
		this.errorMSG = errorMSG;
	}
	public String getTransType() {
		return transType;
	}
	public void setTransType(String transType) {
		this.transType = transType;
	}
	public String getMessageType() {
		return messageType;
	}
	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}
	public String getSourceName() {
		return sourceName;
	}
	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}
	public String getMessageBody() {
		return messageBody;
	}
	public void setMessageBody(String messageBody) {
		this.messageBody = messageBody;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	@Override
	public String toString() {
		return "NotificationDTO [senderID=" + senderID + ", recipientID=" + recipientID + ", errorType=" + errorType
				+ ", errorMSG=" + errorMSG + ", transType=" + transType + ", messageType=" + messageType
				+ ", sourceName=" + sourceName + ", messageBody=" + messageBody + ", subject=" + subject + " , idNumber=" + idNumber + "]";
	}
}
