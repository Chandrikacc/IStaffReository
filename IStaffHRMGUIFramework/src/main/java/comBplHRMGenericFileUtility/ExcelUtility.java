package comBplHRMGenericFileUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
	public String getDataFromExcel(String sheetName,int rowNum,int cellNum) throws Throwable, IOException {
		FileInputStream fis=new FileInputStream("C:\\Oopsconcept\\IStaffHRMGUIFramework\\TestData\\TestScriptData.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		String data = workbook.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
		workbook.close();
		return data;
	    }
	
	public int getRowCount(String sheetName) throws Throwable {
		FileInputStream fis=new FileInputStream("‪./TestData/TestScriptData.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		int rowcount=workbook.getSheet(sheetName).getLastRowNum();
		workbook.close();
		return rowcount;
		
	}
	
	public void setDataIntoExcel(String sheetName,int rowNum,int cellNum,String data) throws Throwable, IOException {
		FileInputStream fis=new FileInputStream("‪./TestData/TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(rowNum).createCell(cellNum);	
		FileOutputStream fos=new FileOutputStream("‪./TestData/TestScriptData.xlsx");
		wb.write(fos);
		wb.close();
			
	}
	public int getCellCount(String sheetName) throws Throwable, IOException {
		FileInputStream fis=new FileInputStream("‪./TestData/TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int cellCount=wb.getSheet(sheetName).getRow(0).getLastCellNum();
		wb.close();
		return cellCount;	
	}

}