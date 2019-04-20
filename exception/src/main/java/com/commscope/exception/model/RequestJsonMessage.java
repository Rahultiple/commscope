package com.commscope.exception.model;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement
public class RequestJsonMessage implements InputValidatorIntf{
	
	@NotNull(message="Error_Msg is not blank or missing")
    @NotBlank(message="Error_Msg is not blank or missing")
	@JsonProperty(value="Error_Msg" )
	private String  errorMsg ; //- Required
	
	@NotNull(message="Error_Code is not blank or missing")
    @NotBlank(message="Error_Code is not blank or missing")
	@JsonProperty(value="Error_Code")
	private String  errorCode ; //- Required
	
	@NotNull(message="Error_Type is not blank or missing")
    @NotBlank(message="Error_Type is not blank or missing ")
	@JsonProperty(value="Error_Type")
	private String errorType ;//- Required

	@NotBlank(message="Message_Body is not blank or missing ")
	@JsonProperty(value="Message_Body")
	private String messageBody;
	
	@NotNull(message="Sender_Id is not blank or missing")
    @NotBlank(message="Sender_Id is not blank or missing ")
	@JsonProperty(value="Sender_Id")
	private String senderId;
	
	@NotNull(message="Trans_Type is not blank or missing")
    @NotBlank(message="Trans_Type is not blank or missing ")
	@JsonProperty(value="Trans_Type")
	private String transType;
	
	@NotNull(message="Recipient_ID is not blank or missing")
    @NotBlank(message="Recipient_ID is not blank or missing ")
	@JsonProperty(value="Recipient_ID")
	private String recipientID;
	
	
	@NotNull(message="Id_Number is not blank or missing")
    @NotBlank(message="Id_Number is not blank or missing ")
	@JsonProperty(value="Id_Number")
	private String idNumber;

	
	@JsonProperty(value="source_name")
	private String sourceName;
	
	
	public String getSourceName() {
		return sourceName;
	}
	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorType() {
		return errorType;
	}
	public void setErrorType(String errorType) {
		this.errorType = errorType;
	}
	public String getMessageBody() {
		return messageBody;
	}
	public void setMessageBody(String messageBody) {
		this.messageBody = messageBody;
	}
	public String getSenderId() {
		return senderId;
	}
	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}
	public String getTransType() {
		return transType;
	}
	public void setTransType(String transType) {
		this.transType = transType;
	}
	
	public String getRecipientID() {
		return recipientID;
	}
	public void setRecipientID(String recipientID) {
		this.recipientID = recipientID;
	}
	
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	@Override
	public String toString() {
		return "RequestJsonMessage [errorCode=" + errorCode + ", errorType=" + errorType + ", messageBody="
				+ messageBody + ", senderId=" + senderId + ", transType=" + transType + ", recipientID=" + recipientID+" , idNumber=" + idNumber+"]";
	}
	
}
