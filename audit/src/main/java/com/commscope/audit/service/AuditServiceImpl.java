package com.commscope.audit.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.commscope.audit.model.ReadExcelDTO;
import com.commscope.audit.model.RequestAuditModel;
import com.commscope.audit.model.ResponseAuditModel;
import com.commscope.audit.utility.ExcelReadUtility;

/**
 * These are service class to process user request for the CRUD operation .
 * @author RT1050
 *
 */
@Service
public class AuditServiceImpl implements IAuditService {

	
	@Value("${AUDIT_XLSX_FILE_PATH}")
	private String excelFilePath;

	@Override
	public ResponseAuditModel forAuditingService(RequestAuditModel request) {
		// TODO Auto-generated method stub

		ResponseAuditModel ram = new ResponseAuditModel();
		ram = updateInExcelSheet(request);

		return ram;
	}

	@Override
	public List<ReadExcelDTO> readAuditInfo(RequestAuditModel request)
			throws EncryptedDocumentException, InvalidFormatException, IOException, ParseException {
		List<ReadExcelDTO> readExcelList = ExcelReadUtility.readExcel(excelFilePath);
		if (request.getSenderID() != null) {
			// filter with SenderID
			readExcelList = readExcelList.stream()
					.filter(readExcelDto -> readExcelDto.getSenderID().contains(request.getSenderID()))
					.collect(Collectors.toList());
		}
		if (request.getResponseType() != null) {
			// filter with ResponseType
			readExcelList = readExcelList.stream()
					.filter(readExcelDto -> readExcelDto.getResponseType().contains(request.getResponseType()))
					.collect(Collectors.toList());
		}
		if (request.getTransactionType() != null) {
			// filter with TransactionType
			readExcelList = readExcelList.stream()
					.filter(readExcelDto -> readExcelDto.getTransactionType().contains(request.getTransactionType()))
					.collect(Collectors.toList());
		}
		if (request.getSourceName() != null) {
			// filter with TransactionType
			readExcelList = readExcelList.stream()
					.filter(readExcelDto -> readExcelDto.getSource().contains(request.getSourceName()))
					.collect(Collectors.toList());
		}
		if (request.getIdNumber() != null) {
			// filter with TransactionType
			readExcelList = readExcelList.stream()
					.filter(readExcelDto -> readExcelDto.getIdNumber().contains(request.getIdNumber()))
					.collect(Collectors.toList());
		}
		if((request.getStart_date() !=null) && (request.getEnd_date() !=null)) {
			readExcelList = readExcelList.stream()
					.filter(readExcelDto -> {
						  //  a.compareTo(d) * d.compareTo(b) >= 0;
							Date currentDate = readExcelDto.getDateCellValue();
							SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
							ft.setLenient(false);
								try {
									Date startDate = ft.parse(request.getStart_date());
									Date endDate = ft.parse(request.getEnd_date());
									return (startDate.compareTo(currentDate)*currentDate.compareTo(endDate))>=0;
								} catch (ParseException e) {
				        		e= new ParseException("Check input start_date and end_date with format yyyy-MM-dd",0);
				        		try {
									throw e;
								} catch (ParseException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
				        	}
				        	return readExcelDto.getSource().contains(request.getSourceName());
						})
					.collect(Collectors.toList());
			
		}
		readExcelList = sortAsperLatestRecord(readExcelList);
		return readExcelList;
	}

	private List<ReadExcelDTO> sortAsperLatestRecord(List<ReadExcelDTO> list) {
		Collections.sort(list, new Comparator<ReadExcelDTO>() {

			@Override
			public int compare(ReadExcelDTO o1, ReadExcelDTO o2) {
				// TODO Auto-generated method stub

				return -(o1.getDateCellValue().compareTo(o2.getDateCellValue()));
			}

		});
		return list;
	}

	private ResponseAuditModel updateInExcelSheet(RequestAuditModel request) {

		ResponseAuditModel ram = new ResponseAuditModel();

		try {
			FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
			Workbook workbook = WorkbookFactory.create(inputStream);

			Sheet sheet = workbook.getSheetAt(0);

			LocalDateTime currentDate = LocalDateTime.now();
			 if(null==request.getCreated_date()||request.getCreated_date().isEmpty()) {
	            	 request.setCreated_date(currentDate.toString());
	            }
	           
	            if(null==request.getCreated_by()||request.getCreated_by().isEmpty()) {
	            	request.setCreated_by(request.getSenderID());
	            }	            
	 
	            Object[][] bookData = {
	                    {request.getSenderID(),request.getSourceName(),request.getTransactionType(), request.getResponseType(),
	                    	request.getResponseMSG(),request.getIdNumber(),request.getCreated_by(),request.getCreated_date() }, };

			int rowCount = sheet.getLastRowNum();

			for (Object[] aBook : bookData) {
				Row row = sheet.createRow(++rowCount);

				int columnCount = 0;

				Cell cell = row.createCell(columnCount);
				cell.setCellValue(rowCount);

				for (Object field : aBook) {
					cell = row.createCell(++columnCount);
					if (field instanceof String) {
						cell.setCellValue((String) field);
					} else if (field instanceof Integer) {
						cell.setCellValue((Integer) field);
					}
				}

			}

			inputStream.close();

			FileOutputStream outputStream = new FileOutputStream(excelFilePath);
			workbook.write(outputStream);
			workbook.close();
			outputStream.close();
			ram.setStatusCode("200");
			ram.setStatusMSG("Audit record Successfully");

		} catch (IOException | EncryptedDocumentException | InvalidFormatException ex) {
			ram.setStatusCode("500");
			ram.setStatusMSG(ex.getMessage());
			ex.printStackTrace();

		}

		return ram;
	}

}
