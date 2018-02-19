package com.horoscope.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



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
	
	public static String readExcelData(int row,int column) throws Exception 
	{ 
		File source = new File("D:\\Selenium\\TestData.xlsx"); 
		FileInputStream fis = new FileInputStream(source); 
		XSSFWorkbook wb = new XSSFWorkbook(fis); 
		XSSFSheet sheet1 = wb.getSheetAt(0); 
		
		String data0=sheet1.getRow(row).getCell(column).getStringCellValue();
		System.out.println("data from the excel is " + data0); return data0; 
		
	}
	
	
}
