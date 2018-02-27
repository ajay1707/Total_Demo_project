package com.horoscope.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;



public class Horoscope_GenericLib {

	//To read Config Property File 
	public static String readConfigPropFile(String sPropFileName,String sKey) throws IOException
	{
		
		String sValue = null;
		try
		{
		Properties prop = new Properties();
		FileInputStream fi = new FileInputStream(sPropFileName);
		prop.load(fi);
		sValue = prop.getProperty(sKey);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
		return sValue;	
	}
	
	//To read data from excel sheet
	//Implementing the Data driven Framework
	
	public static String readExcelData(int rowNumber,int columnNumber) throws Exception 
	{ 
		File source = new File("D:\\Selenium\\TestData.xlsx"); 
		FileInputStream fis = new FileInputStream(source); 
		XSSFWorkbook wb = new XSSFWorkbook(fis); 
		XSSFSheet sheet = wb.getSheetAt(0); 
		String cellValue = null;
		
		XSSFRow row = sheet.getRow(rowNumber);
		XSSFCell cell = row.getCell(columnNumber);
		
		if(cell.getCellTypeEnum() == CellType.STRING)
			cellValue = cell.getStringCellValue();
		
		else if(cell.getCellTypeEnum() == CellType.NUMERIC || cell.getCellTypeEnum()== CellType.FORMULA)
		{	
			//this will convert the value of Integer to String
			cellValue = String.valueOf(Integer.valueOf((int) cell.getNumericCellValue()));
			
		}

		return cellValue;
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
