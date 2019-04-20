package com.commscope.exception.service;

import org.springframework.stereotype.Service;

import com.commscope.exception.model.AuditDTO;
import com.commscope.exception.model.NotificationDTO;
import com.commscope.exception.model.ReadExcelDTO;
import com.commscope.exception.model.RequestJsonCreateExcelMessage;
import com.commscope.exception.model.RequestJsonMessage;
import com.commscope.exception.model.ResponseDTO;


// This class is HelloController to map the get service

@Service
public interface ExceptionServiceIntf {
	public ResponseDTO processException(RequestJsonMessage reqMsg) throws Exception;
	public AuditDTO callAuditFramework(String auditMSG,String responseType,RequestJsonMessage reqMsg);
	public NotificationDTO callNotificationFramework(RequestJsonMessage reqMsg, ReadExcelDTO readExcelDetails, String ticketNo,
			NotificationDTO notificationDto);
	public ResponseDTO readErrorCodesFromExcel() throws Exception;
	public ResponseDTO updateErrorCodesFromExcel(RequestJsonCreateExcelMessage reqMsg) throws Exception;
	public ResponseDTO insertErrorCodesFromExcel(RequestJsonCreateExcelMessage inputJsonExcel) throws Exception;
	public ResponseDTO deleteErrorCodesFromExcel(String internalErrorCode) throws Exception;
}
