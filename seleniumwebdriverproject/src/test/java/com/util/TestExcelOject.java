package com.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class TestExcelOject {

	
	public static Object[][] testWriteExcel(String sheetname)

	{
		

		File file=new File("src\\test\\resources\\firstexcel.xlsx");
   Object[][] obj=null;
   
		try {
			InputStream is = new  FileInputStream(file);
			XSSFWorkbook workbook=new XSSFWorkbook(is);
			XSSFSheet sheet1=workbook.getSheet(sheetname);
			obj=new Object[sheet1.getLastRowNum()][];
			
			
			for(int i=1;i<=sheet1.getLastRowNum();i++)
			{
				obj[i-1]=new Object[sheet1.getRow(i).getPhysicalNumberOfCells()];
				
				for(int j=0;j<sheet1.getRow(i).getPhysicalNumberOfCells();j++)
				{
					obj[i-1][j]=sheet1.getRow(i).getCell(j).getStringCellValue();
				}
				
			}
			is.close();


			workbook.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();

		}
 return obj;


	}
}









