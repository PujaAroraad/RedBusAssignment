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
	@Test
	public void loginWithGoogleTest() {
		extentTests=extent.startTest("testCase_loginWithGoogleTest");
		Log.info("Start test - testCase_loginWithGoogleTest");
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
		extentTests.log(LogStatus.PASS,"google browser login");
		Log.info("google browser login");

		HomePage hp = new HomePage(driver);
		hp.launchHomePageUrl(vprop);
		hp.validatePageTitle();
		extentTests.log(LogStatus.PASS,"navigate to site home page");
		Log.info("navigate to site home page");
		utils.Waits.hardWait();
		hp.click_signInBlock();
		utils.Waits.hardWait();
		hp.click_signInLink();
		utils.Waits.hardWait();
		hp.switchTo_loginFrame();
		extentTests.log(LogStatus.PASS,"navigate to sign in page");
		Log.info("navigate to sign in page");
		utils.Waits.hardWait();
		hp.clickSignInWithGoogle();
		extentTests.log(LogStatus.PASS,"sign in with google choosed");
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
		extentTests.log(LogStatus.PASS,"sign out appers");
		Log.info("sign out appers");
		
		extentTests.log(LogStatus.PASS,"test ends");
		Log.info("test ends____________________________________________________");
	}

	@Test	
	public void loginWithPhnNoValidTest() {
		extentTests=extent.startTest("testCase_loginWithPhnNoValidTest");	
		Log.info("Start test - testCase_loginWithPhnNoValidTest");
		String number=vprop.getProperty("validphnno");
		
		HomePage hp=new HomePage(driver);
		utils.Waits.hardWait();
		hp.validatePageTitle();	
		extentTests.log(LogStatus.PASS,"navigate to site home page");
		Log.info("navigate to site home page");
		hp.click_signInBlock();
		utils.Waits.hardWait();
		hp.click_signInLink();
		utils.Waits.hardWait();
		hp.switchTo_loginFrame();
		extentTests.log(LogStatus.PASS,"navigate to sign in page");
		Log.info("navigate to sign in page");
		utils.Waits.hardWait();
		hp.fill_loginByPhnNoIp(number);	
		utils.Waits.hardWait();
		Assert.assertFalse(hp.validate_errorMsgInvalidNo());
		extentTests.log(LogStatus.PASS,"phn no filled without error msg");
		Log.info("phn no filled no error msg appears");
		Assert.assertTrue(hp.validateCaptchaBoxdisplayed());		
		extentTests.log(LogStatus.PASS,"captcha box appears");
		Log.info("captcha box appears");		
		
		extentTests.log(LogStatus.PASS,"test ends");
		Log.info("test ends____________________________________________________");
	}

	@Test	
	public void loginWithPhnNoInValidTest() {
		extentTests=extent.startTest("testCase_loginWithPhnNoInValidTest");
		Log.info("Start test - testCase_loginWithPhnNoInValidTest");
		String number=vprop.getProperty("invalidphnNo");		
		
		HomePage hp=new HomePage(driver);
		utils.Waits.hardWait();
		hp.validatePageTitle();
		extentTests.log(LogStatus.PASS,"navigate to site home page");
		Log.info("navigate to site home page");
		hp.click_signInBlock();
		utils.Waits.hardWait();
		hp.click_signInLink();
		utils.Waits.hardWait();
		hp.switchTo_loginFrame();
		extentTests.log(LogStatus.PASS,"navigate to sign in page");
		Log.info("navigate to sign in page");
		utils.Waits.hardWait();
		hp.fill_loginByPhnNoIp(number);	
		utils.Waits.hardWait();
		Assert.assertTrue(hp.validate_errorMsgInvalidNo());
		extentTests.log(LogStatus.PASS,"invalid phn no filled and error msg appears");
		Log.info("invalid phn no filled and error msg appears");
		
		extentTests.log(LogStatus.PASS,"test ends");
		Log.info("test ends____________________________________________________");
	}

	@Test
	public void loginWithFacebookTest()  {
		extentTests=extent.startTest("testCase_loginWithFacebookTest");
		Log.info("Start test - testCase_loginWithFacebookTest");
		String email=vprop.getProperty("faceBookEmail"), password=vprop.getProperty("faceBookPassword");		
		
		FacebookSignInPages fsip = new FacebookSignInPages(driver);
		fsip.launchFacebookUrl(vprop);
		fsip.fillEmail(email);
		fsip.fillPassword(password);
		fsip.click_loginBtn();
		utils.Waits.hardWait();
		utils.Waits.hardWait();
		extentTests.log(LogStatus.PASS,"facebook browser login");
		Log.info("facebook browser login");
		HomePage hp = new HomePage(driver);
		hp.launchHomePageUrl(vprop);
		utils.Waits.hardWait();
		utils.Waits.hardWait();
		hp.validatePageTitle();
		extentTests.log(LogStatus.PASS,"navigate to site home page");
		Log.info("navigate to site home page");
		hp.click_signInBlock();
		hp.click_signInLink();
		hp.switchTo_loginFrame();
		extentTests.log(LogStatus.PASS,"navigate to sign in page");
		Log.info("navigate to sign in page");
		utils.Waits.hardWait();	
		utils.Waits.hardWait();	
		hp.click_facebookOption();
		utils.Waits.hardWait();	
		extentTests.log(LogStatus.PASS,"sign in with facebook choosed");
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
		extentTests.log(LogStatus.PASS,"sign out appers");
		Log.info("sign out appers");
		
		extentTests.log(LogStatus.PASS,"test ends");
		Log.info("test ends____________________________________________________");
	}


}
