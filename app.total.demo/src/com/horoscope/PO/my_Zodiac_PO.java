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


	
	public class my_Zodiac_PO 
	{

		AppiumDriver driver;
		
		public my_Zodiac_PO(AppiumDriver driver) 
		{
			this.driver = driver;
			PageFactory.initElements(driver, this);
			//PageFactory.initElements(new AppiumFieldDecorator(driver, 10, TimeUnit.SECONDS), this);
		}
		
		@FindBy(how=How.XPATH,using="//android.view.ViewGroup[@index='1']/android.view.ViewGroup[@index='8']/android.view.ViewGroup[@text='Skip']")
		public WebElement FirstTimeSkipButton;
		
		public WebElement firstTimeSkipButton()
		{
			return FirstTimeSkipButton;
		}
		
		@FindBy(how=How.XPATH,using="//android.view.ViewGroup[@index='1']/android.widget.EditText[@text='dd']")
		private WebElement VeryFirstDD;
		
		public WebElement veryFirstDD()
		{
			return VeryFirstDD;
		}
		
		@FindBy(how=How.XPATH,using="//android.view.ViewGroup[@index='1']/android.widget.EditText[@text='mm']")
		private WebElement VeryFirstMM;
		
		public WebElement veryFirstMM()
		{
			return VeryFirstMM;
		}
		
		@FindBy(how=How.XPATH,using="//android.view.ViewGroup[@index='1']/android.widget.EditText[@text='yyyy']")
		private WebElement VeryFirstYYYY;
		
		public WebElement veryFirstYYYY()
		{
			return VeryFirstYYYY;
		}
		
	
		
		
		@FindBy(how=How.XPATH,using="//android.view.ViewGroup[@index='1']/android.widget.EditText[@text='dd']")
		private WebElement FirstTimeUser;
		
		public WebElement firstTimeUser()
		{
			return FirstTimeUser;
		}
		
		
		@FindBy(how=How.XPATH,using="//android.widget.HorizontalScrollView[@index='2']/android.view.ViewGroup/android.widget.TextView[@text='MY ZODIAC']")
		public WebElement Tab_myZodiac;
		
		public WebElement tab_myZodiac()
		{
			return Tab_myZodiac;
		}
		
		
		@FindBy(how=How.XPATH,using="//android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='0']/android.widget.EditText[@index='4']")
		public WebElement dd_myZodiac;
		
		public WebElement dd_MZ()
		{
			return dd_myZodiac;
		}
		
		@FindBy(how=How.XPATH,using="//android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='0']/android.widget.EditText[@index='5']")
		public WebElement mm_myZodiac;
		
		public WebElement mm_MZ()
		{
			return mm_myZodiac;
		}
		
		@FindBy(how=How.XPATH,using="//android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='0']/android.widget.EditText[@index='6']")
		public WebElement yy_myZodiac;
		
		public WebElement yy_MZ()
		{
			return yy_myZodiac;
		}
		
		@FindBy(how=How.XPATH,using="//android.view.ViewGroup[@index='1']/android.view.ViewGroup[@index='7']")
		public WebElement Save_myZodiac;
		
		public WebElement save_MZ()
		{
			return Save_myZodiac;
		}
		
		
		
	}	


