package com.orangehrm.utilities;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel1 {
	
	
	private FileInputStream fis;
	private XSSFWorkbook workBook;
	private XSSFSheet sheet;
	private XSSFRow row;
	private XSSFCell cell;
	
	public ReadExcel1() {
		
		try {
			fis=new FileInputStream("./Test Data/Test Data.xlsx");
			workBook=new XSSFWorkbook(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public String getCellValue(String sheetName,int rowNo,int colNo ) {
		
		sheet=workBook.getSheet(sheetName);
		cell=sheet.getRow(rowNo).getCell(colNo);
		return cell.getStringCellValue();
		
	}
	public int getTotalColumn(String sheetname) {
		
		sheet=workBook.getSheet(sheetname);
		int row=sheet.getRow(0).getLastCellNum();
		return row;
	}
	public int getTotalRow(String sheetName) {
		
		sheet=workBook.getSheet(sheetName);
		int cell=sheet.getLastRowNum();
		return cell;
		
	}
	

}
