//View Seat test
package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import pages.AvailableBusPage;
import reusables.ReusableTestMethods;
import utils.Scroll;

public class TestsType_BookSeat extends Test_BaseTest {
	private static Logger Log = (Logger) LogManager.getLogger(TestsType_BookSeat.class);

	//1
	@Test
	public void bookSeat_loggedInRedBusAccount() {
		extentTests = extent.startTest("testCase_bookSeat_loggedInRedBusAccount");
		Log.info("Start test - bookSeat_loggedInRedBusAccount");
		
		
		if(test_run.get("bookSeat_loggedInRedBusAccount").equals("y")) {
			//_________________________________________________
			initializeWebDriver();
			
			ReusableTestMethods reusable = new ReusableTestMethods();
			reusable.loginTest(driver, vprop);
			extentTests.log(LogStatus.INFO,"login is successful");
			Log.info("login is successful");
			try {
				reusable.search_test(driver, vprop);
				extentTests.log(LogStatus.INFO,"src,dest,date fields are filled and search clicked");
				Log.info("src,dest,date fields are filled and search clicked");
			} catch (Exception e1) {
				utils.Error_Msg.error_msg("date");
			}
			AvailableBusPage abp = new AvailableBusPage(driver);
			// scrolling the window to find elements loaded on screen
			driver = new Scroll().scrollDown(driver);
			// As popup does not appears always
			try {
				abp.click_closePopUp();
			} catch (Exception e) {
			}
			abp.click_viewSeats();
			utils.Waits.hardWait();
			Assert.assertTrue(abp.validate_viewSeat());
			extentTests.log(LogStatus.INFO,"view seats info displayed");
			Log.info("view seats info displayed");
			abp.click_seat();
			extentTests.log(LogStatus.INFO,"seat is selected");
			Log.info("seat is selected");
			utils.Waits.hardWait();
			String choosedTripTime = abp.get_availabletripTime1stOption();
			abp.click_tripTime();
			extentTests.log(LogStatus.INFO,"trip time 1st option choosed");
			Log.info("trip time 1st option choosed");
			driver = new Scroll().scrollDown(driver);
			utils.Waits.hardWait();
			abp.click_continuebtnToBookTrip();
			utils.Waits.hardWait();
			Assert.assertTrue(abp.validateTripDetails(vprop.getProperty("src"), choosedTripTime));
			abp.click_proceedToBookTrip();
			extentTests.log(LogStatus.INFO,"continue and proceeded with info validation of trip by time and source");
			Log.info("continue and proceeded with info validation of trip by time and source");
			utils.Waits.hardWait();
			Assert.assertTrue(abp.validate_passengerPageTitle());
			extentTests.log(LogStatus.INFO, "navigated to passenger details page");
			Log.info("navigated to passenger details page");			
			
			driver.quit();
			//_________________________________________________
			testsheet.getRow(1).getCell(2).setCellValue("pass");
		}
		else {
			testsheet.getRow(1).getCell(2).setCellValue("not defined");
		}

		extentTests.log(LogStatus.PASS, "testCase_bookSeat_loggedInRedBusAccount end test");
		Log.info("test end____________________________________________________");
	}
}
