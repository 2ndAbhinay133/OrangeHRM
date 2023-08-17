package com.orangehrm.utilities;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	
	public static FileInputStream fis;
	public static XSSFWorkbook workBook;
	public static XSSFSheet excelSheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	private static ReadExcel r;
	
	public static void main(String[] args) {	
		r=new ReadExcel();
		/*
		 * System.out.println(r.getCellValue("Login Data", 0, 1));
		 * System.out.println(r.getTotalColumn("Login Data"));
		 * System.out.println(r.getTotalRow("Login Data"));
		 */		
		r.loginDataProvider();
		
	}
	public ReadExcel() {
		
		try {
			fis=new FileInputStream("./Test Data/Test Data.xlsx");
			workBook=new XSSFWorkbook(fis);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	public String getCellValue(String sheetName, int rowNo,int cellNo) {
		
		excelSheet=workBook.getSheet(sheetName);
		cell=excelSheet.getRow(rowNo).getCell(cellNo);
		return cell.getStringCellValue();
		
	}
	public int getTotalColumn(String sheetName) {
		
		excelSheet=workBook.getSheet(sheetName);
		int ttlCol=excelSheet.getRow(0).getLastCellNum();
		return ttlCol;
		
	}
	public int getTotalRow(String sheetName) {
		
		excelSheet=workBook.getSheet(sheetName);
		int ttlRow=excelSheet.getLastRowNum();
		return ttlRow;
		
	}
	public void loginDataProvider() {
		
		int totalCol=getTotalColumn("Login Data");
		System.out.println(totalCol);
		int totalRow=getTotalRow("Login Data");
		System.out.println(totalRow);
		String [][] data=new String[totalRow][totalCol];
		for(int i=1;i<=totalRow;i++) {
			for(int j=0;j<totalCol;j++) {
				data[i-1][j]=getCellValue("Login Data", i, j);
				System.out.print(data[i-1][j]);
			}
			System.out.println();
		}
			
	}
}
