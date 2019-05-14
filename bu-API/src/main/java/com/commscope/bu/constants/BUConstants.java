package com.commscope.bu.constants;

import java.util.HashMap;
import java.util.Map;
/**
 * These are the global constants used in Application 
 * @author RT1050
 *
 */
public class BUConstants {
	public static ThreadLocal<String> threadLocal= new ThreadLocal<String>();
	
	public static final Map<String, String> HTTP_STATUS_CODES_MAP = httpStatusCodesMap();
	@SuppressWarnings("unused")
	private static Map<String, String> httpStatusCodesMap() {

		Map<String, String> httpStatusCodes = new HashMap<>();

		httpStatusCodes.put("SUCCESS", "200");
		httpStatusCodes.put("BAD_REQUEST", "400"); //Input Validation Code
		httpStatusCodes.put("FAILED_SYSTEM_VALIDATION", "676"); //Input Validation Code
		return httpStatusCodes;
	}
	
	 public static interface StatusCodes{
		 public String SUCCESS="SUCCESS";
		 public String BAD_REQUEST="BAD_REQUEST";
		 public String SYSTEM_FAILURE="FAILED_SYSTEM_VALIDATION";
	 }
	 public static enum  EmptyNullFields{
		
		 EMPTY_FIELDS("NotEmpty"),
		 NULL_FIELDS("NotNull"),
		 DEFAULT("");
		 private String constriantfieldValue; 
		 private String outputMessage="#0# Input Field is Empty or Missing"; 
		 
		 
		 EmptyNullFields(String constraintStr){
			 this.constriantfieldValue=constraintStr;
		 }
		 public String fieldValue() {
			 return this.constriantfieldValue;
		 }
		 public String outputMessageValue(String fieldVal) {
			
			 return  outputMessage.replace("#0#", fieldVal);
		 }
	 }
	 public static enum  DATE_FORMAT_VALIDATOR{
		
		 WRONG_FORMAT("DateValidatorIntf"),
		 DEFAULT("");
		 private String constriantfieldValue; 
		// private String outputMessage="#0#  is not in yyyy-MM-dd format"; 
		 private String outputMessage="#0# is not in a valid format or valid date as expected for #1# - Expected Format == yyyy-MM-dd";
		 
		 DATE_FORMAT_VALIDATOR(String constraintStr){
			 this.constriantfieldValue=constraintStr;
		 }
		 public String fieldValue() {
			 return this.constriantfieldValue;
		 }
		 public String outputMessageValue(String dateValue,String fieldVal) {
			 outputMessage= outputMessage.replace("#0#", dateValue);
			 outputMessage=outputMessage.replace("#1#", fieldVal);
			 return  outputMessage;
		 }
	 }
	 
	 public static String inputValidationFieldMessage="Something went wrong";
}