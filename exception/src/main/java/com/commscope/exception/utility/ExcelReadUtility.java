package com.commscope.exception.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Component;

import com.commscope.exception.handleException.CustomException;
import com.commscope.exception.model.ReadExcelDTO;
import com.commscope.exception.model.RequestJsonCreateExcelMessage;
/**
 * Utility class for the CRUD operation on Excel 
 * @author RT1050
 *
 */
@Component
public class ExcelReadUtility {

	public static final String SAMPLE_XLSX_FILE_PATH = "C:\\Users\\RT1050\\Downloads\\MessageCodes.xlsx";

	public static void main(String[] args) throws IOException, InvalidFormatException {

		readExcel(SAMPLE_XLSX_FILE_PATH);
	}

	public static List<ReadExcelDTO> readExcel(String path)
			throws EncryptedDocumentException, InvalidFormatException, IOException {
		// Creating a Workbook from an Excel file (.xls or .xlsx)
		FileInputStream fio = null;
		Workbook workbook = null;
		try {
			fio = new FileInputStream(new File(path));
			workbook = WorkbookFactory.create(fio);

			// Retrieving the number of sheets in the Workbook
			System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");
			System.out.println("Retrieving Sheets using Java 8 forEach with lambda");
			workbook.forEach(sheet -> {
				System.out.println("=> " + sheet.getSheetName());
			});
			Sheet messagecodesSheet = workbook.getSheetAt(0);
			// Create a DataFormatter to format and get each cell's value as String
			DataFormatter dataFormatter = new DataFormatter();
			// 3. Or you can use Java 8 forEach loop with lambda
			System.out.println("\n\nIterating over Rows and Columns using Java 8 forEach with lambda\n");
			messagecodesSheet.forEach(row -> {

				row.forEach(cell -> {
					String cellValue = dataFormatter.formatCellValue(cell);
					System.out.print(cellValue + "\t");
				});
				System.out.println();
			});
			System.out.println("\n\n----------------\n");
			Iterator<Row> rows = messagecodesSheet.rowIterator();
			rows.next();
			List<ReadExcelDTO> listReadExcel = new ArrayList<ReadExcelDTO>();
			while (rows.hasNext()) {
				Row row = rows.next();
				System.out.println("ErrorCode:- " + row.getCell(0) + "  ErrorType:-" + row.getCell(1) + "  Message:-"
						+ row.getCell(2) + "  Level:-" + row.getCell(3));
				String errorCode = dataFormatter.formatCellValue(row.getCell(0));
				String errorType = dataFormatter.formatCellValue(row.getCell(1));
				String message = dataFormatter.formatCellValue(row.getCell(2));
				String level = dataFormatter.formatCellValue(row.getCell(3));
				ReadExcelDTO readDto = new ReadExcelDTO(errorCode, errorType, message, level);
				listReadExcel.add(readDto);
			}

			// Closing the workbook
			workbook.close();
			return listReadExcel;
		} catch (EncryptedDocumentException | InvalidFormatException | IOException ioe) {
			throw ioe;
		} finally {
			if (workbook != null) {
				workbook.close();
			}
			if (fio != null) {
				fio.close();
			}
		}
	}

	public static Boolean insertRowInExcelSheet(String excelFilePath, RequestJsonCreateExcelMessage request)
			throws EncryptedDocumentException, InvalidFormatException, IOException {

		Boolean inserted = new Boolean(false);
		FileInputStream inputStream = null;
		try {
			inputStream = new FileInputStream(new File(excelFilePath));
			Workbook workbook = WorkbookFactory.create(inputStream);

			Sheet sheet = workbook.getSheetAt(0);

			Object[][] bookData = { { request.getInternalErrorCode(), request.getErrorType(),
					request.getExceptionMessage(), request.getLevel() }, };

			int rowCount = sheet.getLastRowNum();

			for (Object[] aBook : bookData) {
				Row row = sheet.createRow(++rowCount);

				int columnCount = 0;

				// Cell cell = row.createCell(columnCount);
				// cell.setCellValue(rowCount);

				for (Object field : aBook) {
					Cell cell = row.createCell(columnCount++);
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
			inserted = true;

			return inserted;
		} catch (EncryptedDocumentException | InvalidFormatException | IOException ioe) {
			throw ioe;
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
		}
	}

	/**
	 * Return row num if internalErrorCode exists otherwise -1 -1 indicated that
	 * internal error code not exists.
	 * 
	 * @param sheet
	 * @param internalErrorCode
	 * @return
	 */
	static int getRowNum(Sheet sheet, String internalErrorCode) {
		DataFormatter dataFormatter = new DataFormatter();
		int rowFoundNum = -1;
		for (int rowNum = 0; rowNum < (sheet.getLastRowNum() + 1); rowNum++) {
			Row row = sheet.getRow(rowNum);
			Cell cell = row.getCell(0);
			String cellValue = dataFormatter.formatCellValue(cell);
			System.out.println(
					internalErrorCode + "----------------------------Print ->" + cellValue + " rowNum:" + rowNum);
			if (internalErrorCode.trim().equalsIgnoreCase(cellValue)) {
				rowFoundNum = rowNum;
				break;
			}
		}
		return rowFoundNum;
	}

	public static Boolean updateRowInExcelSheet(String excelFilePath, RequestJsonCreateExcelMessage request)
			throws EncryptedDocumentException, InvalidFormatException, IOException, CustomException {

		if (request.getInternalErrorCode() == null || request.getInternalErrorCode().trim().length() == 0) {
			throw new InvalidFormatException(" There is no input Internal Error Code ");
		}
		Boolean inserted = new Boolean(false);
		FileInputStream inputStream = null;
		try {
			inputStream = new FileInputStream(new File(excelFilePath));
			Workbook workbook = WorkbookFactory.create(inputStream);

			Sheet sheet = workbook.getSheetAt(0);

			int rowNum = getRowNum(sheet, request.getInternalErrorCode().trim());
			if (rowNum == -1) {
				throw new CustomException(" Passed input Error code " + request.getInternalErrorCode().trim()
						+ "  is not Exists in Excel ");
			}

			//

			Object[][] bookData = { { request.getInternalErrorCode(), request.getErrorType(),
					request.getExceptionMessage(), request.getLevel() }, };

			int rowCount = sheet.getLastRowNum();

			for (Object[] aBook : bookData) {
				// Row row = sheet.createRow(++rowCount);
				Row row = sheet.getRow(rowNum);
				int columnCount = 0;

				// Cell cell = row.createCell(columnCount);
				// cell.setCellValue(rowCount);

				for (Object field : aBook) {
					Cell cell = row.createCell(columnCount++);
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
			inserted = true;

			return inserted;
		} catch (EncryptedDocumentException | InvalidFormatException | IOException | CustomException ioe) {
			throw ioe;
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
		}
	}

	public static Boolean deleteRowInExcelSheet(String excelFilePath, String internalErrorCode)
			throws EncryptedDocumentException, InvalidFormatException, IOException, CustomException {

		FileInputStream inputStream = null;
		if (internalErrorCode == null || internalErrorCode.trim().length() == 0) {
			throw new CustomException(" There is no input Internal Error Code ");
		}
		Workbook workbook=null;
		try {
			Boolean inserted = new Boolean(false);

			inputStream = new FileInputStream(new File(excelFilePath));
			workbook = WorkbookFactory.create(inputStream);

			Sheet sheet = workbook.getSheetAt(0);

			int rowIndex = getRowNum(sheet, internalErrorCode.trim());
			if (rowIndex == -1) {
				throw new CustomException(
						" Passed input Error code " + internalErrorCode + "  is not Exists in Excel ");
			}

			 	int lastRowNum=sheet.getLastRowNum();
			    if(rowIndex>=0&&rowIndex<lastRowNum){
			        sheet.shiftRows(rowIndex+1,lastRowNum, -1);
			    }
			    if(rowIndex==lastRowNum){
			    	Row removingRow = sheet.getRow(rowIndex);
			        if(removingRow!=null){
			            sheet.removeRow(removingRow);
			        }
			    }
			
			
			
			inputStream.close();

			FileOutputStream outputStream = new FileOutputStream(excelFilePath);
			workbook.write(outputStream);
			workbook.close();
			outputStream.close();
			inserted = true;

			return inserted;
		} catch (EncryptedDocumentException | InvalidFormatException | IOException | CustomException ioe) {
			throw ioe;
		} finally {
			if (inputStream != null) {
				inputStream.close();
				workbook.close();
			}
			
		}
	}
}
