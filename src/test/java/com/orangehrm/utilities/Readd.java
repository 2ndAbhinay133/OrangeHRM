package com.orangehrm.utilities;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Readd {
	
	
	private FileInputStream fis;
	private XSSFWorkbook workBook;
	private XSSFSheet excelSheet;
	private XSSFCell cell;

	public Readd() {
		
		try {
			fis=new FileInputStream("./Test Data/Test Data.xlsx");
			workBook=new XSSFWorkbook(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public String getCellValue(String sheetName,int rowNo,int cellNo) {
		
		excelSheet=workBook.getSheet(sheetName);
		cell=excelSheet.getRow(rowNo).getCell(cellNo);
		return cell.getStringCellValue();
		
		
	}
	public int getTotalRow(String sheetName) {
		
		excelSheet=workBook.getSheet(sheetName);
		int ttlRow=excelSheet.getLastRowNum();
		return ttlRow;
		
	}
	public int getTotalColumn(String sheetName) {
		
		excelSheet=workBook.getSheet(sheetName);
		int ttlCol=excelSheet.getRow(0).getLastCellNum();
		return ttlCol;
	}
	
	public void loginDataProvider() {
		
		int totolcol=getTotalColumn("Test Data");
		int totolRow=getTotalRow("Test Data");
		
		String[][]data=new String[totolRow][totolcol];
		for(int i=1;i<=totolRow;i++) {
			for(int j=0;j<totolcol;j++) {
				
				data[i-1][j]=getCellValue("Test Data",i,j);
			}
		}
		
	}

}
