package test.horoscope;
import static com.horoscope.util.Horoscope_baseLib.touchAction;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.horoscope.PO.All_zodiac_PO;
import com.horoscope.PO.Kundali_match_PO;
import com.horoscope.PO.my_Zodiac_PO;
import com.horoscope.util.Horoscope_baseLib;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;

public class Total_horoscope extends Horoscope_baseLib
{	
	Dimension size;
	static Logger log = Logger.getLogger(Total_horoscope.class.getName());


	
	@Test(priority=1,description="code for handling the creo laucher activity")
	public static void handlingLauncher() throws Exception
	{
		handlingSSO(driver);
		log.info("Launcher activity is handled");
	}

	
	
	
/*
	@Test(priority=1,description="code for handling the creo laucher activity")
	public static void handlingLauncher() throws Exception
	{
		handlingLauncherPopUp(driver);
		log.info("Launcher activity is handled");
	}
*/
/*
	@Test(priority=3,description="Handling SSO")
	public static void handlingSSOlogin() throws Exception
	{
		handlingSSO(driver);
		log.info("Launcher activity is handled");
	}
*/
	
	@Test(priority=2,description="performing the Recharge")
	public static void performingRechargeApp() throws Exception
	{
		log.info("performing recharge");
		performingRecharge(driver,"9781909676","04");	
		// performing
	}



	@Test(priority=3,description="Launch Horoscope from the App drawer")
	public static void LaunchingFromAppDrawer() throws Exception
	{
		appDrawerApp(driver, "Horoscope");
	}

/*
	@Test(priority=2,description="code for launching the test.horoscope from -1 screen")
	public static void LaunchingFromPillScreen() throws Exception
	{
		lauchFromPillScreen(driver,"Recharge");
	}
*/

/*
	@Test(priority=2,description="click on the Horoscope from Launcher")
	public  void horoscopeLaucher() throws Exception
	{
		horoscopeLaucherclick(driver);
	}
*/


	// we need to reconsider the code
	@Test(priority=4,description="click on My Zodiac tab")
	public static void myZodiacTab()
	{
		my_Zodiac_PO my_Zodiac_PO=new my_Zodiac_PO(driver);
		my_Zodiac_PO.tab_myZodiac().click();
		try {
			if(my_Zodiac_PO.firstTimeUser().isDisplayed())
			{	
				Horoscope_baseLib.changeDobmyZodiac(driver, "11", "08", "1906");
				waitForZodiacData(driver);
			}
			else
			{
				System.out.println();
				// we have to add retry logic
			}
		} catch (Exception e) {
			//e.printStackTrace();
		}	
	}

	@Test(priority=5,description="click on setting (change DOB) icon")
	public static void DOBsetting()
	{
		changeDOBsetting(driver,"11", "11","2011");
	}

	@Test(priority=6,description="all zodiac tab select")
	public void allZodiacTabSelect() throws Exception
	{	
		All_zodiac_PO all_zodiac_PO=new All_zodiac_PO(driver);
		all_zodiac_PO.tabAllZodiacs().click();
	}	
	@Test(priority=7,description="ariesDataDisplayed")
	public void ariesDataDisplayed() throws Exception
	{
		All_zodiac_PO all_zodiac_PO=new All_zodiac_PO(driver);
		all_zodiac_PO.Aries().click();
		Horoscope_baseLib.allZodiacSoftAssert(driver, "Aries",all_zodiac_PO);
	}
	@Test(priority=8,description="taurusDataDisplayed")
	public void taurusDataDisplayed() throws Exception
	{
		All_zodiac_PO all_zodiac_PO=new All_zodiac_PO(driver);
		all_zodiac_PO.Taurus().click();
		Horoscope_baseLib.allZodiacSoftAssert(driver, "Taurus", all_zodiac_PO);
	}
	@Test(priority=8,description="geminiDataDisplayed")
	public void geminiDataDisplayed() throws Exception{
		All_zodiac_PO all_zodiac_PO=new All_zodiac_PO(driver);
		all_zodiac_PO.Gemini().click();
		Horoscope_baseLib.allZodiacSoftAssert(driver, "Gemini", all_zodiac_PO);
	}
	@Test(priority=8,description="cancerDataDisplayed")
	public void cancerDataDisplayed() throws Exception{
		All_zodiac_PO all_zodiac_PO=new All_zodiac_PO(driver);
		all_zodiac_PO.Cancer().click();
		Horoscope_baseLib.allZodiacSoftAssert(driver, "cancer", all_zodiac_PO);
	}
	@Test(priority=9,description="leoDataDisplayed")
	public void leoDataDisplayed() throws Exception{
		All_zodiac_PO all_zodiac_PO=new All_zodiac_PO(driver);
		all_zodiac_PO.Leo().click();
		Horoscope_baseLib.allZodiacSoftAssert(driver, "Leo", all_zodiac_PO);
	}
	@Test(priority=10,description="virgoDataDisplayed")
	public void virgoDataDisplayed() throws Exception{
		All_zodiac_PO all_zodiac_PO=new All_zodiac_PO(driver);
		all_zodiac_PO.Virgo().click();
		Horoscope_baseLib.allZodiacSoftAssert(driver, "Virgo", all_zodiac_PO);
	}
	@Test(priority=11,description="libraDataDisplayed")
	public void libraDataDisplayed() throws Exception{
		All_zodiac_PO all_zodiac_PO=new All_zodiac_PO(driver);
		all_zodiac_PO.Libra().click();
		Horoscope_baseLib.allZodiacSoftAssert(driver, "Libra", all_zodiac_PO);
	}
	@Test(priority=12,description="scorpioDataDisplayed")
	public void scorpioDataDisplayed() throws Exception{
		All_zodiac_PO all_zodiac_PO=new All_zodiac_PO(driver);
		all_zodiac_PO.Scorpio().click();
		Horoscope_baseLib.allZodiacSoftAssert(driver, "ScorpioScorpio", all_zodiac_PO);
	}
	@Test(priority=13,description="saggitariusDisplayed")
	public void saggitariusDisplayed() throws Exception{
		All_zodiac_PO all_zodiac_PO=new All_zodiac_PO(driver);
		all_zodiac_PO.Saggitarius().click();
		Horoscope_baseLib.allZodiacSoftAssert(driver, "Saggitarius", all_zodiac_PO);
	}
	@Test(priority=14,description="capricornDataDisplayed")
	public void capricornDataDisplayed() throws Exception{
		All_zodiac_PO all_zodiac_PO=new All_zodiac_PO(driver);
		all_zodiac_PO.Capricorn().click();
		Horoscope_baseLib.allZodiacSoftAssert(driver, "Capricorn", all_zodiac_PO);
	}
	@Test(priority=15,description="aquariusDataDisplayed")
	public void aquariusDataDisplayed() throws Exception{
		All_zodiac_PO all_zodiac_PO=new All_zodiac_PO(driver);
		all_zodiac_PO.Aquarius().click();
		Horoscope_baseLib.allZodiacSoftAssert(driver, "Aquarius", all_zodiac_PO);
	}
	@Test(priority=16,description="piscesDataDisplayed")
	public void piscesDataDisplayed() throws Exception{
		All_zodiac_PO all_zodiac_PO=new All_zodiac_PO(driver);
		all_zodiac_PO.Pisces().click();
		Horoscope_baseLib.allZodiacSoftAssert(driver, "Pisces", all_zodiac_PO);
	}




	@Test(priority=17,description="KUNDALI MATCH ")
	public static void kundaliMatch() throws Exception
	{	
		
		kundaliMatchHoroscope(driver);
		
	}

}


