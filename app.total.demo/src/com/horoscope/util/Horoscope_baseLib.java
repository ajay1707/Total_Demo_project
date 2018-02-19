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
		capabilities.setCapability("appActivity", "com.amazon.mShop.home.HomeActivity");


		URL url= new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AndroidDriver<WebElement>(url, capabilities);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// testing purpose
		backButton(driver);
		backButton(driver);

		// in.amazon.mShop.android.shopping
		//	com.amazon.mShop.sso.SigninPromptActivit
	}

	
	//*******************************METHODS**************************************//

	//*******************************Enter Button**************************************//
	
	public static void enterButton(AndroidDriver<WebElement> driver)
	{
		driver.pressKeyCode(AndroidKeyCode.ENTER);
	}
	
	//*******************************Next Button**************************************//
	
	public static void nextButton(AndroidDriver<WebElement> driver)
	{
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_MEDIA_NEXT);
	}
	
	//*******************************Back Button**************************************//
	
	public static void backButton(AndroidDriver<WebElement> driver)
	{
		(driver).pressKeyCode(AndroidKeyCode.BACK);
	}
	
	//*******************************Home Button**************************************//
	
	public static void homeButton(AndroidDriver<WebElement> driver)
	{
		(driver).pressKeyCode(AndroidKeyCode.HOME);
	}

	//*******************************Handling the Launcher Onboarding**************************************//

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

	//*******************************Launch from the -1 screen (under work)**************************************//
	
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

	//*******************************CHANGE THE DATE OF BIRTH**************************************//
	
	public static void changeDobmyZodiac(AndroidDriver<WebElement> driver,String date,String month,String year)			
	{	
		change_date_PO DOB = new change_date_PO(driver);
		DOB.dd_DOB().sendKeys(date);
		DOB.mm_DOB().sendKeys(month);
		DOB.yyyy_DOB().sendKeys(year);
		backButton(driver);
		DOB.save_MZ().click();
	}	
	
	//*******************************CHANGE THE DATE OF BIRTH (VERY FIRST TIME)**************************************//
	
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

	//*******************************CHANGE THE DATE OF BIRTH**************************************//
	
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

	//*******************************CLICK ON THE HOROSCOPE ICON FROM LAUNCHER**************************************//
	
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

	//*******************************METHOD FOR HANDLING THE DYNAMIC DROP DOWN**************************************//
	
	public static void handlingDynamicDropDown(AndroidDriver<WebElement> driver,List<WebElement> dropDownPath,String cityName)			
	{	
		WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until
		(ExpectedConditions.visibilityOfElementLocated
				(By.xpath("//android.view.ViewGroup[@index='0']/android.view.ViewGroup/android.widget.TextView")));
		//backButton(driver);		
		List<WebElement> locations = dropDownPath;
		//System.out.println(locations.size());

		for(int i=0;i<locations.size();i++){
			WebElement option = locations.get(i);
			String city=option.getText();
			System.out.println("cities suggested is "  +city);
			if(city.contentEquals(cityName)) {
			backButton(driver);
				option.click();
				//System.out.println("value from drop down is " +option);
				break;
			}
		}
	}

	//*******************************METHOD FOR LAUNCHING THE APP FROM THE APP DRAWER**************************************//
	
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
			WebDriverWait wait = new WebDriverWait(driver,5);
			WebElement app_element = applications.get(i);
			String app_name=app_element.getText();
			System.out.println(app_name);
			if(app_name.contentEquals(app_Name))
			{
				app_element.click();
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				// this code need to be generallized
				/*wait.until
			(ExpectedConditions.visibilityOfElementLocated
						(By.xpath("//android.view.ViewGroup")));
				*/// handling very first time

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
			touchAction.longPress(10 ,750).moveTo(10, 10).release().perform();
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
					//****THIS WE HABE TO GENERALIZE DEPENDING UPON THE UIz
					/*wait.until
					(ExpectedConditions.visibilityOfElementLocated
							(By.xpath("//android.view.ViewGroup")));*/
					status = true;
					break;
				}
				//System.out.println(status);
			}
		}	
	}

	//*******************************METHOD FOR READING THE TOAST MESSAGE (UNDER CONSTRUCTION)**************************************//
	
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

	//*******************************METHOD FOR TAKING THE SCREEN SHOT**************************************//
	
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

	//*******************************METHOD FOR CHECKING THE ZODIAC DATA CAN BE DISPLAYED OR NOT(CAN BE GENERALISED)**************************************//
	
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

	//*******************************METHOD FOR CHECKING THE ZODIAC DATA CAN BE DISPLAYED OR NOT(CAN BE GENERALISED)**************************************//
	
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
	
	//*******************************DELETING THE HIKE ACCOUNT FROM THE SETTINGS(UNDER CONSTRUCTION)**************************************//
	
	public static void deleteHikeFromSetting(AndroidDriver<WebElement> driver) throws Exception
	{		
		WebDriverWait wait = new WebDriverWait(driver,15);
		boolean status = false;
		homeButton(driver);
		
		// this code is for removal of account from the settings
		
		Handling_SSO_PO handling_SSO_PO = new Handling_SSO_PO(driver);
		appDrawerApp(driver, "Settings");

		touchAction = new TouchAction((PerformsTouchActions) driver);
		touchAction.longPress(200 ,750).moveTo(200,50).release().perform();
		
		for (int i = 0;i<=5;i++)
		{
		try {
			status = handling_SSO_PO.accountsOption().isDisplayed();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			if(status)
			{
				handling_SSO_PO.accountsOption().click();	
				break;
			}else
			{
				touchAction.longPress(200 ,750).moveTo(200,150).release().perform();
			}
		}
		//account click
		driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView[@text='TOTAL built by hike']")).click();
		//three dots click
		driver.findElement(By.xpath("//android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout")).click();
		//click on remove account
		driver.findElement(By.xpath("//android.widget.ListView/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView[@text='Remove account']")).click();
		// click on remove account dialog box
		driver.findElement(By.xpath("//android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button[@text='REMOVE ACCOUNT']")).click();
		
		wait.until
		(ExpectedConditions.visibilityOfElementLocated
				(By.xpath("//android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.Button[@text='OK']")));
		// click on the ok button of the dialog box
		driver.findElement(By.xpath("//android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.Button[@text='OK']")).click();
		
		homeButton(driver);
		
		//log in to the hike
		appDrawerApp(driver, "hike");
		//click on the sign in
		wait.until
		(ExpectedConditions.visibilityOfElementLocated
				(By.xpath("//android.widget.LinearLayout")));
	}
		
	//*******************************HANDLING THE SSO GATEWAY LOG IN**************************************//
	
	public static void SSOgateLogIn(AndroidDriver<WebElement> driver) throws Exception	
	{
	
		WebDriverWait wait = new WebDriverWait(driver,10);
		//click on the sign in button
		driver.findElement(By.xpath("//android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.Button[@text='SIGN IN']")).click();
		//click on the confirm
		driver.findElement(By.xpath("//android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.Button[@text='CONFIRM']")).click();
		
		wait.until
		(ExpectedConditions.visibilityOfElementLocated
				(By.xpath("//android.widget.RelativeLayout/android.widget.TextView[@text='ADD FRIENDS']")));
		
		driver.findElement(By.xpath("//android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/android.support.v7.widget.LinearLayoutCompat/android.widget.TextView[@text='SKIP']")).click();	
	}
	
	//*******************************POSITIVE FLOW FOR RECHARGEW APP**************************************//
	
	public static void performingRecharge(AndroidDriver<WebElement> driver,String Number,String amount) throws Exception
	{		
		RechargeDemo_PO rechargeDemo_PO = new RechargeDemo_PO(driver);
		WebDriverWait wait = new WebDriverWait(driver,10);
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
		/*
			touchAction = new TouchAction((PerformsTouchActions) driver);
			touchAction.longPress(200 ,750).moveTo(200,150).release().perform();
		 */
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

	//*******************************PERFORMING THE KUNDALI MATCH**************************************//
	
	public static void kundaliMatchHoroscope(AndroidDriver<WebElement> driver) throws Exception

	{
		
				////excel sheet integration can be done in this code
				WebDriverWait wait = new WebDriverWait(driver,5);
				Kundali_match_PO kundali_match_PO=new Kundali_match_PO(driver);
				kundali_match_PO.tab_Kundali().click();
				wait.until(ExpectedConditions.elementToBeClickable(By.className("android.view.ViewGroup")));

				kundali_match_PO.male_Name().sendKeys(Horoscope_GenericLib.readExcelData(2,2));
				enterButton(driver);
				kundali_match_PO.male_DOB_dd().sendKeys(Horoscope_GenericLib.readExcelData(3,2));
				kundali_match_PO.male_DOB_mm().sendKeys(Horoscope_GenericLib.readExcelData(3,3));
				kundali_match_PO.male_DOB_yyyy().sendKeys(Horoscope_GenericLib.readExcelData(3,4));
				kundali_match_PO.male_DOB_hr().sendKeys(Horoscope_GenericLib.readExcelData(4,2));
				kundali_match_PO.male_DOB_min().sendKeys(Horoscope_GenericLib.readExcelData(4,3));
				kundali_match_PO.male_cityname().sendKeys(Horoscope_GenericLib.readExcelData(5,2));

				List<WebElement> dropdownPath = driver.findElements(By.xpath("//android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='13']/android.widget.TextView"));
				handlingDynamicDropDown(driver, dropdownPath, "Gursarai");

				kundali_match_PO.f_name.sendKeys("raman");
				wait.until(ExpectedConditions.elementToBeClickable(By.className("android.view.ViewGroup")));
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				enterButton(driver);

				kundali_match_PO.female_DOB_dd().sendKeys("17");
				kundali_match_PO.female_DOB_mm().sendKeys("01");
				kundali_match_PO.female_DOB_yyyy().sendKeys("1997");
				kundali_match_PO.female_DOB_hr().sendKeys("11");
				kundali_match_PO.female_DOB_min().sendKeys("34");

				driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
				nextButton(driver);
				kundali_match_PO.f_cityname.sendKeys("gur");
				wait.until(ExpectedConditions.elementToBeClickable(By.className("android.view.ViewGroup")));

				List <WebElement> dropDownPathFemale=driver.findElements(By.xpath("//android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='26']/android.widget.TextView"));
				handlingDynamicDropDown(driver, dropDownPathFemale, "Gursarai");
				/*wait.until
				(ExpectedConditions.visibilityOfElementLocated
						(By.xpath("//android.view.ViewGroup")));*/
				
				//wait.until(ExpectedConditions.elementToBeClickable(By.className("android.widget.EditText")));
				kundali_match_PO.save_button().click();
				wait.until
				(ExpectedConditions.visibilityOfElementLocated
						(By.xpath("//android.view.ViewGroup")));
				homeButton(driver);
	}





}
