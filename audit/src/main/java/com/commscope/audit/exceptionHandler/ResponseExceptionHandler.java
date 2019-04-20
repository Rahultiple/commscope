package com.commscope.audit.exceptionHandler;


import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.commscope.audit.constants.AuditConstants;
import com.commscope.audit.model.InputValidResponseModel;


/**
 * This class is used to handle the Exception Wrapped to Exception object 
 * @author VV1028
 * @since  3/18/2019
 */
@ControllerAdvice
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {	
	
	  @Override
	  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
	      HttpHeaders headers, HttpStatus status, WebRequest request) {
	
		  List<ObjectError> errorMap = ex.getBindingResult().getAllErrors();
		  Set<ExceptionResponse> inputResposeList= new HashSet<ExceptionResponse>();
			for (ObjectError objeError : errorMap) {
				ExceptionResponse exceptionResponse = new ExceptionResponse(objeError.getCode(),
						objeError.getDefaultMessage(), "Input Field Missing Error");
				inputResposeList.add(exceptionResponse);
			}
			
			ErrorData data= new ErrorData();
			Map<String, Set<ExceptionResponse>> map = new HashMap<String, Set<ExceptionResponse>>();
			map.put("Input Missing Parameter List", inputResposeList);
			data.setInputValidationResponse(map);
			
			Map<String, ErrorData> mapErrorData = new HashMap<String, ErrorData>();
			mapErrorData.put("Error-Data", data);
			InputValidResponseModel responseDtoForFailedRequest = createResponseForFailedInputResponseDto(mapErrorData);
		  
	    return new ResponseEntity(responseDtoForFailedRequest, HttpStatus.BAD_REQUEST);
	  } 
	  private InputValidResponseModel createResponseForFailedInputResponseDto(Map<String, ? extends ExceptionDTO> data){
			
		  InputValidResponseModel dto= new InputValidResponseModel();
			dto.setStatusCode(AuditConstants.HTTP_STATUS_CODES_MAP.get(AuditConstants.StatusCodes.BAD_REQUEST));
			dto.setStatusMSG(AuditConstants.StatusCodes.BAD_REQUEST);
			dto.setData(data);
			return dto;
		}
	  

}

