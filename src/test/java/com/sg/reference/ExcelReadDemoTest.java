package com.sg.reference;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadDemoTest {
	public static void main(String[] args) throws IOException {

		FileInputStream file = new FileInputStream("testdata/OpenEMRData.xlsx");

		XSSFWorkbook book = new XSSFWorkbook(file);

		XSSFSheet sheet = book.getSheet("invalidCredentialTest");
		
		int rowCount= sheet.getPhysicalNumberOfRows();
		System.out.println(rowCount);
		
		XSSFRow row = sheet.getRow(0);		
		int cellCount=row.getPhysicalNumberOfCells();
		System.out.println(cellCount);
		
		Object[][] main=new Object[rowCount-1][cellCount];
		
		for(int r=1;r<rowCount;r++)
		{
			row = sheet.getRow(r);
			for(int c=0;c<cellCount;c++)
			{
				XSSFCell cell= row.getCell(c);		
				DataFormatter format=new DataFormatter();	
				String value = format.formatCellValue(cell);
				System.out.println(value);
				main[r-1][c]=value;
			}
		}
		
		System.out.println(main);
	}
}




