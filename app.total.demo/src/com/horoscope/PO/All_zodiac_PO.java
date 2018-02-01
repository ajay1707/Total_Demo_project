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



public class All_zodiac_PO {

	AppiumDriver driver;
	// the driver


	public All_zodiac_PO(AppiumDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		//PageFactory.initElements(new AppiumFieldDecorator(driver, 10, TimeUnit.SECONDS), this);

	}




	@FindBy(how=How.XPATH,using="//android.view.ViewGroup[@index='1']/android.view.ViewGroup[@index='0']/android.widget.ImageView[@index='0']")public WebElement backAllZodiacbutton;
	public WebElement BackAZ()
	{
		return backAllZodiacbutton;
	}

	@FindBy(how=How.XPATH,using="//android.widget.HorizontalScrollView[@index='2']/android.view.ViewGroup/android.widget.TextView[@text='ALL ZODIACS']")public WebElement TabAllZodiacs;
	public WebElement tabAllZodiacs()
	{
		return TabAllZodiacs;
	}

	@FindBy(how=How.XPATH,using="//android.view.ViewGroup[@index='0']/android.widget.TextView[@text='ARIES']")
	private WebElement Ariesbutton;
	
	public WebElement Aries()
	{
		return Ariesbutton;
	}

	@FindBy(xpath="//android.view.ViewGroup[@index='1']/android.widget.TextView[@index=1 and @text='TAURUS']")
	private WebElement Taurusbutton;

	public WebElement Taurus()
	{
		return Taurusbutton;
	}

	@FindBy(xpath="//android.view.ViewGroup[@index='2']/android.widget.TextView[@index=1 and @text='GEMINI']")
	private WebElement Geminibutton;

	public WebElement Gemini()
	{
		return Geminibutton;
	}

	@FindBy(xpath="//android.view.ViewGroup[@index='3']/android.widget.TextView[@index=1 and @text='CANCER']")
	private WebElement Cancerbutton;

	public WebElement Cancer()
	{
		return Cancerbutton;
	}

	@FindBy(xpath="//android.view.ViewGroup[@index='4']/android.widget.TextView[@index=1 and @text='LEO']")
	private WebElement Leobutton;

	public WebElement Leo()
	{
		return Leobutton;
	}

	@FindBy(xpath="//android.view.ViewGroup[@index='5']/android.widget.TextView[@index=1 and @text='VIRGO']")
	private WebElement Virgobutton;

	public WebElement Virgo()
	{
		return Virgobutton;
	}

	@FindBy(xpath="//android.view.ViewGroup[@index='6']/android.widget.TextView[@index=1 and @text='LIBRA']")
	private WebElement Librabutton;

	public WebElement Libra()
	{
		return Librabutton;
	}

	@FindBy(xpath="//android.view.ViewGroup[@index='7']/android.widget.TextView[@index=1 and @text='SCORPIO']")
	private WebElement Scorpiobutton;

	public WebElement Scorpio()
	{
		return Scorpiobutton;
	}

	@FindBy(xpath="//android.view.ViewGroup[@index='8']/android.widget.TextView[@index=1 and @text='SAGITTARIUS']")
	private WebElement Saggittariusbutton;

	public WebElement Saggitarius()
	{
		return Saggittariusbutton;
	}

	@FindBy(xpath="//android.view.ViewGroup[@index='9']/android.widget.TextView[@index=1 and @text='CAPRICORN']")
	private WebElement Capricornbutton;

	public WebElement Capricorn()
	{
		return Capricornbutton;
	}

	@FindBy(xpath="//android.view.ViewGroup[@index='10']/android.widget.TextView[@index=1 and @text='AQUARIUS']")
	private WebElement Aquariusbutton;

	public WebElement Aquarius()
	{
		return Aquariusbutton;
	}

	@FindBy(xpath="//android.view.ViewGroup[@index='11']/android.widget.TextView[@index=1 and @text='PISCES']")
	private WebElement Piscesbutton;

	public WebElement Pisces()
	{
		return Piscesbutton;
	}

	@FindBy(xpath="//android.view.ViewGroup/android.widget.TextView[@text='PERSONAL LIFE']")
	private WebElement PersonalLifeTab;

	public WebElement personalLifeTab()
	{
		return PersonalLifeTab;
	}


}	


