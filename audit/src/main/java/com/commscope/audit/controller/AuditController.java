package com.commscope.audit.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.commscope.audit.exceptionHandler.InputRequestValidator;
import com.commscope.audit.model.ReadExcelDTO;
import com.commscope.audit.model.RequestAuditModel;
import com.commscope.audit.model.ResponseAuditModel;
import com.commscope.audit.service.IAuditService;
/**
 * Centralized Control class used for the All request which are gathered here for the processing its input and produces the o/p
 * @author RT1050
 *
 */
@CrossOrigin
@RestController
public class AuditController {
	private static final Logger logger = LogManager.getLogger(AuditController.class);
	@Autowired
	IAuditService auditService;
	
	@RequestMapping(value="/API_AUDIT", method=RequestMethod.POST)
	public ResponseAuditModel forAuditing(@Valid @RequestBody RequestAuditModel audit ) {
		
		ResponseAuditModel ram=new ResponseAuditModel();		
		ram=auditService.forAuditingService(audit);
				
		return ram;
	}
	@RequestMapping(value="/API_AUDIT_GET_EXCEL", method=RequestMethod.POST)
	public ResponseAuditModel getAuditInfo(@RequestBody RequestAuditModel audit ) {
		logger.info("Input Request Parameters:->"+audit.toString());
		ResponseAuditModel responesAuditModel=new ResponseAuditModel();		
		try {
			if ((audit.getStart_date() != null) || (audit.getEnd_date() != null)) {
				//either start date or end date will be null 
				if(audit.getStart_date() == null) {
					responesAuditModel.setStatusCode("900");
					responesAuditModel.setStatusMSG("Check input start_date and end_date with format yyyy-MM-dd");
					return responesAuditModel;
				}
				if(audit.getEnd_date()== null) {
					responesAuditModel.setStatusCode("900");
					responesAuditModel.setStatusMSG("Check input start_date and end_date with format yyyy-MM-dd");
					return responesAuditModel;
				}
			}
			if((audit.getStart_date() !=null) && (audit.getEnd_date() !=null))  {
				 try {
					SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
					ft.setLenient(false);
					ft.parse(audit.getStart_date());
					ft.parse(audit.getEnd_date());
				 }catch (ParseException e) {
					// TODO: handle exception
					responesAuditModel.setStatusCode("900");
					responesAuditModel.setStatusMSG("Check input start_date and end_date with format yyyy-MM-dd");
					return responesAuditModel;
				 }	
				
			}
			List<ReadExcelDTO> readAuditInfoList = auditService.readAuditInfo(audit);
			responesAuditModel.setListExcelMessage(readAuditInfoList);
			responesAuditModel.setStatusCode("200");
			responesAuditModel.setStatusMSG("Success");

		} catch (Exception e) {
			// TODO: handle exception
			logger.error("Error Happen in AuditController ,getAuditInfo {}"+e);
			responesAuditModel.setStatusCode("700");
			responesAuditModel.setStatusMSG("FAILURE");

		}
		return responesAuditModel;
	}

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
	    binder.setValidator(new InputRequestValidator());
	}
	
}
