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


	
	public class Handling_launcher_PO {
		
		AppiumDriver driver;
		public Handling_launcher_PO(AppiumDriver driver) 
		{
			this.driver = driver;
			PageFactory.initElements(driver, this);
			//PageFactory.initElements(new AppiumFieldDecorator(driver, 10, TimeUnit.SECONDS), this);
		}

		@FindBy(how=How.ID,using="com.android.launcher3:id/btn_star_dialog_ok")
		public WebElement ok_button;
		public WebElement popupOkButton()
		{
			return ok_button;
		}
		
		@FindBy(how=How.ID,using="com.android.launcher3:id/btn_messaging_dialog_ok")
		public WebElement Ok_button;
		public WebElement messageOkButton()
		{
			return Ok_button;
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
		
		
		
		
		
		
	}	


