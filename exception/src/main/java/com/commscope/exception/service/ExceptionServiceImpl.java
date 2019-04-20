package com.commscope.exception.service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Predicate;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.commscope.exception.handleException.CustomException;
import com.commscope.exception.model.AuditDTO;
import com.commscope.exception.model.ErrorData;
import com.commscope.exception.model.NotificationDTO;
import com.commscope.exception.model.ReadExcelDTO;
import com.commscope.exception.model.RequestJsonCreateExcelMessage;
import com.commscope.exception.model.RequestJsonMessage;
import com.commscope.exception.model.ResponseDTO;
import com.commscope.exception.model.ResponseEmailDTO;
import com.commscope.exception.utility.ExcelReadUtility;


// This class is HelloController to map the get service

@Service
public class ExceptionServiceImpl extends ExceptionService implements ExceptionServiceIntf {
	private static final Logger logger = LogManager.getLogger(ExceptionServiceImpl.class);
	@Autowired
	RestTemplate restTemplate;
	/*
	 * This url is configured in application properties .
	 */
	@Value("${NOTIFICATION_URL}")
	private String notificationUrl;
	
	@Value("${AUDIT_URL}")
	private String auditUrl;
	
	@Value("${SAMPLE_XLSX_FILE_PATH}")
	private String lookupMessageExcelPath;
	
	@Override
	@Async("threadPoolTaskExecutor")
	public NotificationDTO callNotificationFramework( RequestJsonMessage reqMsg,ReadExcelDTO readExcelDetails,String ticketNo,NotificationDTO notificationDto) {
		// TODO Auto-generated method stub
		System.out.println("URL=>"+notificationUrl);
		logger.info("URL=>"+notificationUrl);
		HttpHeaders requestHeaders = new HttpHeaders();
        //set up HTTP Basic Authentication Header
        requestHeaders.add("Content-Type", "application/json");
       // requestHeaders.add("Accept", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<NotificationDTO> requestEntity = new HttpEntity<>(requestHeaders);
		//Notification parameter 
		notificationDto.setErrorMSG(reqMsg.getErrorMsg());
		notificationDto.setErrorType(reqMsg.getErrorType());
		String resultantmessage=readExcelDetails.getErrorType()+"-"+readExcelDetails.getExceptionMessage();
		notificationDto.setMessageBody(resultantmessage);
		notificationDto.setSenderID(reqMsg.getSenderId());
		notificationDto.setTransType(reqMsg.getTransType());
		notificationDto.setSubject(reqMsg.getErrorType()+"-"+ticketNo);
		notificationDto.setRecipientID(reqMsg.getRecipientID());
		notificationDto.setSourceName(reqMsg.getSourceName());
		notificationDto.setMessageType(reqMsg.getErrorType());
		notificationDto.setIdNumber(reqMsg.getIdNumber());
		logger.info("Notification Details:-"+notificationDto);
		ResponseEntity<ResponseEmailDTO> responseEntity=restTemplate.postForEntity(notificationUrl, notificationDto, ResponseEmailDTO.class);
		ResponseEmailDTO dto = responseEntity.getBody();
		logger.info("Output Notification Details -"+dto);
		notificationDto.setMessageBody(dto.getStatusMSG()+"  parameters: "+notificationDto);
		return notificationDto;
	}

	@Override
	public ResponseDTO processException(RequestJsonMessage reqMsg) throws Exception {
		
		try {
			List<ReadExcelDTO> readExcelList = ExcelReadUtility.readExcel(lookupMessageExcelPath);
			 Optional<ReadExcelDTO> findFirst = readExcelList.stream().filter(dto -> dto.getInternalErrorCode().equals(reqMsg.getErrorCode())).findFirst();
			 String remedyTicketNo=UUID.randomUUID().toString().substring(0, 5).toUpperCase();
			 NotificationDTO notificationDto= new NotificationDTO();
			 if(!findFirst.isPresent()) {
				
					callAuditFramework("No Match Found for  the Input ErrorCode: "+reqMsg.getErrorCode(),"Failure",reqMsg);
					ReadExcelDTO readExcel =new ReadExcelDTO("", "Unrecognized error code", "No Match Found for  the Input ErrorCode: "+reqMsg.getErrorCode(), "");
					reqMsg.setErrorType("Unrecognized error code");
					callNotificationFramework( reqMsg, readExcel, remedyTicketNo,notificationDto);
					throw  new Exception("No Match Found for  the Input ErrorCode: "+reqMsg.getErrorCode());
			}
			 ReadExcelDTO readExcelDetails = findFirst.get();
			
			
			try {
				// TODO Auto-generated method stub
				callNotificationFramework( reqMsg, readExcelDetails, remedyTicketNo,notificationDto);
				callAuditFramework(notificationDto.getMessageBody(),"Success",reqMsg);
			} catch (Exception e) {
				// TODO: handle exception
				callAuditFramework("Error In Calling Notification Framework: "+e.toString()+"   URL:"+notificationUrl+" Parameters=>"+notificationDto,"Failure",reqMsg);
				logger.error("Error in Call the Notification Framework - " + e.getMessage()+"\n "+e);
				throw e;
			}
			ErrorData data= new ErrorData();
			Map<String, String> map = new HashMap<String, String>();
			map.put("Remedy Ticket No", remedyTicketNo);
			map.put("Message ",  readExcelDetails.getErrorType() +"-"+readExcelDetails.getExceptionMessage());
			map.put("Date ", new SimpleDateFormat("MM-dd-yyyy").format(new Date()));
			data.setResponse(map);
			Map<String, ErrorData> mapErrorData = new HashMap<String, ErrorData>();
			mapErrorData.put("Exception-Data", data);
			ResponseDTO createSuccessResponseDto = createSuccessResponseDto(mapErrorData);
			logger.info("ResponseDTO :: "+createSuccessResponseDto);
			return createSuccessResponseDto;
		} catch (EncryptedDocumentException  | InvalidFormatException  | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("Error in document/InvalidFormat/IOE -> "+e.getMessage());
			callAuditFramework(e.toString(),"Failure",reqMsg);
			throw e;
			//throw e;
		}
		//return null;
	}
	
	@Override
	@Async("threadPoolTaskExecutor")
	public AuditDTO callAuditFramework(String auditMSG,String responseType,RequestJsonMessage reqMsg) {
		// TODO Auto-generated method stub
		System.out.println("URL=>"+auditUrl);
		logger.info("callAuditFramework URL=>"+auditUrl);
		AuditDTO auditDto= new AuditDTO();
		HttpHeaders requestHeaders = new HttpHeaders();
        //set up HTTP Basic Authentication Header
        requestHeaders.add("Content-Type", "application/json");
       // requestHeaders.add("Accept", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<AuditDTO> requestEntity = new HttpEntity<>(requestHeaders);
		//Audit parameter 
		auditDto.setResponseMSG(auditMSG);
		auditDto.setResponseType(responseType);
		auditDto.setSenderID(reqMsg.getSenderId());
		auditDto.setSourceName(reqMsg.getSourceName());
		auditDto.setTransactionType(reqMsg.getTransType());
		auditDto.setIdNumber(reqMsg.getIdNumber());
		logger.info("Audit Details:-"+auditDto);
		try {
			ResponseEntity<String> responseEntity = restTemplate.postForEntity(auditUrl, auditDto, String.class);

			String body = responseEntity.getBody();
			logger.info("Output Audit Details -" + body);

		} catch (Exception e) {
			logger.error("CallAuditFramework::Exception::" + e);
		}
		// auditDto.setMessageBody(body);
		return auditDto;
	}
	@SuppressWarnings("rawtypes")
	@Override
	public ResponseDTO readErrorCodesFromExcel() throws Exception {
		// TODO Auto-generated method stub
		List<ReadExcelDTO> readExcelList = ExcelReadUtility.readExcel(lookupMessageExcelPath);
		Map<String, List<ReadExcelDTO>> map = new HashMap<String, List<ReadExcelDTO>>();
		map.put("errorCodeList", readExcelList);
		ErrorData<List<ReadExcelDTO>> data= new ErrorData<List<ReadExcelDTO>>();
		data.setResponse(map);
		Map<String, ErrorData> mapErrorData = new HashMap<String, ErrorData>();
		mapErrorData.put("exceptionData", data);
		ResponseDTO createSuccessResponseDto = createSuccessResponseDto(mapErrorData);
		logger.info("ResponseDTO :: "+createSuccessResponseDto);
		return createSuccessResponseDto;
	}
	
	@Override
	public ResponseDTO updateErrorCodesFromExcel(RequestJsonCreateExcelMessage  reqMsg) throws Exception {
		// TODO Auto-generated method stub
		ResponseDTO createSuccessResponseDto=null;
		try {
		Boolean isUpdatedRowInExcelSheet = ExcelReadUtility.updateRowInExcelSheet(lookupMessageExcelPath,reqMsg);
		Map<String,Boolean> dataMap = new HashMap<String, Boolean>();
		dataMap.put("isUpdatedRow", isUpdatedRowInExcelSheet);
		createSuccessResponseDto = createSuccessResponseDto(new ErrorData<Boolean>(dataMap));
		}catch (EncryptedDocumentException | InvalidFormatException |IOException |CustomException ioe) {
			// TODO: handle exception
			logger.error("Error in updating the Record IO - " + ioe.getMessage()+"\n "+ioe);
			throw ioe;
		}catch(Exception e) {
			logger.error("General Error: - " + e.getMessage()+"\n "+e);
			throw e;
		}
		
		
		return createSuccessResponseDto;
	}

	@Override
	public ResponseDTO insertErrorCodesFromExcel(RequestJsonCreateExcelMessage request) throws Exception {
		// TODO Auto-generated method stub
		ResponseDTO createSuccessResponseDto=null;
		try {
			List<ReadExcelDTO> readExcelList = ExcelReadUtility.readExcel(lookupMessageExcelPath);
			boolean match=readExcelList.stream().anyMatch(readExcelDTO->readExcelDTO.getInternalErrorCode().equals(request.getInternalErrorCode()));
			
			if(match) {
				throw new Exception("Internal Error Code is Already Exists , Please use unique Internal Error Code");
			}
			Boolean isRowinserted = ExcelReadUtility.insertRowInExcelSheet(lookupMessageExcelPath, request);
			Map<String,Boolean> dataMap = new HashMap<String, Boolean>();
			dataMap.put("isRowInserted", isRowinserted);
			createSuccessResponseDto = createSuccessResponseDto(new ErrorData<Boolean>(dataMap));
		}catch (EncryptedDocumentException | InvalidFormatException |IOException  |CustomException ioe) {
			// TODO: handle exception
			logger.error("Error in inserting the Record IO - " + ioe.getMessage()+"\n "+ioe);
			throw ioe;
		}catch(Exception e) {
			logger.error("General Error: - " + e.getMessage()+"\n "+e);
			throw e;
		}
		
		
		return createSuccessResponseDto;
	}

	@Override
	public ResponseDTO deleteErrorCodesFromExcel(String internalErrorCode) throws Exception {
		// TODO Auto-generated method stub
		ResponseDTO createSuccessResponseDto=null;
		try {
			Boolean isRowDeleted = ExcelReadUtility.deleteRowInExcelSheet(lookupMessageExcelPath, internalErrorCode);
			Map<String,Boolean> dataMap = new HashMap<String, Boolean>();
			dataMap.put("isRowDeleted", isRowDeleted);
			createSuccessResponseDto = createSuccessResponseDto(new ErrorData<Boolean>(dataMap));
		}catch (EncryptedDocumentException | InvalidFormatException |IOException  | CustomException ioe) {
			// TODO: handle exception
			logger.error("Error in deleting the Record IO - " + ioe.getMessage()+"\n "+ioe);
			ioe.printStackTrace();
			throw ioe;
		}catch(Exception e) {
			logger.error("General Error: - " + e.getMessage()+"\n "+e);
			e.printStackTrace();
			throw e;
		}
		
		return createSuccessResponseDto;
	}

	
	public static void main(String[] args) {
		/*ExceptionServiceImpl exceptionServiceImpl = new ExceptionServiceImpl();
		exceptionServiceImpl.notificationUrl="https://commscopedevapi.azurewebsites.net/email/API_EMAIL";
		RestTemplateBuilder build = new RestTemplateBuilder();
		exceptionServiceImpl.restTemplate=build.build();
		NotificationDTO callNotificationFramework = exceptionServiceImpl.callNotificationFramework("resultantmessage","ticket no");
		System.out.println("DTO=> "+callNotificationFramework);*/
		
		String str="xyx";
		String st= new String("xyx");
		System.out.println("-> "+str==st);
	}

	

}
