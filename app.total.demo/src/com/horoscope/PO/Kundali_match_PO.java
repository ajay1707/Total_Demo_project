package com.horoscope.PO;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import test.horoscope.Total_horoscope;


	
	public class Kundali_match_PO {

		AppiumDriver driver;
		
		public Kundali_match_PO(AppiumDriver driver) 
		{
			this.driver = driver;
			PageFactory.initElements(driver, this);
			//PageFactory.initElements(new AppiumFieldDecorator(driver, 10, TimeUnit.SECONDS), this);
		}
		@FindBy(how=How.XPATH,using="//android.view.ViewGroup/android.widget.TextView[@text='KUNDALI']")
		public WebElement Tab_Kundali;
		
		public WebElement tab_Kundali()
		{
			return Tab_Kundali;
		}
		
		@FindBy(how=How.XPATH,using="//android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='0']/android.widget.EditText[@index='3' and @text='Enter name here']")
		public WebElement mm_name;
		
		public WebElement male_Name()
		{
			return mm_name;
		}
		
		@FindBy(how=How.XPATH,using="//android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='0']/android.widget.EditText[@index='6' and @text='dd']")
		public WebElement m_DOB_dd;
		
		public WebElement male_DOB_dd()
		{
			return m_DOB_dd;
		}
		
		@FindBy(how=How.XPATH,using="//android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='0']/android.widget.EditText[@index='7' and @text='mm']")
		public WebElement m_DOB_mm;
		
		public WebElement male_DOB_mm()
		{
			return m_DOB_mm;
		}
		
		@FindBy(how=How.XPATH,using="//android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='0']/android.widget.EditText[@index='8' and @text='yyyy']")
		public WebElement m_DOB_yyyy;
		
		public WebElement male_DOB_yyyy()
		{
			return m_DOB_yyyy;
		}
		
		@FindBy(how=How.XPATH,using="//android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='0']/android.widget.EditText[@index='9' and @text='hr']")
		public WebElement m_DOB_hr;
		
		public WebElement male_DOB_hr()
		{
			return m_DOB_hr;
		}
		
		@FindBy(how=How.XPATH,using="//android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='0']/android.widget.EditText[@index='10' and @text='min']")
		public WebElement m_DOB_min;
		
		public WebElement male_DOB_min()
		{
			return m_DOB_min;
		}
		
		@FindBy(how=How.XPATH,using="//android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='0']/android.widget.EditText[@index='12' and @text='City Name']")
		public WebElement m_cityname;
		
		public WebElement male_cityname()
		{
			return m_cityname;
		}
		
		@FindBy(how=How.XPATH,using="//android.view.ViewGroup[@index='0']/android.widget.EditText[@index='16']")
		public WebElement f_name;
		
		public WebElement female_name()
		{
			return f_name;
		}
		
		@FindBy(how=How.XPATH,using="//android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='0']/android.widget.EditText[@index='19' and @text='dd']")
		public WebElement f_DOB_dd;
		
		public WebElement female_DOB_dd()
		{
			return f_DOB_dd;
		}
		
		@FindBy(how=How.XPATH,using="//android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='0']/android.widget.EditText[@index='20' and @text='mm']")
		public WebElement f_DOB_mm;
		
		public WebElement female_DOB_mm()
		{
			return f_DOB_mm;
		}
		
		@FindBy(how=How.XPATH,using="//android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='0']/android.widget.EditText[@index='21' and @text='yyyy']")
		public WebElement f_DOB_yyyy;
		
		public WebElement female_DOB_yyyy()
		{
			return f_DOB_yyyy;
		}
		
		@FindBy(how=How.XPATH,using="//android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='0']/android.widget.EditText[@index='22' and @text='hr']")
		public WebElement f_DOB_hr;
		
		public WebElement female_DOB_hr()
		{
			return f_DOB_hr;
		}
		
		@FindBy(how=How.XPATH,using="//android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='0']/android.widget.EditText[@index='23' and @text='min']")
		public WebElement f_DOB_min;
		
		public WebElement female_DOB_min()
		{
			return f_DOB_min;
		}
		
		@FindBy(how=How.XPATH,using="//android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='0']/android.widget.EditText[@index='25']")
		public WebElement f_cityname;
		
		public WebElement female_cityname()
		{
			return f_cityname;
		}
		
		@FindBy(how=How.XPATH,using="//android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='0']/android.view.ViewGroup/android.widget.TextView[@text='MATCH']")
		public WebElement Save_button;
		
		public WebElement save_button()
		{
			return Save_button;
		}
		
		
		
		
		
		
		
	}	


