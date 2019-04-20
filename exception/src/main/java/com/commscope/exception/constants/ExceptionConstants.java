package com.commscope.exception.constants;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Global constants which are used in Application 
 * @author RT1050
 *
 */
public final class ExceptionConstants {

	
	public static final List<String> TI_HD_PROD_LIST = new ArrayList<>(Arrays.asList(new String[] { "AD", "BF" }));
	public static final Map<String, String> HTTP_STATUS_CODES_MAP = httpStatusCodesMap();
	@SuppressWarnings("unused")
	private static Map<String, String> httpStatusCodesMap() {

		Map<String, String> httpStatusCodes = new HashMap<>();

		httpStatusCodes.put("SUCCESS", "200");
		httpStatusCodes.put("FAILED_INPUT_VALIDATION", "675"); //Input Validation Code
		httpStatusCodes.put("FAILED_SYSTEM_VALIDATION", "676"); //Input Validation Code
		return httpStatusCodes;
	}
	
	 public static interface StatusCodes{
		 public String SUCCESS="SUCCESS";
		 public String FAILED_INPUT_VALIDATION="FAILED_INPUT_VALIDATION";
		 public String SYSTEM_FAILURE="FAILED_SYSTEM_VALIDATION";
	 }
}
