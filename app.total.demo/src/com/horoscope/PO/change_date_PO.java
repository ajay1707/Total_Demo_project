package com.horoscope.PO;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumDriver;


	
	public class change_date_PO {

		AppiumDriver driver;
		
		public change_date_PO(AppiumDriver driver) 
		{
			this.driver = driver;
			PageFactory.initElements(driver, this);
			//PageFactory.initElements(new AppiumFieldDecorator(driver, 10, TimeUnit.SECONDS), this);
		
		}
		
		
		
		@FindBy(how=How.XPATH,using="//android.view.ViewGroup[@index='1']/android.widget.ImageView[@index='0']")
		public WebElement Setting;
		
		public WebElement settingIcon()
		{
			return Setting;
		}
		
		
		@FindBy(how=How.XPATH,using="//android.view.ViewGroup[@index='1']//android.view.ViewGroup[@index='0']/android.widget.TextView[@text='Date of Birth']")
		public WebElement DOB_icon;
		
		public WebElement dobIcon()
		{
			return DOB_icon;
		}
		
		@FindBy(how=How.XPATH,using="//android.view.ViewGroup[@index='0']/android.widget.EditText[@index='4']")
		public WebElement DD_DOB;
		
		public WebElement dd_DOB()
		{
			return DD_DOB;
		}
		
		@FindBy(how=How.XPATH,using="//android.view.ViewGroup[@index='0']/android.widget.EditText[@index='5']")
		public WebElement MM_DOB;
		
		public WebElement mm_DOB()
		{
			return MM_DOB;
		}
		
		@FindBy(how=How.XPATH,using="//android.view.ViewGroup[@index='0']/android.widget.EditText[@index='6']")
		public WebElement YYYY_DOB;
		
		public WebElement yyyy_DOB()
		{
			return YYYY_DOB;
					
		}
		
		@FindBy(how=How.XPATH,using="//android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='7']")
		public WebElement Save_myZodiac;
		
		public WebElement save_MZ()
		{
			return Save_myZodiac;
		}
		
		
	}	


