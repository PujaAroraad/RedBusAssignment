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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import pages.HomePage;
import pages.ShowMyTicketPage;
import reusables.DataFetch;
import reusables.ReusableTestMethods;

public class TestsType_ShowMyTicket extends Test_BaseTest{
	private static Logger Log = (Logger) LogManager.getLogger(TestsType_ShowMyTicket.class); 
	
	@BeforeClass
	public void refreshFile() throws IOException {
		DataFetch reusableD = new DataFetch();
		File f = new File(vprop.getProperty("excelSheetPath"));
		FileInputStream fis = new FileInputStream(f);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("ShowMyTicketTest");
		sheet = reusableD.refreshStatus(sheet);
	}
	
	//24
	@Test
	public void showMyTicket_validtin_validemail() throws IOException {
		extentTests=extent.startTest("testCase_showMyTicket_validtin_validemail");
		Log.info("Start test - testCase_showMyTicket_validtin_validemail");
		
		if(test_run.get("showMyTicket_validtin_validemail").equals("y")) {
			//_________________________________________________
			initializeWebDriver();
			
			DataFetch reusableD = new DataFetch();
			File f = new File(vprop.getProperty("excelSheetPath"));
			FileInputStream fis = new FileInputStream(f);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheet("ShowMyTicketTest");
			//sheet = reusableD.refreshStatus(sheet);
			// TitleRow
			Row tr = sheet.getRow(0);
			Row r = sheet.getRow(1);
			HashMap<String, String> data = reusableD.getData(r, tr);

			int status = reusableD.getStatusColumn(tr);
			if (data.get("RunChoice").equalsIgnoreCase("run")) {

				String tinNo = data.get("TinNo"), email = data.get("Email");

				//Though the format of both ticket no and email is valid but not actually booked. Therefore unchecked case for now. 
				
				HomePage hp = new HomePage(driver);
				extentTests.log(LogStatus.INFO,"navigated to home page");
				Log.info("navigated to home page");
				hp.click_manageBooking();
				utils.Waits.hardWait();
				hp.click_showMyTicket();
				utils.Waits.hardWait();
				ShowMyTicketPage smtp = new ShowMyTicketPage(driver);
				Assert.assertTrue(smtp.validatePageTitle());
				extentTests.log(LogStatus.INFO,"navigated to show my ticket page");
				Log.info("navigated to show my ticket page");
				utils.Waits.hardWait();
				smtp.fill_ticketNo(tinNo);
				smtp.fill_email(email);
				smtp.click_submitBtn();	
				extentTests.log(LogStatus.INFO,"details filled and submit clicked");
				Log.info("details filled and submit clicked");
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
			testsheet.getRow(24).getCell(2).setCellValue("pass");
		}
		else {
			testsheet.getRow(24).getCell(2).setCellValue("not defined");
		}
		
		extentTests.log(LogStatus.PASS,"end test");
		Log.info("end test____________________________________________________");
	}
	
	//25
	@Test
	public void showMyTicket_invalidtin_invalidemail() throws IOException {
		extentTests=extent.startTest("testCase_showMyTicket_invalidtin_invalidemail");
		Log.info("Start test - testCase_showMyTicket_invalidtin_invalidemail");
		
		if(test_run.get("showMyTicket_invalidtin_invalidemail").equals("y")) {
			//_________________________________________________
			initializeWebDriver();
			
			ReusableTestMethods reusableM = new ReusableTestMethods();
			DataFetch reusableD = new DataFetch();
			File f = new File(vprop.getProperty("excelSheetPath"));
			FileInputStream fis = new FileInputStream(f);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheet("ShowMyTicketTest");
			//sheet = reusableD.refreshStatus(sheet);
			// TitleRow
			Row tr = sheet.getRow(0);
			Row r = sheet.getRow(2);
			HashMap<String, String> data = reusableD.getData(r, tr);

			int status = reusableD.getStatusColumn(tr);
			if (data.get("RunChoice").equalsIgnoreCase("run")) {

				String tinNo = data.get("TinNo"), email = data.get("Email");

				//Format of ticket no and email both are invalid 
				
				driver=reusableM.showMyTicketTest(driver, vprop, tinNo, email);
				extentTests.log(LogStatus.INFO,"navigated to showMyTicket page and details filled and submit clicked");
				Log.info("navigated to showMyTicket page and details filled and submit clicked");
				ShowMyTicketPage smtp = new ShowMyTicketPage(driver);
				Assert.assertTrue(smtp.validate_errormsg_invalidTicketNo_invalidEmail());
				extentTests.log(LogStatus.INFO,"warning validated");
				Log.info("warning validated");

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
			testsheet.getRow(25).getCell(2).setCellValue("pass");
		}
		else {
			testsheet.getRow(25).getCell(2).setCellValue("not defined");
		}
		
		extentTests.log(LogStatus.PASS,"end test");
		Log.info("end test____________________________________________________");
	}
	
	//26
	@Test
	public void showMyTicket_invalidtin_validemail() throws IOException {
		extentTests=extent.startTest("testCase_showMyTicket_invalidtin_validemail");
		Log.info("Start test - testCase_showMyTicket_invalidtin_validemail");
		
		if(test_run.get("showMyTicket_invalidtin_validemail").equals("y")) {
			//_________________________________________________
			initializeWebDriver();
			
			ReusableTestMethods reusableM = new ReusableTestMethods();
			DataFetch reusableD = new DataFetch();
			File f = new File(vprop.getProperty("excelSheetPath"));
			FileInputStream fis = new FileInputStream(f);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheet("ShowMyTicketTest");
			// TitleRow
			Row tr = sheet.getRow(0);
			Row r = sheet.getRow(3);
			HashMap<String, String> data = reusableD.getData(r, tr);

			int status = reusableD.getStatusColumn(tr);
			if (data.get("RunChoice").equalsIgnoreCase("run")) {

				String tinNo = data.get("TinNo"), email = data.get("Email");

				//Format of ticket no is invalid and email is valid 
				
				driver=reusableM.showMyTicketTest(driver, vprop, tinNo, email);
				extentTests.log(LogStatus.INFO,"navigated to showMyTicket page and details filled and submit clicked");
				Log.info("navigated to showMyTicket page and details filled and submit clicked");
				ShowMyTicketPage smtp = new ShowMyTicketPage(driver);
				Assert.assertTrue(smtp.validate_errormsg_invalidTicketNo_validEmail());	
				extentTests.log(LogStatus.INFO,"warning validated");
				Log.info("warning validated");

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
			testsheet.getRow(26).getCell(2).setCellValue("pass");
		}
		else {
			testsheet.getRow(26).getCell(2).setCellValue("not defined");
		}
		
		extentTests.log(LogStatus.PASS,"end test");
		Log.info("end test____________________________________________________");			
	}
	
	//27
	@Test
	public void showMyTicket_validtin_invalidemail() throws IOException {
		extentTests=extent.startTest("testCase_showMyTicket_validtin_invalidemail");
		Log.info("Start test - testCase_showMyTicket_validtin_invalidemail");
		
		if(test_run.get("showMyTicket_validtin_invalidemail").equals("y")) {
			//_________________________________________________
			initializeWebDriver();
			
			ReusableTestMethods reusableM = new ReusableTestMethods();
			DataFetch reusableD = new DataFetch();
			File f = new File(vprop.getProperty("excelSheetPath"));
			FileInputStream fis = new FileInputStream(f);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheet("ShowMyTicketTest");
			// TitleRow
			Row tr = sheet.getRow(0);
			Row r = sheet.getRow(4);
			HashMap<String, String> data = reusableD.getData(r, tr);

			int status = reusableD.getStatusColumn(tr);
			if (data.get("RunChoice").equalsIgnoreCase("run")) {

				String tinNo = data.get("TinNo"), email = data.get("Email");

				//Format of ticket no is valid and email is invalid 
				
				driver=reusableM.showMyTicketTest(driver, vprop, tinNo, email);
				extentTests.log(LogStatus.INFO,"navigated to showMyTicket page and details filled and submit clicked");
				Log.info("navigated to showMyTicket page and details filled and submit clicked");
				ShowMyTicketPage smtp = new ShowMyTicketPage(driver);
				Assert.assertTrue(smtp.validate_errormsg_validTicketNo_invalidEmail());	
				extentTests.log(LogStatus.INFO,"warning validated");
				Log.info("warning validated");

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
			testsheet.getRow(27).getCell(2).setCellValue("pass");
		}
		else {
			testsheet.getRow(27).getCell(2).setCellValue("not defined");
		}
		
		extentTests.log(LogStatus.PASS,"end test");
		Log.info("end test____________________________________________________");				
	}	
}
