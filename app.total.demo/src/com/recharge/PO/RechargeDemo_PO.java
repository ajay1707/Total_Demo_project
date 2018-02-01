package com.recharge.PO;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class RechargeDemo_PO {

	AppiumDriver driver;
	// the driver


	public RechargeDemo_PO(AppiumDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how=How.XPATH,using="//android.view.ViewGroup[@index=4]/android.widget.EditText")
	private WebElement MobileNumberfield;
	
	public WebElement mobileNumberfield()
	{
		return MobileNumberfield;
	}
	
	@FindBy(how=How.XPATH,using="//android.view.ViewGroup[@index=5]/android.view.ViewGroup")
	private WebElement SelectOperator;
	
	public WebElement selectOperator()
	{
		return SelectOperator;
	}
	
	@FindBy(how=How.XPATH,using="//android.view.ViewGroup[@index=0]/android.view.ViewGroup[@index=0]/android.widget.TextView[@text='Airtel']")
	private WebElement OperatorSelect;
	
	public WebElement operatorSelect()
	{
		return OperatorSelect;
	}
	
	@FindBy(how=How.XPATH,using="//android.view.ViewGroup[@index=0]/android.view.ViewGroup[@index=0]/android.widget.TextView[@text='Delhi NCR']")
	private WebElement CircleSelect;
	
	public WebElement circleSelect()
	{
		return CircleSelect;
	}
	
	@FindBy(how=How.XPATH,using="//android.view.ViewGroup[@index=0]/android.view.ViewGroup[@index=12]/android.widget.TextView[@text='Punjab']")
	private WebElement CircleSelectPunjab;
	
	public WebElement circleSelectPunjab()
	{
		return CircleSelectPunjab;
	}
	
	@FindBy(how=How.XPATH,using="//android.view.ViewGroup[@index=6]/android.widget.EditText")
	private WebElement AmountField;
	
	public WebElement amountField()
	{
		return AmountField;
	}

	@FindBy(how=How.XPATH,using="//android.view.ViewGroup[@index=6]/android.view.ViewGroup[@index=2]/android.widget.TextView[@text='Browse Plans']")
	private WebElement BrowsePlansButton;
	
	public WebElement browsePlansButton()
	{
		return BrowsePlansButton;
	}

	@FindBy(how=How.XPATH,using="//android.widget.ScrollView[@index=0]/android.view.ViewGroup[@index=0]/android.view.ViewGroup[@index=0]")
	private WebElement TopUpPlan;
	
	public WebElement topUpPlan()
	{
		return TopUpPlan;
	}

	@FindBy(how=How.XPATH,using="//android.view.ViewGroup[@index=0]/android.view.ViewGroup[@index=7]")
	private WebElement RechargeButton;
	
	public WebElement rechargeButton()
	{
		return RechargeButton;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
