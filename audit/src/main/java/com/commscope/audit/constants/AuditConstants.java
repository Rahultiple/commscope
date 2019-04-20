package com.commscope.audit.constants;

import java.util.HashMap;
import java.util.Map;
/**
 * These are the global constants used in Application 
 * @author RT1050
 *
 */
public class AuditConstants {

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

}