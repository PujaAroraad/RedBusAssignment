package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import pages.BrowserGmailSignInPages;
import pages.FacebookSignInPages;
import pages.HomePage;

public class TestsType_Login extends Test_BaseTest {

	private static Logger Log = (Logger) LogManager.getLogger(TestsType_Login.class);
	
	//19
	@Test
	public void loginWithGoogleTest() {
		extentTests=extent.startTest("testCase_loginWithGoogleTest");
		Log.info("Start test - testCase_loginWithGoogleTest");
		
		if(test_run.get("loginWithGoogleTest").equals("y")) {
			//_________________________________________________
			initializeWebDriver();
			
			String email=vprop.getProperty("googleEmail"), password=vprop.getProperty("googlePassword");		
			BrowserGmailSignInPages bgsip = new BrowserGmailSignInPages(driver);
			bgsip.launchGoogleAccountUrl(vprop);
			utils.Waits.hardWait();
			bgsip.fillEmail(email);
			utils.Waits.hardWait();
			bgsip.click_email_next();
			utils.Waits.hardWait();
			bgsip.fillPassword(password);
			utils.Waits.hardWait();
			bgsip.click_password_next();
			utils.Waits.hardWait();
			extentTests.log(LogStatus.INFO,"google browser login");
			Log.info("google browser login");

			HomePage hp = new HomePage(driver);
			hp.launchHomePageUrl(vprop);
			hp.validatePageTitle();
			extentTests.log(LogStatus.INFO,"navigate to site home page");
			Log.info("navigate to site home page");
			utils.Waits.hardWait();
			hp.click_signInBlock();
			utils.Waits.hardWait();
			hp.click_signInLink();
			utils.Waits.hardWait();
			hp.switchTo_loginFrame();
			extentTests.log(LogStatus.INFO,"navigate to sign in page");
			Log.info("navigate to sign in page");
			utils.Waits.hardWait();
			hp.clickSignInWithGoogle();
			extentTests.log(LogStatus.INFO,"sign in with google choosed");
			Log.info("sign in with google choosed");
			utils.Waits.hardWait();
			hp.windowSwitchToAcceptBrowserLogin();
			utils.Waits.hardWait();
			// As if phn number is also registered with the id then screen would close by
			// default but if phn number not registered it is to be closed manually
			try {
				hp.click_closeSignInPopUp();
				utils.Waits.hardWait();
			} catch (Exception e) {
			}
			hp.click_signInBlock();
			utils.Waits.hardWait();
			Assert.assertTrue(hp.signOutLinkVisibility());
			extentTests.log(LogStatus.INFO,"sign out appers");
			Log.info("sign out appers");
						
			driver.quit();
			//_________________________________________________
			testsheet.getRow(19).getCell(2).setCellValue("pass");
		}
		else {
			testsheet.getRow(19).getCell(2).setCellValue("not defined");
		}
		
		extentTests.log(LogStatus.PASS,"test ends");
		Log.info("test ends____________________________________________________");
	}

	//20
	@Test	
	public void loginWithPhnNoValidTest() {
		extentTests=extent.startTest("testCase_loginWithPhnNoValidTest");	
		Log.info("Start test - testCase_loginWithPhnNoValidTest");
		
		if(test_run.get("loginWithPhnNoValidTest").equals("y")) {
			//_________________________________________________
			initializeWebDriver();
			
			String number=vprop.getProperty("validphnno");		
			HomePage hp=new HomePage(driver);
			utils.Waits.hardWait();
			hp.validatePageTitle();	
			extentTests.log(LogStatus.INFO,"navigate to site home page");
			Log.info("navigate to site home page");
			hp.click_signInBlock();
			utils.Waits.hardWait();
			hp.click_signInLink();
			utils.Waits.hardWait();
			hp.switchTo_loginFrame();
			extentTests.log(LogStatus.INFO,"navigate to sign in page");
			Log.info("navigate to sign in page");
			utils.Waits.hardWait();
			hp.fill_loginByPhnNoIp(number);	
			utils.Waits.hardWait();
			Assert.assertFalse(hp.validate_errorMsgInvalidNo());
			extentTests.log(LogStatus.INFO,"phn no filled without error msg");
			Log.info("phn no filled no error msg appears");
			Assert.assertTrue(hp.validateCaptchaBoxdisplayed());		
			extentTests.log(LogStatus.INFO,"captcha box appears");
			Log.info("captcha box appears");		
						
			driver.quit();
			//_________________________________________________
			testsheet.getRow(20).getCell(2).setCellValue("pass");
		}
		else {
			testsheet.getRow(20).getCell(2).setCellValue("not defined");
		}
		
		extentTests.log(LogStatus.PASS,"test ends");
		Log.info("test ends____________________________________________________");
	}

	//21
	@Test	
	public void loginWithPhnNoInValidTest() {
		extentTests=extent.startTest("testCase_loginWithPhnNoInValidTest");
		Log.info("Start test - testCase_loginWithPhnNoInValidTest");
		
		if(test_run.get("loginWithPhnNoInValidTest").equals("y")) {
			//_________________________________________________
			initializeWebDriver();			

			String number=vprop.getProperty("invalidphnNo");			
			HomePage hp=new HomePage(driver);
			utils.Waits.hardWait();
			hp.validatePageTitle();
			extentTests.log(LogStatus.INFO,"navigate to site home page");
			Log.info("navigate to site home page");
			hp.click_signInBlock();
			utils.Waits.hardWait();
			hp.click_signInLink();
			utils.Waits.hardWait();
			hp.switchTo_loginFrame();
			extentTests.log(LogStatus.INFO,"navigate to sign in page");
			Log.info("navigate to sign in page");
			utils.Waits.hardWait();
			hp.fill_loginByPhnNoIp(number);	
			utils.Waits.hardWait();
			Assert.assertTrue(hp.validate_errorMsgInvalidNo());
			extentTests.log(LogStatus.INFO,"invalid phn no filled and error msg appears");
			Log.info("invalid phn no filled and error msg appears");			
			
			driver.quit();
			//_________________________________________________
			testsheet.getRow(21).getCell(2).setCellValue("pass");
		}
		else {
			testsheet.getRow(21).getCell(2).setCellValue("not defined");
		}
		
		extentTests.log(LogStatus.PASS,"test ends");
		Log.info("test ends____________________________________________________");
	}
	
	//22
	@Test
	public void loginWithFacebookTest()  {
		extentTests=extent.startTest("testCase_loginWithFacebookTest");
		Log.info("Start test - testCase_loginWithFacebookTest");
		
		if(test_run.get("loginWithFacebookTest").equals("y")) {
			//_________________________________________________
			initializeWebDriver();
			
			String email=vprop.getProperty("faceBookEmail"), password=vprop.getProperty("faceBookPassword");		
			FacebookSignInPages fsip = new FacebookSignInPages(driver);
			fsip.launchFacebookUrl(vprop);
			fsip.fillEmail(email);
			fsip.fillPassword(password);
			fsip.click_loginBtn();
			utils.Waits.hardWait();
			utils.Waits.hardWait();
			extentTests.log(LogStatus.INFO,"facebook browser login");
			Log.info("facebook browser login");
			HomePage hp = new HomePage(driver);
			hp.launchHomePageUrl(vprop);
			utils.Waits.hardWait();
			utils.Waits.hardWait();
			hp.validatePageTitle();
			extentTests.log(LogStatus.INFO,"navigate to site home page");
			Log.info("navigate to site home page");
			hp.click_signInBlock();
			hp.click_signInLink();
			hp.switchTo_loginFrame();
			extentTests.log(LogStatus.INFO,"navigate to sign in page");
			Log.info("navigate to sign in page");
			utils.Waits.hardWait();	
			utils.Waits.hardWait();	
			hp.click_facebookOption();
			utils.Waits.hardWait();	
			extentTests.log(LogStatus.INFO,"sign in with facebook choosed");
			Log.info("sign in with facebook choosed");
			//As if phn number is also registered with the id then screen would close by default but if phn number not registered it is to be closed manually
			try {
				utils.Waits.hardWait();	
				hp.click_closeSignInPopUp();
				utils.Waits.hardWait();	
			}catch(Exception e) {			
			}
			hp.click_signInBlock();
			utils.Waits.hardWait();	
			Assert.assertTrue(hp.signOutLinkVisibility());		
			extentTests.log(LogStatus.INFO,"sign out appers");
			Log.info("sign out appers");
						
			driver.quit();
			//_________________________________________________
			testsheet.getRow(22).getCell(2).setCellValue("pass");
		}
		else {
			testsheet.getRow(22).getCell(2).setCellValue("not defined");
		}
		
		extentTests.log(LogStatus.PASS,"test ends");
		Log.info("test ends____________________________________________________");
	}


}
