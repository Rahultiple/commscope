package com.commscope.audit.utility;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Component;

import com.commscope.audit.controller.AuditController;
import com.commscope.audit.model.ReadExcelDTO;

/**
 * Utility class for the Excel CRUD operaion 
 * @author RT1050
 *
 */

@Component
public class ExcelReadUtility {
	private static final Logger logger = LogManager.getLogger(AuditController.class);
	 public static final String SAMPLE_XLSX_FILE_PATH = "C:\\Users\\RT1050\\Downloads\\MessageCodes.xlsx";
	 public static void main(String[] args) throws IOException, InvalidFormatException {
		try {
		 readExcel(SAMPLE_XLSX_FILE_PATH);
		}catch(Exception e) {
			
		}
	 }
	 
	 public static List<ReadExcelDTO> readExcel(String path) throws EncryptedDocumentException, InvalidFormatException, IOException, ParseException {
		// Creating a Workbook from an Excel file (.xls or .xlsx)
	      Workbook workbook = WorkbookFactory.create(new File(path));
		 
		 // Retrieving the number of sheets in the Workbook
	        logger.info("Workbook has {{}} Sheets : "+workbook.getNumberOfSheets());
	        logger.info("Retrieving Sheets using Java 8 forEach with lambda");
	        workbook.forEach(sheet -> {
	            logger.info("=> " + sheet.getSheetName());
	        });
	        Sheet messagecodesSheet = workbook.getSheetAt(0);
	     // Create a DataFormatter to format and get each cell's value as String
	        DataFormatter dataFormatter = new DataFormatter();
	     // 3. Or you can use Java 8 forEach loop with lambda
	        logger.info("\n\nIterating over Rows and Columns using Java 8 forEach with lambda\n");
	        messagecodesSheet.forEach(row -> {
	        
	            row.forEach(cell -> {
	                String cellValue =dataFormatter.formatCellValue(cell);
	                System.out.print(cellValue + "\t");
	            });
	            System.out.println();
	        });
	        System.out.println("\n\n----------------\n");
	        Iterator<Row> rows = messagecodesSheet.rowIterator();
	        rows.next();
	        List<ReadExcelDTO> listReadExcel= new ArrayList<ReadExcelDTO>();
	        while(rows.hasNext()) {
	        	Row row = rows.next();
	        	logger.info("senderID:- "+row.getCell(1)+" Source Name:- "+row.getCell(2)+"  transactionType:-"+row.getCell(3)+"  responseType:-"+row.getCell(4)+"  createdBy:-"+row.getCell(6)+"  date_time:-"+row.getCell(7));
	        	String senderID=dataFormatter.formatCellValue(row.getCell(1));
	        	String sourceName=dataFormatter.formatCellValue(row.getCell(2));
	        	String transactionType=dataFormatter.formatCellValue(row.getCell(3));
	        	String responseType=dataFormatter.formatCellValue(row.getCell(4));
	        	String responseMsg=dataFormatter.formatCellValue(row.getCell(5));
	        	String idNumber=dataFormatter.formatCellValue(row.getCell(6));
	        	String createdBy=dataFormatter.formatCellValue(row.getCell(7));
	        	String date_time =dataFormatter.formatCellValue( row.getCell(8));
	        	String dateSplit=date_time.split("T")[0];
	        	String timeSplit=date_time.split("T")[1];
	        	
	        	// DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss.S");
	        	 
	        	SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.S");
	        	Date dateObject = ft.parse(date_time);
	        	
	        	ReadExcelDTO readDto= new ReadExcelDTO(senderID,sourceName,transactionType,responseType,idNumber,createdBy,dateObject);
	        	readDto.setResponseMessage(responseMsg);
	        	listReadExcel.add(readDto);
	        }
	        
	        // Closing the workbook
	        workbook.close();
	        return listReadExcel;
	 }
}
