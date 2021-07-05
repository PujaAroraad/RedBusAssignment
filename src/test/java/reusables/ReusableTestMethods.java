package reusables;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.AvailableBusPage;
import pages.BrowserGmailSignInPages;
import pages.CancelTicketPage;
import pages.ChangeTravelDatePage;
import pages.EmailSmsTicketPage;
import pages.HomePage;
import pages.ShowMyTicketPage;

public class ReusableTestMethods {
	
	//these test methods are used as reusable in order to achieve page navigation and have independent flow of each test.
	//They are explained with logs in their testType______.java files

	//Similar to login test in testTypeLogin.java file. 
	public WebDriver loginTest(WebDriver driver, Properties vprop) {
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
		
		HomePage hp=new HomePage(driver);
		hp.launchHomePageUrl(vprop);
		utils.Waits.hardWait();
		hp.click_signInBlock();
		utils.Waits.hardWait();
		hp.click_signInLink();
		utils.Waits.hardWait();
		hp.switchTo_loginFrame();
		utils.Waits.hardWait();
		hp.clickSignInWithGoogle();
		utils.Waits.hardWait();
		hp.windowSwitchToAcceptBrowserLogin();
		utils.Waits.hardWait();
		hp.click_signInBlock();
		utils.Waits.hardWait();
		Assert.assertTrue(hp.signOutLinkVisibility());
		
		return driver;
	}
	
	//Similar to search_test in testTypeSearch.java file. 
	public WebDriver search_test(WebDriver driver, Properties vprop) {
		String src=vprop.getProperty("src"), dest=vprop.getProperty("dest");
		int dd, mm, yyyy;
		dd=Integer.parseInt(vprop.getProperty("dd"));
		mm=Integer.parseInt(vprop.getProperty("mm"));
		yyyy=Integer.parseInt(vprop.getProperty("yyyy"));
		
		System.out.print(driver.getTitle());
		HomePage hp = new HomePage(driver);
		System.out.print(hp.pageTitle);		
		hp.fill_source(src);
		System.out.print(hp.match_autofilled_source_content());
		hp.fill_destination(dest);
		System.out.print(hp.match_autofilled_destination_content());
		utils.Waits.hardWait();	
		Assert.assertTrue(hp.enter_date(dd, mm, yyyy));
		utils.Waits.hardWait();		
		hp.clickSearch();
		utils.Waits.hardWait();	
		utils.Waits.hardWait();	
		System.out.print(driver.getTitle());
		AvailableBusPage abp=new AvailableBusPage(driver);
		Assert.assertTrue(abp.pageTitleVerify(src, dest));
		
		return driver;
	}
	
	//Similar to cancelticket_test in testtypecancelTicket.java 
	public WebDriver cancelTicketTest(WebDriver driver, Properties vprop, String tinNo, String email) {
		
		HomePage hp = new HomePage(driver);
		hp.click_manageBooking();
		utils.Waits.hardWait();
		hp.click_cancelTicket();
		utils.Waits.hardWait();
		CancelTicketPage ctp = new CancelTicketPage(driver);
		Assert.assertTrue(ctp.validatePageTitle());
		utils.Waits.hardWait();
		ctp.fill_ticketNo(tinNo);
		ctp.fill_email(email);
		ctp.click_selectPassengersBtn();
		utils.Waits.hardWait();
		return driver;
	}
	
	//Similar to changeTravelDateTest_test in testtypechangeTravelDateTest.java 
	public WebDriver changeTravelDateTest(WebDriver driver, Properties vprop, String tinNo, String email) {
		
		HomePage hp = new HomePage(driver);
		hp.click_manageBooking();
		utils.Waits.hardWait();
		hp.click_changeTravelDate();
		utils.Waits.hardWait();
		ChangeTravelDatePage ctdp = new ChangeTravelDatePage(driver);
		Assert.assertTrue(ctdp.validatePageTitle());
		utils.Waits.hardWait();
		ctdp.fill_ticketNo(tinNo);
		ctdp.fill_email(email);
		ctdp.click_search();
		utils.Waits.hardWait();
		return driver;
	}
	
	//Similar to showMyTicketTest_test in testtypeshowMyTicketTest.java 
	public WebDriver showMyTicketTest(WebDriver driver, Properties vprop, String tinNo, String email) {
		
		HomePage hp = new HomePage(driver);
		hp.click_manageBooking();
		utils.Waits.hardWait();
		hp.click_showMyTicket();
		utils.Waits.hardWait();
		ShowMyTicketPage smtp = new ShowMyTicketPage(driver);
		Assert.assertTrue(smtp.validatePageTitle());
		utils.Waits.hardWait();
		smtp.fill_ticketNo(tinNo);
		smtp.fill_email(email);
		smtp.click_submitBtn();	
		return driver;
	}
	
	//Similar to emailSmsTicketTest_test in testtypeemailSmsTicketTest.java 
	public WebDriver emailSmsTicketTest(WebDriver driver, Properties vprop, String tinNo, String email) {

		HomePage hp = new HomePage(driver);
		hp.click_manageBooking();
		utils.Waits.hardWait();
		hp.click_emailSms();
		utils.Waits.hardWait();
		EmailSmsTicketPage estp = new EmailSmsTicketPage(driver);
		Assert.assertTrue(estp.validatePageTitle());
		utils.Waits.hardWait();
		estp.fill_ticketNo(tinNo);
		estp.fill_email(email);
		estp.click_submitBtn();
		estp.validateNavigationToPrintTicketPage();
		return driver;		
	}
	
	
}
