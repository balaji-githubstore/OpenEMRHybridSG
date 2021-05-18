package com.scientificgames.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	public static Object[][] getSheetIntoObjectArray(String path,String sheetName) throws IOException
	{
		FileInputStream file = new FileInputStream(path);
		XSSFWorkbook book = new XSSFWorkbook(file);
		XSSFSheet sheet = book.getSheet(sheetName);		
		int rowCount= sheet.getPhysicalNumberOfRows();		
		XSSFRow row = sheet.getRow(0);		
		int cellCount=row.getPhysicalNumberOfCells();
		
		Object[][] main=new Object[rowCount-1][cellCount];
		DataFormatter format=new DataFormatter();
		
		for(int r=1;r<rowCount;r++)
		{
			row = sheet.getRow(r);
			for(int c=0;c<cellCount;c++)
			{
				XSSFCell cell= row.getCell(c);			
				String value = format.formatCellValue(cell);
				main[r-1][c]=value;
			}
		}
		return main;
	}

}
