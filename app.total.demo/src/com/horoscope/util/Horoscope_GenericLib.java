package com.horoscope.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;



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
/*	public static String[] readDataFromExcel(String sheetName, String Tc_Id) throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		String testdata[] = null;
		
		FileInputStream fis = new FileInputStream(BaseLib.sExcelFileName);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet s1 = wb.getSheet(sheetName);
		int rowCount = s1.getLastRowNum();
		int k=0;
		for(int i =1; i<=rowCount; i++)
		{
			if(s1.getRow(i).getCell(k).getStringCellValue().equals(Tc_Id))
			{
				int CellCount = s1.getRow(i).getLastCellNum();
				testdata = new String[CellCount];
				for(int j=0; j<=CellCount;j++)
				{
					testdata[j] = s1.getRow(i).getCell(j).getStringCellValue();
					
				}	
			}		
			
		}
		return testdata;
	}
	*/
}
