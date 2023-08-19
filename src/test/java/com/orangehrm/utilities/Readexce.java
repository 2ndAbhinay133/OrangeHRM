package com.orangehrm.utilities;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Readexce {
	
	
	FileInputStream fis;
	XSSFWorkbook workBook;
	XSSFSheet sheet;
	XSSFCell cell;
	XSSFRow row;
	
	public Readexce() {
		try {
			fis=new FileInputStream("./Test Data/Test Data.xlsx");
			workBook=new XSSFWorkbook(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getCellValue(String sheetName,int rowNo,int  cellNo) {

			sheet=workBook.getSheet(sheetName);
			cell=sheet.getRow(rowNo).getCell(cellNo);
			return cell.getStringCellValue();	
	}
	public int getTotalCol(String sheetName) {
		
		sheet=workBook.getSheet(sheetName);
		int ttlCol=sheet.getRow(0).getLastCellNum();
		return ttlCol;
		
		
	}
	public int getTotalRow(String sheetName) {
		sheet=workBook.getSheet(sheetName);
		int ttlRow=sheet.getLastRowNum();
		return ttlRow;
				
	}
	
	
	

}
