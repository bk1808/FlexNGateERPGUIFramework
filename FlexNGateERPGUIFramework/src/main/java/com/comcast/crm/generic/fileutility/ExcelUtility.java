package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * 
 * @author Deepak
 *
 */
public class ExcelUtility {
	
	/**
	 * read data from Excel based row and column index
	 * @param sheetName
	 * @param rowNum
	 * @param celNum
	 * @return
	 * @throws Throwable
	 */
	public String getDataFromExcel(String sheetName , int rowNum , int celNum) throws Throwable {
		
		FileInputStream fis = new FileInputStream("./testdata/testScriptdata.xlsx");
		Workbook wb =  WorkbookFactory.create(fis);
	    String data = wb.getSheet(sheetName).getRow(rowNum).getCell(celNum).getStringCellValue();
	    wb.close();
		return data;
	}
	/**
	 * get the used row count based on sheet name
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 */
	public int getRowcount(String sheetName ) throws Throwable {
		FileInputStream fis = new FileInputStream("./testdata/testScriptdata.xlsx");
		Workbook wb =  WorkbookFactory.create(fis);
		int rowCount = wb.getSheet(sheetName).getLastRowNum();
		 wb.close();
		return rowCount;
	}
	/**
	 * write data back to excel based on cell index
	 * @param sheetName
	 * @param rowNum
	 * @param celNum
	 * @param data
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void setDataIntoExcel(String sheetName , int rowNum , int celNum , String data) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./testdata/testScriptdata.xlsx");
		Workbook wb =  WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(rowNum).createCell(celNum);
		
		FileOutputStream fos = new FileOutputStream("./testdata/testScriptdata.xlsx");
		wb.write(fos);
		wb.close();
	} 
	
	
	/**
	 * This method is used to fetch the data from the excel based on key
	 * 
	 * @param sheetName
	 * @param requiredKey
	 * @return
	 * @throws IOException
	 * @throws EncryptedDocumentException
	 */
	public String getDataFromExcel(String excelPath, String sheetName, String testcaseName, String requiredKey)
			throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./testdata/testScriptdata.xlsx");
		Workbook wb =  WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetName);
		String value = "";
		String actualTestCaseName = "";
		String actualKey = "";
		boolean flag = false;
		for (int i = 0; i <= sheet.getLastRowNum(); i++) {
			try {
				actualTestCaseName = sheet.getRow(i).getCell(0).getStringCellValue();
			} catch (Exception e) {
			}
			if (actualTestCaseName.equalsIgnoreCase(testcaseName)) {
				for (int j = 1; j <= sheet.getRow(i).getLastCellNum(); j++) {
					try {
						actualKey = sheet.getRow(i - 1).getCell(j).getStringCellValue();
					} catch (Exception e) {
					}
					if (actualKey.equalsIgnoreCase(requiredKey)) {
						try {
							value = sheet.getRow(i).getCell(j).toString();
						} catch (Exception e) {
						}
						flag = true;
						break;
					}
				}
			}
			if (flag) {
				break;
			}
		}
		wb.close();
		return value;
	}


}






