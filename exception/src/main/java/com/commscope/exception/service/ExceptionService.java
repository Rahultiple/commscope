package com.commscope.exception.service;

import java.util.HashMap;
import java.util.Map;

import com.commscope.exception.constants.ExceptionConstants;
import com.commscope.exception.model.ErrorData;
import com.commscope.exception.model.ExceptionDTO;
import com.commscope.exception.model.ResponseDTO;

/**
 * This response class which is used for the Creating the response 
 * @author RT1050
 *
 */
public abstract class ExceptionService {
	
	public ResponseDTO createSuccessResponseDto(){
		
		HashMap<String,? extends ExceptionDTO> map = new HashMap<>();
		ResponseDTO dto= new ResponseDTO();
		dto.setCode(ExceptionConstants.HTTP_STATUS_CODES_MAP.get("SUCCESS"));
		dto.setStatus(ExceptionConstants.StatusCodes.SUCCESS);
		dto.setData(map);
		return dto;
	}
	public ResponseDTO createSuccessResponseDto(Map<String, ? extends ExceptionDTO> data){
				
		ResponseDTO dto= new ResponseDTO();
		dto.setCode(ExceptionConstants.HTTP_STATUS_CODES_MAP.get(ExceptionConstants.StatusCodes.SUCCESS));
		dto.setStatus(ExceptionConstants.StatusCodes.SUCCESS);
		dto.setData(data);
		return dto;
	}
	@SuppressWarnings("rawtypes")
	public ResponseDTO createSuccessResponseDto(ErrorData errorData){
		Map<String, ErrorData> mapErrorData = new HashMap<String, ErrorData>();
		mapErrorData.put("exceptionData", errorData);
		ResponseDTO createSuccessResponseDto = createSuccessResponseDto(mapErrorData);
		return createSuccessResponseDto;
	}
	
}
