package com.commscope.exception.handleException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.commscope.exception.constants.ExceptionConstants;
import com.commscope.exception.model.ErrorData;
import com.commscope.exception.model.ExceptionDTO;
import com.commscope.exception.model.ResponseDTO;

/**
 * This class is used to handle the Exception Wrapped to Exception object 
 * @author RT1050
 * @since  2/11/2019
 */
@ControllerAdvice
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

	
	 /* @ExceptionHandler(StudentNotFoundException.class)
	  public final ResponseEntity<Object> handleUserNotFoundException(StudentNotFoundException ex, WebRequest request) {
	    ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
	        request.getDescription(false));
	    return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
	  }*/
		
	  @ExceptionHandler(Exception.class)
	  public final ResponseEntity<Object> handleSystemException(Exception ex, WebRequest request) {
	    ExceptionResponse exceptionResponse = new ExceptionResponse( "System Exception",ex.toString());
	    exceptionResponse.setAction("Please Try Again Later");
		Map<String, ExceptionResponse> mapErrorData = new HashMap<String, ExceptionResponse>();
	
		mapErrorData.put("exceptionData", exceptionResponse);
		ResponseDTO responseDtoForFailedRequest = createResponseForFailedSystemResponseDto(mapErrorData);
	    return new ResponseEntity(responseDtoForFailedRequest, HttpStatus.INTERNAL_SERVER_ERROR);
	  }
	  @ExceptionHandler(CustomException.class)
	  public final ResponseEntity<Object> handleApplicationException(Exception ex, WebRequest request) {
	    ExceptionResponse exceptionResponse = new ExceptionResponse( "Application Exception",ex.toString());
	    exceptionResponse.setAction("Please Try Again Later");
		Map<String, ExceptionResponse> mapErrorData = new HashMap<String, ExceptionResponse>();
	
		mapErrorData.put("exceptionData", exceptionResponse);
		ResponseDTO responseDtoForFailedRequest = createResponseForFailedInputResponseDto(mapErrorData);
	    return new ResponseEntity(responseDtoForFailedRequest, HttpStatus.EXPECTATION_FAILED);
	  }
	  @Override
	  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
	      HttpHeaders headers, HttpStatus status, WebRequest request) {
	
		  List<ObjectError> errorMap = ex.getBindingResult().getAllErrors();
		  Set<ExceptionResponse> inputResposeList= new HashSet<ExceptionResponse>();
			for (ObjectError objeError : errorMap) {
				ExceptionResponse exceptionResponse = new ExceptionResponse(objeError.getCode(),
						objeError.getDefaultMessage(), "Input Validation Failed");
				inputResposeList.add(exceptionResponse);
			}
			
			ErrorData data= new ErrorData();
			Map<String, Set<ExceptionResponse>> map = new HashMap<String, Set<ExceptionResponse>>();
			map.put("Input Parameter List", inputResposeList);
			data.setInputValidationResponse(map);
			
			Map<String, ErrorData> mapErrorData = new HashMap<String, ErrorData>();
			mapErrorData.put("errorData", data);
		  /*ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), "Validation Failed",
	        ex.getBindingResult().toString());*/
			ResponseDTO responseDtoForFailedRequest = createResponseForFailedInputResponseDto(mapErrorData);
		  
	    return new ResponseEntity(responseDtoForFailedRequest, HttpStatus.BAD_REQUEST);
	  } 
	  private ResponseDTO createResponseForFailedInputResponseDto(Map<String, ? extends ExceptionDTO> data){
			
			ResponseDTO dto= new ResponseDTO();
			dto.setCode(ExceptionConstants.HTTP_STATUS_CODES_MAP.get(ExceptionConstants.StatusCodes.FAILED_INPUT_VALIDATION));
			dto.setStatus(ExceptionConstants.StatusCodes.FAILED_INPUT_VALIDATION);
			dto.setData(data);
			return dto;
		}
	  private ResponseDTO createResponseForFailedSystemResponseDto(Map<String, ? extends ExceptionDTO> data){
			
			ResponseDTO dto= new ResponseDTO();
			dto.setCode(ExceptionConstants.HTTP_STATUS_CODES_MAP.get(ExceptionConstants.StatusCodes.SYSTEM_FAILURE));
			dto.setStatus(ExceptionConstants.StatusCodes.SYSTEM_FAILURE);
			dto.setData(data);
			return dto;
		}

}

