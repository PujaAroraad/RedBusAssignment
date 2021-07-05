package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import pages.CancelTicketPage;
import pages.HomePage;
import reusables.DataFetch;
import reusables.ReusableTestMethods;

public class TestsType_CancelTicket extends Test_BaseTest {
	private static Logger Log = (Logger) LogManager.getLogger(TestsType_CancelTicket.class);
	
	@BeforeClass
	public void refreshFile() throws IOException {
		DataFetch reusableD = new DataFetch();
		File f = new File(vprop.getProperty("excelSheetPath"));
		FileInputStream fis = new FileInputStream(f);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("CancelTicketTest");
		sheet = reusableD.refreshStatus(sheet);
	}

	//5
	@Test
	public void cancelTicket_validtin_validemail() throws IOException {
		extentTests = extent.startTest("testCase_cancelTicket_validtin_validemail");
		Log.info("Start test - testCase_cancelTicket_validtin_validemail");

		if(test_run.get("cancelTicket_validtin_validemail").equals("y")) {
			//_________________________________________________
			initializeWebDriver();
			
			DataFetch reusableD = new DataFetch();
			File f = new File(vprop.getProperty("excelSheetPath"));
			FileInputStream fis = new FileInputStream(f);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheet("CancelTicketTest");
			// TitleRow
			Row tr = sheet.getRow(0);
			Row r = sheet.getRow(1);
			HashMap<String, String> data = reusableD.getData(r, tr);

			int status = reusableD.getStatusColumn(tr);
			if (data.get("RunChoice").equalsIgnoreCase("run")) {

				String tinNo = data.get("TinNo"), email = data.get("Email");

				// Though the format of both ticket no and email is valid but not actually
				// booked. Therefore unchecked case for now.

				HomePage hp = new HomePage(driver);
				hp.validatePageTitle();
				Reporter.log("navigated to home page");
				Log.info("navigated to home page");
				hp.click_manageBooking();
				utils.Waits.hardWait();
				hp.click_cancelTicket();
				utils.Waits.hardWait();
				CancelTicketPage ctp = new CancelTicketPage(driver);
				Assert.assertTrue(ctp.validatePageTitle());
				Reporter.log("navigated to cancel ticket page");
				Log.info("navigated to cancel ticket page");
				utils.Waits.hardWait();
				ctp.fill_ticketNo(tinNo);
				ctp.fill_email(email);
				ctp.click_selectPassengersBtn();
				Reporter.log("details filled submit clicked");
				Log.info("details filled submit clicked");
				
				r.getCell(status).setCellValue("pass");
			} else {
				r.getCell(status).setCellValue("not defined");
			}
			FileOutputStream fos = new FileOutputStream(f);
			wb.write(fos);
			fos.flush();
			fos.close();	
			
			driver.quit();
			//_________________________________________________
			testsheet.getRow(5).getCell(2).setCellValue("pass");
		}
		else {
			testsheet.getRow(5).getCell(2).setCellValue("not defined");
		}
		
		extentTests.log(LogStatus.PASS,"end test");
		Log.info("end test____________________________________________________");
	}

	//6
	@Test
	public void cancelTicket_invalidtin_invalidemail() throws IOException {
		extentTests = extent.startTest("testCase_cancelTicket_invalidtin_invalidemail");
		Log.info("Start test - testCase_cancelTicket_invalidtin_invalidemail");
		
		if(test_run.get("cancelTicket_invalidtin_invalidemail").equals("y")) {
			//_________________________________________________
			initializeWebDriver();
			
			ReusableTestMethods reusableM = new ReusableTestMethods();
			DataFetch reusableD = new DataFetch();
			File f = new File(vprop.getProperty("excelSheetPath"));
			FileInputStream fis = new FileInputStream(f);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheet("CancelTicketTest");
			//sheet = reusableD.refreshStatus(sheet);
			// TitleRow
			Row tr = sheet.getRow(0);

			Row r = sheet.getRow(2);
			HashMap<String, String> data = reusableD.getData(r, tr);

			int status = reusableD.getStatusColumn(tr);
			if (data.get("RunChoice").equalsIgnoreCase("run")) {

				String tinNo = data.get("TinNo"), email = data.get("Email");

				// Format of ticket no and email both are invalid

				driver = reusableM.cancelTicketTest(driver, vprop, tinNo, email);
				Reporter.log("navigated to cancel ticket page and details filled and submit clicked");
				Log.info("navigated to cancel ticket page and details filled and submit clicked");
				CancelTicketPage ctp = new CancelTicketPage(driver);
				Assert.assertTrue(ctp.validate_errormsg_invalidTicketNo_invalidEmail());
				Reporter.log("warning validated");
				Log.info("warning validated");

				r.getCell(status).setCellValue("pass");
			}
			else {
				r.getCell(status).setCellValue("not defined");
			}
			FileOutputStream fos = new FileOutputStream(f);
			wb.write(fos);
			fos.flush();
			fos.close();
			
			driver.quit();
			//_________________________________________________
			testsheet.getRow(6).getCell(2).setCellValue("pass");
		}
		else {
			testsheet.getRow(6).getCell(2).setCellValue("not defined");
		}
		
		extentTests.log(LogStatus.PASS,"testCase_cancelTicket_validtin_invalidemail test end");
		Log.info("test end____________________________________________________");
	}

	//7
	@Test
	public void cancelTicket_invalidtin_validemail() throws IOException {
		extentTests = extent.startTest("testCase_cancelTicket_invalidtin_validemail");
		Log.info("Start test - testCase_cancelTicket_invalidtin_validemail");
		
		if(test_run.get("cancelTicket_invalidtin_validemail").equals("y")) {
			//_________________________________________________
			initializeWebDriver();
			
			ReusableTestMethods reusableM = new ReusableTestMethods();
			DataFetch reusableD = new DataFetch();
			File f = new File(vprop.getProperty("excelSheetPath"));
			FileInputStream fis = new FileInputStream(f);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheet("CancelTicketTest");
			//sheet = reusableD.refreshStatus(sheet);
			// TitleRow
			Row tr = sheet.getRow(0);
			Row r = sheet.getRow(3);
			HashMap<String, String> data = reusableD.getData(r, tr);

			int status = reusableD.getStatusColumn(tr);
			if (data.get("RunChoice").equalsIgnoreCase("run")) {

				String tinNo = data.get("TinNo"), email = data.get("Email");

				// Format of ticket no is invalid and email is valid

				driver = reusableM.cancelTicketTest(driver, vprop, tinNo, email);
				Reporter.log("navigated to cancel ticket page and details filled and submit clicked");
				Log.info("navigated to cancel ticket page and details filled and submit clicked");
				CancelTicketPage ctp = new CancelTicketPage(driver);
				Assert.assertTrue(ctp.validate_errormsg_invalidTicketNo_validEmail());
				Reporter.log("warning validated");
				Log.info("warning validated");

				r.getCell(status).setCellValue("pass");
			}
			else {
				r.getCell(status).setCellValue("not defined");
			}
			FileOutputStream fos = new FileOutputStream(f);
			wb.write(fos);
			fos.flush();
			fos.close();	
			
			driver.quit();
			//_________________________________________________
			testsheet.getRow(7).getCell(2).setCellValue("pass");
		}
		else {
			testsheet.getRow(7).getCell(2).setCellValue("not defined");
		}
		
		extentTests.log(LogStatus.PASS,"end test");
		Log.info("end test____________________________________________________");
	}

	//8
	@Test
	public void cancelTicket_validtin_invalidemail() throws IOException {
		extentTests = extent.startTest("testCase_cancelTicket_validtin_invalidemail");
		Log.info("Start test - testCase_cancelTicket_validtin_invalidemail");
		
		if(test_run.get("cancelTicket_validtin_invalidemail").equals("y")) {
			//_________________________________________________
			initializeWebDriver();
			
			ReusableTestMethods reusableM = new ReusableTestMethods();
			DataFetch reusableD = new DataFetch();
			File f = new File(vprop.getProperty("excelSheetPath"));
			FileInputStream fis = new FileInputStream(f);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheet("CancelTicketTest");
			//sheet = reusableD.refreshStatus(sheet);
			// TitleRow
			Row tr = sheet.getRow(0);
			Row r = sheet.getRow(4);
			HashMap<String, String> data = reusableD.getData(r, tr);

			int status = reusableD.getStatusColumn(tr);
			if (data.get("RunChoice").equalsIgnoreCase("run")) {

				String tinNo = data.get("TinNo"), email = data.get("Email");

				// Format of ticket no is valid and email is invalid
				
				driver = reusableM.cancelTicketTest(driver, vprop, tinNo, email);
				Reporter.log("navigated to cancel ticket page and details filled and submit clicked");
				Log.info("navigated to cancel ticket page and details filled and submit clicked");
				CancelTicketPage ctp = new CancelTicketPage(driver);
				Assert.assertTrue(ctp.validate_errormsg_validTicketNo_invalidEmail());
				Reporter.log("warning validated");
				Log.info("warning validated");

				r.getCell(status).setCellValue("pass");
			}
			else {
				r.getCell(status).setCellValue("not defined");
			}
			FileOutputStream fos = new FileOutputStream(f);
			wb.write(fos);
			fos.flush();
			fos.close();
			
			driver.quit();
			//_________________________________________________
			testsheet.getRow(8).getCell(2).setCellValue("pass");
		}
		else {
			testsheet.getRow(8).getCell(2).setCellValue("not defined");
		}
		
		extentTests.log(LogStatus.PASS,"testCase_cancelTicket_validtin_invalidemail test end");
		Log.info("test end____________________________________________________");
	}
}
