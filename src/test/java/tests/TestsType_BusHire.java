package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import pages.BusHirePage;
import pages.HomePage;
import pages.RcommutePage;
import utils.Scroll;

public class TestsType_BusHire extends Test_BaseTest{
	private static Logger Log = (Logger) LogManager.getLogger(TestsType_BusHire.class);

	//2
	@Test
	public void busHireOptionsNavigationTest() {
		extentTests=extent.startTest("testCase_busHireOptionsNavigationTest");
		Log.info("Start test - testCase_busHireOptionsNavigationTest");
		
		if(test_run.get("busHireOptionsNavigationTest").equals("y")) {
			//_________________________________________________
			initializeWebDriver();
			
			HomePage hp = new HomePage(driver);
			utils.Waits.hardWait();
			hp.validatePageTitle();
			Reporter.log("navigate to home page");
			Log.info("navigate to home page");		
			hp.click_busHire();
			utils.Waits.hardWait();
			BusHirePage bhp=new BusHirePage(driver);
			bhp.validatePageTitle();
			bhp.switchToFrame();
			Reporter.log("navigate to bus hire page");
			Log.info("navigate to bus hire page");
			utils.Waits.hardWait();
			bhp.click_outstation();
			utils.Waits.hardWait();
			bhp.click_outstation_back_btn();
			Reporter.log("navigate to outstation page");
			Log.info("navigate to outstation page");
			utils.Waits.hardWait();
			bhp.click_local();
			utils.Waits.hardWait();
			bhp.click_local_back_btn();
			Reporter.log("navigate to local page");
			Log.info("navigate to local page");
			utils.Waits.hardWait();
			driver=new Scroll().scrollDown(driver);
			utils.Waits.hardWait();
			bhp.click_airport();
			utils.Waits.hardWait();
			bhp.click_airport_back_btn();
			Reporter.log("navigate to airport page");
			Log.info("navigate to airport page");
			utils.Waits.hardWait();			
			
			driver.quit();
			//_________________________________________________
			testsheet.getRow(2).getCell(2).setCellValue("pass");
		}
		else {
			testsheet.getRow(2).getCell(2).setCellValue("not defined");
		}
		
		extentTests.log(LogStatus.PASS,"test ends");
		Log.info("test ends____________________________________________________");
	}
	
	//3
	@Test
	public void employeeTransportTest_Invalid_BlankFields() {
		extentTests=extent.startTest("testCase_employeeTransportTest_Invalid_BlankFields");
		Log.info("Start test - testCase_employeeTransportTest_Invalid_BlankFields");
		
		if(test_run.get("employeeTransportTest_Invalid_BlankFields").equals("y")) {
			//_________________________________________________
			initializeWebDriver();
			
			HomePage hp = new HomePage(driver);
			utils.Waits.hardWait();
			hp.validatePageTitle();
			Reporter.log("navigate to home page");
			Log.info("navigate to home page");
			hp.click_busHire();
			utils.Waits.hardWait();
			BusHirePage bhp=new BusHirePage(driver);
			bhp.validatePageTitle();
			bhp.switchToFrame();
			Reporter.log("navigate to bus hire page");
			Log.info("navigate to bus hire page");
			utils.Waits.hardWait();
			driver=new Scroll().scrollDown(driver);
			bhp.click_employeeTransportKnowMore();
			utils.Waits.hardWait();
			bhp.switchWindow_toRcommute();
			utils.Waits.hardWait();
			RcommutePage rp =new RcommutePage(driver);
			rp.validatePageTitle();
			Reporter.log("navigate to rcommute page");
			Log.info("navigate to rcommute page");
			rp.click_rcommute_request_call_back();
			utils.Waits.hardWait();
			rp.click_submit();
			Reporter.log("submit clicked without filling fields");
			Log.info("submit clicked without filling fields");
			utils.Waits.hardWait();
			utils.Waits.hardWait();
			Assert.assertTrue(rp.validateErrorMsg_BlankNameField());
			Assert.assertTrue(rp.validateErrorMsg_BlankContactField());
			Assert.assertTrue(rp.validateErrorMsg_BlankEmailField());
			Assert.assertTrue(rp.validateErrorMsg_BlankOrganizationField());
			Assert.assertTrue(rp.validateErrorMsg_BlankCaptchaField());	
			Reporter.log("error appears");
			Log.info("error appears");		
			
			driver.quit();
			//_________________________________________________
			testsheet.getRow(3).getCell(2).setCellValue("pass");
		}
		else {
			testsheet.getRow(3).getCell(2).setCellValue("not defined");
		}
		
		extentTests.log(LogStatus.PASS,"testCase_employeeTransportTest_Invalid_BlankFields test ends");
		Log.info("test ends____________________________________________________");
	}
	
	//4
	@Test
	public void employeeTransportTest_invalidEmailAndPhn() {
		extentTests=extent.startTest("testCase_employeeTransportTest_invalidEmailAndPhn");
		Log.info("Start test - testCase_employeeTransportTest_invalidEmailAndPhn");
		
		if(test_run.get("employeeTransportTest_invalidEmailAndPhn").equals("y")) {
			//_________________________________________________
			initializeWebDriver();
			
			String name=vprop.getProperty("name"),
					contactNo=vprop.getProperty("invalidphnNo"), 
					email=vprop.getProperty("invalidEmail"), 
					organization=vprop.getProperty("organization");
			
			HomePage hp = new HomePage(driver);
			utils.Waits.hardWait();
			hp.validatePageTitle();
			Reporter.log("navigate to home page");
			Log.info("navigate to home page");
			hp.click_busHire();
			utils.Waits.hardWait();
			BusHirePage bhp=new BusHirePage(driver);
			bhp.validatePageTitle();
			bhp.switchToFrame();
			Reporter.log("navigate to bus hire page");
			Log.info("navigate to bus hire page");
			utils.Waits.hardWait();
			driver=new Scroll().scrollDown(driver);
			bhp.click_employeeTransportKnowMore();
			utils.Waits.hardWait();
			bhp.switchWindow_toRcommute();
			utils.Waits.hardWait();
			RcommutePage rp =new RcommutePage(driver);
			rp.validatePageTitle();
			Reporter.log("navigate to rcommute page");
			Log.info("navigate to rcommute page");
			rp.click_rcommute_request_call_back();
			utils.Waits.hardWait();
			rp.fill_name(name);
			rp.fill_contactNoIP(contactNo);
			rp.fill_emailIP(email);
			rp.fill_organizationIP(organization);
			Reporter.log("fields filled with invalid credential format");
			Log.info("fields filled with invalid credential format");
			rp.click_submit();
			Reporter.log("submit clicked");
			Log.info("submit clicked");
			utils.Waits.hardWait();
			utils.Waits.hardWait();
			Assert.assertTrue(rp.validateErrorMsg_errorInvalidPhnNo());
			Assert.assertTrue(rp.validateErrorMsg_errorInvalidEmail());	
			Reporter.log("error appears");
			Log.info("error appears");
			
			driver.quit();
			//_________________________________________________
			testsheet.getRow(4).getCell(2).setCellValue("pass");
		}
		else {
			testsheet.getRow(4).getCell(2).setCellValue("not defined");
		}		
		
		extentTests.log(LogStatus.PASS,"testCase_employeeTransportTest_invalidEmailAndPhn test ends");
		Log.info("test ends____________________________________________________");
	}
	
	
}
