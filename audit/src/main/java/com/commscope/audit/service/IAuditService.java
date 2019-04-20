package com.commscope.audit.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.commscope.audit.model.ReadExcelDTO;
import com.commscope.audit.model.RequestAuditModel;
import com.commscope.audit.model.ResponseAuditModel;

public interface IAuditService {
	
	public ResponseAuditModel forAuditingService(RequestAuditModel request);
	public List<ReadExcelDTO> readAuditInfo(RequestAuditModel request) throws EncryptedDocumentException, InvalidFormatException, IOException,ParseException;

}
