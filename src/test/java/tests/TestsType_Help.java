package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import pages.HelpPage;
import pages.HomePage;
import reusables.ReusableTestMethods;

public class TestsType_Help extends Test_BaseTest {
	private static Logger Log = (Logger) LogManager.getLogger(TestsType_Help.class);
	
	//17
	//HELPS
	@Test
	public void helpTypeNavigationTest() {
		extentTests=extent.startTest("testCase_helpTypeNavigationTest");
		Log.info("Start test - testCase_helpTypeNavigationTest");
		
		if(test_run.get("helpTypeNavigationTest").equals("y")) {
			//_________________________________________________
			initializeWebDriver();
			
			ReusableTestMethods reusable = new ReusableTestMethods();		
			reusable.loginTest(driver, vprop);
			Reporter.log("browser login and then site login");
			Log.info("browser login and then site login");
			HomePage hp = new HomePage(driver);
			utils.Waits.hardWait();
			hp.validatePageTitle();
			Reporter.log("navigated to home page");
			Log.info("navigated to home page");
			Assert.assertTrue(hp.validatePageTitle());
			hp.click_help();
			hp.switch_helpWindow();

			HelpPage help = new HelpPage(driver);
			Assert.assertTrue(help.validatePageTitle());
			Reporter.log("navigated to help page");
			Log.info("navigated to help page");
			help.switchFrame();
			utils.Waits.hardWait();
			
			
		// help_newBusBooking as being 1st help type thus all notifications are handled here.
			try {
				help.click_language_popup();
				help.click_newBusBookingHelp();
			} catch (Exception languageNotificationPopUp) {
				try {
					help.click_chooseEnglishOpt();
					help.click_setLanguage();
					Reporter.log("popups handled");
					Log.info("popups handled");
					help.click_newBusBookingHelp();
				} catch (Exception languageSelectPopUp) {
					help.click_newBusBookingHelp();
				}
			}
			Reporter.log("navigated to newBusBookingHelp");
			Log.info("navigated to newBusBookingHelp");
			utils.Waits.hardWait();
			help.click_backBtn();
			utils.Waits.hardWait();		
			
			
			
		// help_covid19traveladvisory
			help.click_covid19TravelAdvisoryHelp();
			utils.Waits.hardWait();
			Reporter.log("navigated to covid19traveladvisory");
			Log.info("navigated to covid19traveladvisory");
			help.click_backBtn();
			utils.Waits.hardWait();
			
			
		
		// help_safetyPlusFeatureHelp
			help.click_safetyPlusFeatureHelp();
			utils.Waits.hardWait();
			Reporter.log("navigated to safetyPlusFeatureHelp");
			Log.info("navigated to safetyPlusFeatureHelp");
			help.click_backBtn();
			utils.Waits.hardWait();
			
			
			
		// help_technicalIssuesHelp
			help.click_technicalIssuesHelp();
			utils.Waits.hardWait();
			Reporter.log("navigated to technicalIssuesHelp");
			Log.info("navigated to technicalIssuesHelp");
			help.click_backBtn();
			utils.Waits.hardWait();
			
			
			
		// help_redbusReferralHelp
			help.click_redbusReferralHelp();
			utils.Waits.hardWait();
			Reporter.log("navigated to redbusReferralHelp");
			Log.info("navigated to redbusReferralHelp");
			help.click_backBtn();
			utils.Waits.hardWait();
			
			
			
		// help_offersHelp
			help.click_offershelp();
			utils.Waits.hardWait();
			Reporter.log("navigated to offersHelp");
			Log.info("navigated to offersHelp");
			help.click_backBtn();
			utils.Waits.hardWait();
			
			
			
		// help_redBusWalletHelp
			help.click_redBusWalletHelp();
			utils.Waits.hardWait();
			Reporter.log("navigated to redBusWalletHelp");
			Log.info("navigated to redBusWalletHelp");
			help.click_backBtn();
			utils.Waits.hardWait();
			
			
			
		// help_rpoolHelp
			help.click_rpoolHelp();
			utils.Waits.hardWait();
			Reporter.log("navigated to rpoolHelp");
			Log.info("navigated to rpoolHelp");
			
			
			driver.quit();
			//_________________________________________________
			testsheet.getRow(17).getCell(2).setCellValue("pass");
		}
		else {
			testsheet.getRow(17).getCell(2).setCellValue("not defined");
		}
		
		extentTests.log(LogStatus.PASS,"test end");
		Log.info("test end____________________________________________________");
	}	

	//18
	//VIEW CHATS	
	@Test
	public void help_viewAllChatsNavigationTest() {
		extentTests=extent.startTest("testCase_help_viewAllChatsNavigationTest");
		Log.info("Start test - testCase_help_viewAllChatsNavigationTest");
		
		if(test_run.get("help_viewAllChatsNavigationTest").equals("y")) {
			//_________________________________________________
			initializeWebDriver();
			
			ReusableTestMethods reusable = new ReusableTestMethods();		
			reusable.loginTest(driver, vprop);
			Reporter.log("browser login and then site login");
			Log.info("browser login and then site login");
			HomePage hp = new HomePage(driver);
			Assert.assertTrue(hp.validatePageTitle());
			Reporter.log("navigated to home page");
			Log.info("navigated to home page");
			hp.click_help();
			hp.switch_helpWindow();
			HelpPage help = new HelpPage(driver);
			Assert.assertTrue(help.validatePageTitle());
			help.switchFrame();
			Reporter.log("navigated to help page");
			Log.info("navigated to help page");
			utils.Waits.hardWait();
			try {
				help.click_language_popup();
				Reporter.log("popups handled");
				Log.info("popups handled");
				help.click_viewAllChats();
			} catch (Exception languageNotificationPopUp) {
				try {
					help.click_chooseEnglishOpt();
					help.click_setLanguage();
					Reporter.log("popups handled");
					Log.info("popups handled");
					help.click_viewAllChats();
				} catch (Exception languageSelectPopUp) {
					help.click_viewAllChats();
				}
			}
			Reporter.log("navigated to chats page");
			Log.info("navigated to chats page");
			utils.Waits.hardWait();
			help.click_viewLastChat();
			utils.Waits.hardWait();
			help.click_backBtn();
			Reporter.log("view last chat");
			Log.info("view last chat");
			utils.Waits.hardWait();
			help.click_viewPreviousChat();
			utils.Waits.hardWait();
			Reporter.log("view previous chat");
			Log.info("view previous chat");
						
			driver.quit();
			//_________________________________________________
			testsheet.getRow(18).getCell(2).setCellValue("pass");
		}
		else {
			testsheet.getRow(18).getCell(2).setCellValue("not defined");
		}
		
		extentTests.log(LogStatus.PASS,"test end");
		Log.info("test end____________________________________________________");
	}
}
