package com.horoscope.util;

import com.handlingSSO.PO.Handling_SSO_PO;
import com.horoscope.PO.*;
import com.recharge.PO.RechargeDemo_PO;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.html5.RemoteApplicationCache;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.util.LoadLibs;

/*import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apach
e.poi.ss.usermodel.Workbook;*/

public class Horoscope_baseLib 
{

	public static TouchAction touchAction;
	WebDriverWait wait;
	static Dimension size;
	static String scrShotDir = "screenshots";
	File ScrFile;
	static File scrShotDirPath = new java.io.File("./"+  scrShotDir + "//");
	static String destFile;
	static int count = 0;
	public static AndroidDriver<WebElement> driver;

	AppiumDriverLocalService appiumService = null;
	DesiredCapabilities capabilities= DesiredCapabilities.android();

	static public String sDirPath = System.getProperty("user.dir");	
	static public String sPropFileName = sDirPath+"\\configProperties.properties";


	//cross check
	//Handling_launcher_PO handling_launcher_PO=new Handling_launcher_PO(driver);



	//*****************************setting up the capabilities*******************************

	@BeforeClass
	public void appLaunch() throws IOException
	{

		/*String Appium_Node_Path="C:/Program Files (x86)/Appium/node.exe"; 
		String Appium_JS_Path="C:/Program Files (x86)/Appium/node_modules/appium/bin/appium.js"; 
		appiumService = AppiumDriverLocalService.buildService(new AppiumServiceBuilder().usingPort(4723).usingDriverExecutable(new File(Appium_Node_Path)).withAppiumJS(new File(Appium_JS_Path))); 
		appiumService.start();
		 */			
		capabilities.setCapability(MobileCapabilityType.PLATFORM,Platform.ANDROID);
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,3000);
		capabilities.setCapability(MobileCapabilityType.PLATFORM,Horoscope_GenericLib.readConfigPropFile(sPropFileName, "PLATFORMNAME"));
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,Horoscope_GenericLib.readConfigPropFile(sPropFileName, "DeviceName"));
		capabilities.setCapability(MobileCapabilityType.VERSION,Horoscope_GenericLib.readConfigPropFile(sPropFileName, "PLATFORMVERSION"));
//		capabilities.setCapability("appPackage", Horoscope_GenericLib.readConfigPropFile(sPropFileName, "packageName"));
//		capabilities.setCapability("appActivity",Horoscope_GenericLib.readConfigPropFile(sPropFileName, "activityName"));
		
		// for testing
		capabilities.setCapability("appPackage", "in.amazon.mShop.android.shopping");
		capabilities.setCapability("appActivity", "com.amazon.mShop.home.HomeActivity");;


		URL url= new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AndroidDriver<WebElement>(url, capabilities);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// testing purpose
		backButton(driver);
		backButton(driver);
		
// in.amazon.mShop.android.shopping
//	com.amazon.mShop.sso.SigninPromptActivity

	}

	//*******************************METHODS**************************************//

	public static void enterButton(AndroidDriver<WebElement> driver)
	{

		driver.pressKeyCode(AndroidKeyCode.ENTER);

	}
	public static void nextButton(AndroidDriver<WebElement> driver)
	{
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_MEDIA_NEXT);
	}
	public static void backButton(AndroidDriver<WebElement> driver)
	{
		(driver).pressKeyCode(AndroidKeyCode.BACK);
	}
	public static void homeButton(AndroidDriver<WebElement> driver)
	{
		(driver).pressKeyCode(AndroidKeyCode.HOME);
	}
	
	

	public static void handlingLauncherPopUp(WebDriver driver) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(By.className("android.widget.Button")));
		driver.findElement(By.xpath("//android.widget.RelativeLayout/android.widget.Button[@text='OK!']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("com.android.launcher3:id/tv_message_dialog_msg_1")));

		driver.findElement(By.xpath("//android.widget.RelativeLayout/android.widget.Button[@text='OK!']")).click();

		//performing the swipe operation

		size = driver.manage().window().getSize();
		//System.out.println(size);
		int startx = (int) (size.width * 0.70);
		int endx = (int) (size.width * 0.30);
		int starty = size.height / 2;
		int ourInt = (int) (size.width * 0.05);
		System.out.println("startx = " + startx + " ,endx = " + endx + " , starty = " + starty + ourInt);
		//Swipe from left to right
		touchAction = new TouchAction((PerformsTouchActions) driver);
		touchAction.press(endx,70).moveTo(3, 70).release().perform();
		//Swipe from right to left
		Thread.sleep(2000);
		touchAction.longPress(startx,70).moveTo(10, 70).release().perform();
		wait.until(ExpectedConditions.elementToBeClickable(By.className("android.view.ViewGroup")));
	}

	//	Launch from -1 screen 
	public static void lauchFromPillScreen(AppiumDriver<WebElement> driver,String appName)		
	{	
		pillScreen_PO pillScreen_PO=new pillScreen_PO((AppiumDriver<WebElement>) driver);
		touchAction = new TouchAction(driver);
		WebDriverWait wait = new WebDriverWait(driver,10);
	//	wait = new WebDriverWait(driver,10);			
		size = driver.manage().window().getSize();
		System.out.println(size);
		int startx = (int)(size.width * 0.80);
		int endx = (int)(size.width * 0.20);
		int starty = size.height/2;
		int endy = size.height/8;
		System.out.println("startx = " + startx + " ,endx = " + endx + " , starty = " + starty);
		//Swipe from left to right
		System.out.println("test is failing here ");
		//touchAction.press(endx,starty).moveTo(startx, starty).release().perform();
		touchAction.press(400,510).moveTo(630, 510).release().perform();

		if(appName=="Cricket")
		{
			pillScreen_PO.cricket().click();
		}
		if(appName=="Recharge")
		{
			pillScreen_PO.recharge().click();
		}
		if(appName=="Zomato")
		{
			pillScreen_PO.zomato().click();
		}
		if(appName=="Bus Tickets")
		{
			pillScreen_PO.busTickets().click();
		}
		if(appName=="News")
		{
			pillScreen_PO.news().click();
		}
		if(appName=="Rail Info")
		{
			pillScreen_PO.railInfo().click();
		}

	}
	//change DOB from my Zodiac
	// VALUE CHECK NEED TO BE ADDED
	public static void changeDobmyZodiac(AndroidDriver<WebElement> driver,String date,String month,String year)			
	{	
		change_date_PO DOB = new change_date_PO(driver);
		DOB.dd_DOB().sendKeys(date);
		DOB.mm_DOB().sendKeys(month);
		DOB.yyyy_DOB().sendKeys(year);
		backButton(driver);
		DOB.save_MZ().click();
	}	
	// change very first time DOB
	public static void changeVeryFirstDob(AndroidDriver<WebElement> driver,String date,String month,String year)			
	{	
		change_date_PO DOB = new change_date_PO(driver);
		my_Zodiac_PO my_Zodiac_PO=new my_Zodiac_PO(driver);
		my_Zodiac_PO.veryFirstDD().sendKeys(date);
		my_Zodiac_PO.veryFirstMM().sendKeys(month);
		my_Zodiac_PO.veryFirstYYYY().sendKeys(year);
		backButton(driver);
		my_Zodiac_PO.Save_myZodiac.click();
	}

	//change DOB from setting
	public static void changeDOBsetting(AndroidDriver<WebElement> driver,String date,String month,String year)			
	{
		change_date_PO DOB = new change_date_PO(driver);
		DOB.settingIcon().click();
		DOB.dobIcon().click();

		DOB.dd_DOB().clear();
		DOB.mm_DOB().clear();
		DOB.yyyy_DOB().clear();

		DOB.dd_DOB().sendKeys(date);
		DOB.mm_DOB().sendKeys(month);
		DOB.yyyy_DOB().sendKeys(year);
		DOB.save_MZ().click();
		backButton(driver);

	}

	//test.horoscope lauch from laucher
	public static void horoscopeLaucherclick(AndroidDriver<WebElement> driver)		
	{	
		my_Zodiac_PO my_Zodiac_PO=new my_Zodiac_PO(driver);
		WebDriverWait wait = new WebDriverWait(driver,10);
//		wait = new WebDriverWait(driver,5);
		WebElement horoscope = driver.findElement(By.xpath("//android.view.ViewGroup[@index='0']/android.widget.TextView[@text ='Horoscope']"));	
		horoscope.click();

		wait.until
		(ExpectedConditions.visibilityOfElementLocated
				(By.xpath("//android.view.ViewGroup")));

		try {
			if(my_Zodiac_PO.firstTimeUser().isDisplayed())
			{	
				changeVeryFirstDob(driver, "11", "08", "1906");

			}
			else
			{
				System.out.println("");
			}

			/*wait.until
			(ExpectedConditions.elementToBeClickable
					(By.xpath("//android.view.ViewGroup[@index='0']/android.widget.TextView[@text='ALL ZODIACS']")));*/
		} catch (Exception e) {
			//e.printStackTrace();
		}
	}

	// Handling Dynaic Drop Down
	public static void handlingDynamicDropDown(AndroidDriver<WebElement> driver,List<WebElement> dropDownPath,String cityName)			
	{
		List<WebElement> locations = dropDownPath;
		//System.out.println(locations.size());

		for(int i=0;i<locations.size();i++){
			WebElement option = locations.get(i);
			String city=option.getText();
			//System.out.println("cities suggested is "  +city);
			if(city.contentEquals(cityName)) {
				driver.pressKeyCode(AndroidKeyCode.BACK);
				option.click();
				//System.out.println("value from drop down is " +option);
				break;
			}
			//System.out.println("value from drop down is "   +city);
		}
	}

	// click from the app drawer
	public static void appDrawerApp(AndroidDriver<WebElement> driver,String appName)			
	{	

		WebElement app_Drawer = driver.findElement(By.xpath("//android.view.ViewGroup[@index='1']/android.widget.TextView[@index='3']"));
		app_Drawer.click();

		List<WebElement> applications = driver.findElements(By.xpath("//android.support.v7.widget.RecyclerView/android.widget.TextView"));
		System.out.println(applications.size());
		String app_Name=appName;

		boolean status = false;

		for(int i = 0;i<applications.size();i++)
		{	
			WebDriverWait wait = new WebDriverWait(driver,3);
			WebElement app_element = applications.get(i);
			String app_name=app_element.getText();
			System.out.println(app_name);
			if(app_name.contentEquals(app_Name))
			{
				app_element.click();
				wait.until
				(ExpectedConditions.visibilityOfElementLocated
						(By.xpath("//android.view.ViewGroup")));
				// handling very first time

				try {
					my_Zodiac_PO my_Zodiac_PO=new my_Zodiac_PO(driver);
					if(my_Zodiac_PO.firstTimeUser().isDisplayed())
					{	
						changeVeryFirstDob(driver, "11", "08", "1906");

					}
					else
					{
						System.out.println("");
					}

					/*wait.until
					(ExpectedConditions.elementToBeClickable
							(By.xpath("//android.view.ViewGroup[@index='0']/android.widget.TextView[@text='ALL ZODIACS']")));*/
				} catch (Exception e) {
					//e.printStackTrace();
				}

				status = true;
				break;
			}
			//System.out.println(status);
		}
		if(status==false)
		{	
			touchAction = new TouchAction((PerformsTouchActions) driver);
			WebDriverWait wait = new WebDriverWait(driver,3);
			//touchAction.longPress(10,1200).moveTo(10, 10).release().perform();
			//this has to be generalised
			touchAction.longPress(10 ,600).moveTo(10, 10).release().perform();
			List<WebElement> applications_1 = driver.findElements(By.xpath("//android.support.v7.widget.RecyclerView/android.widget.TextView"));
			System.out.println(applications_1.size());

			for(int i = 0;i<applications_1.size();i++)
			{	
				WebElement app_element = applications_1.get(i);
				String app_name=app_element.getText();
				System.out.println(app_name);
				if(app_name.contentEquals(app_Name))
				{
					app_element.click();
					wait.until
					(ExpectedConditions.visibilityOfElementLocated
							(By.xpath("//android.view.ViewGroup")));
					status = true;
					break;
				}
				System.out.println(status);
			}
		}	
	}

	// Read Toast message
	public  static String readToastMessage(AndroidDriver<WebElement> driver) throws Exception
	{	
		String imgName = takeScreenshot(driver);
		String result = null;
		File imageFile = new File(scrShotDirPath , imgName);
		// System.out.print("Image name is "+ imageFile.toString());
		ITesseract instance = new Tesseract();

		File testDatFolder = LoadLibs.extractTessResources("testdat");
		instance.setDatapath(testDatFolder.getAbsolutePath());

		result = instance.doOCR(imageFile);
		System.out.println(result);
		return result;	
	}

	public static String takeScreenshot(AndroidDriver<WebElement> driver)
	{	
		File scrfile= driver.getScreenshotAs(OutputType.FILE);

		SimpleDateFormat dateformat = new SimpleDateFormat("dd-MMM-YYYY___hh_mm_ssaa");
		new File(scrShotDir).mkdirs();

		destFile=dateformat.format(new Date()) + ".png"; 

		try{
			FileUtils.copyFile(scrfile, new File(scrShotDir  +  "/" + destFile));
		}catch (IOException e)
		{
			System.out.println("Image not transferred");
			e.printStackTrace();
		}//
		return destFile;

	}

	// Assert code for all zodiac tab
	public static void allZodiacSoftAssert(AndroidDriver<WebElement> driver,String zodiac_name, All_zodiac_PO all_zodiac_PO) throws Exception
	{		

		WebDriverWait wait = new WebDriverWait(driver,1);
		boolean expectedDisplayed = true;
		boolean actualDisplayed = false;

		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.ViewGroup/android.widget.TextView[@text='PERSONAL LIFE']")));
			
			if(all_zodiac_PO.personalLifeTab().isDisplayed())
			{
				actualDisplayed = true;
			}	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//			e.printStackTrace();
		}
		if(expectedDisplayed!=actualDisplayed)
		{
			System.out.println(zodiac_name +" zodiac data is not displayed");
		}
		(driver).pressKeyCode(AndroidKeyCode.BACK);	
		Assert.assertEquals(actualDisplayed, true ,zodiac_name+"	data is not displayed");
	}

	// waiting for the zodiac data to get displayed 
	public static void waitForZodiacData(AndroidDriver<WebElement> driver) throws Exception
	{		
		All_zodiac_PO all_zodiac_PO=new All_zodiac_PO(driver);
		WebDriverWait wait = new WebDriverWait(driver,4);
		boolean expectedDisplayed = true;
		boolean actualDisplayed = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.ViewGroup/android.widget.TextView[@text='PERSONAL LIFE']")));
			if(all_zodiac_PO.personalLifeTab().isDisplayed())
			{
				actualDisplayed = true;
			}	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(expectedDisplayed!=actualDisplayed)
		{
			System.out.println(" zodiac data is not displayed");
		}
		(driver).pressKeyCode(AndroidKeyCode.BACK);		
	}

	public static void handlingSSO(AndroidDriver<WebElement> driver) throws Exception
	{		
			Handling_SSO_PO handling_SSO_PO = new Handling_SSO_PO(driver);
			//handling_SSO_PO.appDrawer().click();
			appDrawerApp(driver, "Settings");
			
			touchAction = new TouchAction((PerformsTouchActions) driver);
			touchAction.longPress(200 ,750).moveTo(200,150).release().perform();
			
			for(int i=0;i<=2;i++)
				{
			if(handling_SSO_PO.accountsOption().isDisplayed())
			{
				handling_SSO_PO.accountsOption().click();			
			}else
			{
				touchAction.longPress(200 ,750).moveTo(200,150).release().perform();
			}
				}
	}

	public static void performingRecharge(AndroidDriver<WebElement> driver,String Number,String amount) throws Exception
	{		
			RechargeDemo_PO rechargeDemo_PO = new RechargeDemo_PO(driver);
			WebDriverWait wait = new WebDriverWait(driver,5);
			appDrawerApp(driver, "Recharge");
			
			rechargeDemo_PO.mobileNumberfield().clear();
			rechargeDemo_PO.mobileNumberfield().sendKeys(Number);
			rechargeDemo_PO.selectOperator().click();
			wait.until
			(ExpectedConditions.visibilityOfElementLocated
					(By.xpath("//android.view.ViewGroup")));
			
			rechargeDemo_PO.operatorSelect().click();
			wait.until
			(ExpectedConditions.visibilityOfElementLocated
					(By.xpath("//android.view.ViewGroup")));
			
			rechargeDemo_PO.circleSelect().click();
			rechargeDemo_PO.amountField().clear();
			rechargeDemo_PO.amountField().sendKeys(amount);
			
			rechargeDemo_PO.rechargeButton().click();
			wait.until
			(ExpectedConditions.visibilityOfElementLocated
					(By.xpath("//android.view.ViewGroup")));
			wait.until
			(ExpectedConditions.visibilityOfElementLocated
					(By.xpath("//android.view.ViewGroup")));
			
			WebElement element = driver.findElement(By.xpath("//android.view.ViewGroup[@index=4]/android.view.ViewGroup[@index=0]")); 
			boolean actual = element.isDisplayed();
			String rechrgeStatus1 = "Recharge successful";
			String rechrgeStatus2 = driver.findElement(By.xpath("//android.view.ViewGroup[@index=0]/android.widget.TextView")).getText();
			
			(driver).pressKeyCode(AndroidKeyCode.HOME);
			
			Assert.assertEquals(rechrgeStatus2, rechrgeStatus1);
			
			//for consideration
			
			//click on the browse plans
			//driver.findElement(By.xpath("//android.view.ViewGroup[@index=6]/android.view.ViewGroup[@index=2]/android.widget.TextView[@text='Browse Plans']")).click();
			//wait.until
			//(ExpectedConditions.visibilityOfElementLocated
			//		(By.xpath("//android.view.ViewGroup")));
			//click on one of the plan
			//driver.findElement(By.xpath("//android.widget.ScrollView[@index=0]/android.view.ViewGroup[@index=0]/android.view.ViewGroup[@index=0]")).click();
			//wait.until
			//(ExpectedConditions.visibilityOfElementLocated
			//		(By.xpath("//android.view.ViewGroup")));
	}
	
	
	
	
	
	




}
