package com.handlingSSO.PO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class Handling_SSO_PO
{
		AppiumDriver driver;


		public Handling_SSO_PO(AppiumDriver driver) 
		{
			this.driver = driver;
			PageFactory.initElements(driver, this);
			//PageFactory.initElements(new AppiumFieldDecorator(driver, 10, TimeUnit.SECONDS), this);
		}
		
		@FindBy(how=How.XPATH,using="//android.view.ViewGroup[@index='0']/android.widget.TextView[@text='ARIES']")
		private WebElement Ariesbutton;
		
		public WebElement Aries()
		{
			return Ariesbutton;
		}
		
		@FindBy(how=How.XPATH,using="//android.view.ViewGroup[@index='1']/android.widget.TextView[@index='3']")
		private WebElement AppDrawer;
		
		public WebElement appDrawer()
		{
			return AppDrawer;
		}
		
		@FindBy(how=How.XPATH,using="//android.support.v7.widget.RecyclerView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[@text='Accounts']")
		private WebElement AccountsOption;
		
		public WebElement accountsOption()
		{
			return AppDrawer;
		}
		
		
		

	}
	
	
	
