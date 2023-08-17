package com.orangehrm.utilities;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

    private XSSFWorkbook workBook;
    private XSSFSheet excelSheet;
    private XSSFCell cell;
    
    public ExcelUtils(String fileName) {
        try {
            FileInputStream inputStream = new FileInputStream(fileName);
            workBook = new XSSFWorkbook(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getCellValue(String sheetName, int rowNo, int cellNo) {
        try {
            excelSheet = workBook.getSheet(sheetName);
            cell = excelSheet.getRow(rowNo).getCell(cellNo);
            return cell.getStringCellValue();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public int getRowCount(String sheetName) {
        try {
            excelSheet = workBook.getSheet(sheetName);
            return excelSheet.getLastRowNum() + 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int getColumnCount(String sheetName) {
    	
        try {
            excelSheet = workBook.getSheet(sheetName);
            return excelSheet.getRow(0).getLastCellNum();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public void closeWorkbook() {
        try {
            if (workBook != null) {
                workBook.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
