package com.commscope.exception.controller;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.commscope.exception.handleException.InputRequestValidator;
import com.commscope.exception.model.RequestJsonCreateExcelMessage;
import com.commscope.exception.model.RequestJsonMessage;
import com.commscope.exception.model.ResponseDTO;
import com.commscope.exception.service.ExceptionServiceIntf;


/**
 * 
* Its centralized contolled the front controller for the All request . 
 *@author RT1050
 *@since 8-Feb-2019
 *
 */
@CrossOrigin
@RestController

public class ExceptionController {
	
	private static final Logger logger = LogManager.getLogger(ExceptionController.class);
	@Autowired
	ExceptionServiceIntf service;
	
	@Value("${start.url}")
	private String url;
	
	
	
	@GetMapping(value = "/helloFromWebApp")
	public String hello() {
		 return "Hello World from Azure Web App API";
	}
		   
	@PostMapping(value = "/API_ERROR")
	public ResponseDTO apiError(@Valid @RequestBody RequestJsonMessage reqMsg) throws Exception {
		logger.info("reqMsgDto-> "+reqMsg);
		ResponseDTO processException = service.processException(reqMsg);
		return processException;
	}
	
	@GetMapping(value = "/API_READ_ERROR_CODES")
	public ResponseDTO apiReadErrorCodes() throws Exception {
		ResponseDTO processException = service.readErrorCodesFromExcel();
		return processException;
	}
	@PostMapping(value = "/API_INSERT_ERROR_CODES")
	public ResponseDTO apiInsertErrorCodes(@Valid @RequestBody RequestJsonCreateExcelMessage  reqMsg) throws Exception {
		ResponseDTO processException = service.insertErrorCodesFromExcel(reqMsg);
		return processException;
	}
	@PostMapping(value = "/API_UPDATE_ERROR_CODES")
	public ResponseDTO apiUpdateErrorCodes(@Valid @RequestBody RequestJsonCreateExcelMessage  reqMsg) throws Exception {
		ResponseDTO processException = service.updateErrorCodesFromExcel(reqMsg);
		return processException;
	}
	@GetMapping(value = "/API_DELETE_ERROR_CODES")
	public ResponseDTO apiDeleteErrorCodes(@RequestParam("internalErrorCode") String internalErrorCode) throws Exception {
		ResponseDTO processException = service.deleteErrorCodesFromExcel(internalErrorCode);
		return processException;
	}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
	    binder.setValidator(new InputRequestValidator());
	}

}
