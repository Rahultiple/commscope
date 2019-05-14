package com.commscope.bu.exceptionHandler;


import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.commscope.bu.constants.BUConstants;
import com.commscope.bu.model.InputValidResponseModel;


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
				System.out.println("Code=>"+objeError.getCode());
				System.out.println("Code=>"+objeError.getCodes());
				System.out.println("fieldValueCode=>"+objeError.getCodes()[1].replace(objeError.getCodes()[objeError.getCodes().length-1]+".", ""));
				System.out.println("unwrap=>"+objeError.toString());
				String filedName=objeError.getDefaultMessage();
				if(filedName.contains(" ")) {
					//default message is comming due to missed input field
					filedName=objeError.getCodes()[objeError.getCodes().length-3].replace(objeError.getCodes()[objeError.getCodes().length-1]+".", "");
				}
				
				String finalmessage=createMessage(objeError.getCodes(),filedName,objeError.toString());
				
				String detailedFiledName=objeError.getCodes()[1].replace(objeError.getCodes()[objeError.getCodes().length-1]+".", "");
				detailedFiledName="Details  in ::  "+detailedFiledName.replace(".", " => ");
				ExceptionResponse exceptionResponse = new ExceptionResponse(filedName,detailedFiledName, finalmessage);
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
	  private String getValueForDate(String val) {
		  String str=val.split(";")[0];
		  return str.split(":")[1];
	  }
	  private String createMessage(String[] codes,String fieldName,String value) {
		  
		 List<String> collect = Arrays.asList(codes).stream().filter(new Predicate<String>() {

			@Override
			public boolean test(String t) {
				// TODO Auto-generated method stub
				if(t.contains(BUConstants.EmptyNullFields.EMPTY_FIELDS.fieldValue()) || t.contains(BUConstants.EmptyNullFields.NULL_FIELDS.fieldValue())
						|| t.contains(BUConstants.DATE_FORMAT_VALIDATOR.WRONG_FORMAT.fieldValue())) return true;
				return false;
			}
		 
		 }).collect(Collectors.toList());
		
			 if(collect.get(0).contains(BUConstants.EmptyNullFields.EMPTY_FIELDS.fieldValue()) ||collect.get(0).contains(BUConstants.EmptyNullFields.NULL_FIELDS.fieldValue())) {
				 return BUConstants.EmptyNullFields.DEFAULT.outputMessageValue(fieldName);
			 }
			if(collect.get(0).contains(BUConstants.DATE_FORMAT_VALIDATOR.WRONG_FORMAT.fieldValue())) {
				//String value=BUConstants.threadLocal.get();
				 String dateValue=getValueForDate(value);
				//BUConstants.threadLocal.remove();
				return BUConstants.DATE_FORMAT_VALIDATOR.DEFAULT.outputMessageValue(dateValue,fieldName);
			}
			
	
		 return BUConstants.inputValidationFieldMessage;
	  }
	  private InputValidResponseModel createResponseForFailedInputResponseDto(Map<String, ? extends ExceptionDTO> data){
			
		  InputValidResponseModel dto= new InputValidResponseModel();
			dto.setStatusCode(BUConstants.HTTP_STATUS_CODES_MAP.get(BUConstants.StatusCodes.BAD_REQUEST));
			dto.setStatusMSG(BUConstants.StatusCodes.BAD_REQUEST);
			dto.setData(data);
			return dto;
		}
	  

}

