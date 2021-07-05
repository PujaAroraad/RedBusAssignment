package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import pages.BusHirePage;
import pages.HomePage;
import pages.RcommutePage;
import utils.Scroll;

public class TestsType_BusHire extends Test_BaseTest{
	private static Logger Log = (Logger) LogManager.getLogger(TestsType_BusHire.class);

	@Test
	public void busHireOptionsNavigationTest() {
		extentTests=extent.startTest("testCase_busHireOptionsNavigationTest");
		Log.info("Start test - testCase_busHireOptionsNavigationTest");
		
		HomePage hp = new HomePage(driver);
		utils.Waits.hardWait();
		hp.validatePageTitle();
		extentTests.log(LogStatus.PASS,"navigate to home page");
		Log.info("navigate to home page");		
		hp.click_busHire();
		utils.Waits.hardWait();
		BusHirePage bhp=new BusHirePage(driver);
		bhp.validatePageTitle();
		bhp.switchToFrame();
		extentTests.log(LogStatus.PASS,"navigate to bus hire page");
		Log.info("navigate to bus hire page");
		utils.Waits.hardWait();
		bhp.click_outstation();
		utils.Waits.hardWait();
		bhp.click_outstation_back_btn();
		extentTests.log(LogStatus.PASS,"navigate to outstation page");
		Log.info("navigate to outstation page");
		utils.Waits.hardWait();
		bhp.click_local();
		utils.Waits.hardWait();
		bhp.click_local_back_btn();
		extentTests.log(LogStatus.PASS,"navigate to local page");
		Log.info("navigate to local page");
		utils.Waits.hardWait();
		driver=new Scroll().scrollDown(driver);
		utils.Waits.hardWait();
		bhp.click_airport();
		utils.Waits.hardWait();
		bhp.click_airport_back_btn();
		extentTests.log(LogStatus.PASS,"navigate to airport page");
		Log.info("navigate to airport page");
		utils.Waits.hardWait();
		
		extentTests.log(LogStatus.PASS,"testCase_busHireOptions test ends");
		Log.info("test ends____________________________________________________");
	}
	
	@Test
	public void employeeTransportTest_Invalid_BlankFields() {
		extentTests=extent.startTest("testCase_employeeTransportTest_Invalid_BlankFields");
		Log.info("Start test - testCase_employeeTransportTest_Invalid_BlankFields");
		
		HomePage hp = new HomePage(driver);
		utils.Waits.hardWait();
		hp.validatePageTitle();
		extentTests.log(LogStatus.PASS,"navigate to home page");
		Log.info("navigate to home page");
		hp.click_busHire();
		utils.Waits.hardWait();
		BusHirePage bhp=new BusHirePage(driver);
		bhp.validatePageTitle();
		bhp.switchToFrame();
		extentTests.log(LogStatus.PASS,"navigate to bus hire page");
		Log.info("navigate to bus hire page");
		utils.Waits.hardWait();
		driver=new Scroll().scrollDown(driver);
		bhp.click_employeeTransportKnowMore();
		utils.Waits.hardWait();
		bhp.switchWindow_toRcommute();
		utils.Waits.hardWait();
		RcommutePage rp =new RcommutePage(driver);
		rp.validatePageTitle();
		extentTests.log(LogStatus.PASS,"navigate to rcommute page");
		Log.info("navigate to rcommute page");
		rp.click_rcommute_request_call_back();
		utils.Waits.hardWait();
		rp.click_submit();
		extentTests.log(LogStatus.PASS,"submit clicked without filling fields");
		Log.info("submit clicked without filling fields");
		utils.Waits.hardWait();
		utils.Waits.hardWait();
		Assert.assertTrue(rp.validateErrorMsg_BlankNameField());
		Assert.assertTrue(rp.validateErrorMsg_BlankContactField());
		Assert.assertTrue(rp.validateErrorMsg_BlankEmailField());
		Assert.assertTrue(rp.validateErrorMsg_BlankOrganizationField());
		Assert.assertTrue(rp.validateErrorMsg_BlankCaptchaField());	
		extentTests.log(LogStatus.PASS,"error appears");
		Log.info("error appears");		
		
		extentTests.log(LogStatus.PASS,"testCase_employeeTransportTest_Invalid_BlankFields test ends");
		Log.info("test ends____________________________________________________");
	}
	
	@Test
	public void employeeTransportTest_invalidEmailAndPhn() {
		extentTests=extent.startTest("testCase_employeeTransportTest_invalidEmailAndPhn");
		Log.info("Start test - testCase_employeeTransportTest_invalidEmailAndPhn");
		
		String name=vprop.getProperty("name"),
				contactNo=vprop.getProperty("invalidphnNo"), 
				email=vprop.getProperty("invalidEmail"), 
				organization=vprop.getProperty("organization");
		
		HomePage hp = new HomePage(driver);
		utils.Waits.hardWait();
		hp.validatePageTitle();
		extentTests.log(LogStatus.PASS,"navigate to home page");
		Log.info("navigate to home page");
		hp.click_busHire();
		utils.Waits.hardWait();
		BusHirePage bhp=new BusHirePage(driver);
		bhp.validatePageTitle();
		bhp.switchToFrame();
		extentTests.log(LogStatus.PASS,"navigate to bus hire page");
		Log.info("navigate to bus hire page");
		utils.Waits.hardWait();
		driver=new Scroll().scrollDown(driver);
		bhp.click_employeeTransportKnowMore();
		utils.Waits.hardWait();
		bhp.switchWindow_toRcommute();
		utils.Waits.hardWait();
		RcommutePage rp =new RcommutePage(driver);
		rp.validatePageTitle();
		extentTests.log(LogStatus.PASS,"navigate to rcommute page");
		Log.info("navigate to rcommute page");
		rp.click_rcommute_request_call_back();
		utils.Waits.hardWait();
		rp.fill_name(name);
		rp.fill_contactNoIP(contactNo);
		rp.fill_emailIP(email);
		rp.fill_organizationIP(organization);
		extentTests.log(LogStatus.PASS,"fields filled with invalid credential format");
		Log.info("fields filled with invalid credential format");
		rp.click_submit();
		extentTests.log(LogStatus.PASS,"submit clicked");
		Log.info("submit clicked");
		utils.Waits.hardWait();
		utils.Waits.hardWait();
		Assert.assertTrue(rp.validateErrorMsg_errorInvalidPhnNo());
		Assert.assertTrue(rp.validateErrorMsg_errorInvalidEmail());	
		extentTests.log(LogStatus.PASS,"error appears");
		Log.info("error appears");		
		
		extentTests.log(LogStatus.PASS,"testCase_employeeTransportTest_invalidEmailAndPhn test ends");
		Log.info("test ends____________________________________________________");
	}
	
	
}
