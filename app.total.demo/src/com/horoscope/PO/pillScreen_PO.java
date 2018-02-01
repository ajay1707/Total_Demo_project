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


	
	public class pillScreen_PO {

		AppiumDriver driver;
		
		public pillScreen_PO(AppiumDriver driver) 
		{
			this.driver = driver;
			PageFactory.initElements(driver, this);
			//PageFactory.initElements(new AppiumFieldDecorator(driver, 10, TimeUnit.SECONDS), this);
		
		}
		
		
		
		@FindBy(how=How.XPATH,using="//android.widget.RelativeLayout[@index='0']")
		public WebElement Cricket;
		
		public WebElement cricket()
		{
			return Cricket;
		}
		
		
		@FindBy(how=How.XPATH,using="//android.widget.RelativeLayout[@index='2']")
		public WebElement Recharge;
		
		public WebElement recharge()
		{
			return Recharge;
		}
		
		@FindBy(how=How.XPATH,using="//android.widget.RelativeLayout[@index='4']")
		public WebElement Zomato;
		
		public WebElement zomato()
		{
			return Zomato;
		}
		
		@FindBy(how=How.XPATH,using="//android.widget.RelativeLayout[@index='5']")
		public WebElement BusTickets;
		
		public WebElement busTickets()
		{
			return BusTickets;
		}
		
		@FindBy(how=How.XPATH,using="//android.widget.RelativeLayout[@index='6']")
		public WebElement RailInfo;
		
		public WebElement railInfo()
		{
			return RailInfo;
					
		}
		
		@FindBy(how=How.XPATH,using="//android.widget.RelativeLayout[@index='7']")
		public WebElement News;
		
		public WebElement news()
		{
			return News;
					
		}
		
		@FindBy(how=How.XPATH,using="//android.widget.RelativeLayout[@index='3']")
		public WebElement Horoscope;
		
		public WebElement horoscope()
		{
			return Horoscope;
					
		}
		
		
		
	}	


