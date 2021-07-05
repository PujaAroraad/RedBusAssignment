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
import pages.EmailSmsTicketPage;
import pages.HomePage;
import reusables.DataFetch;
import reusables.ReusableTestMethods;

public class TestsType_EmailSmsTicket extends Test_BaseTest{
	private static Logger Log = (Logger) LogManager.getLogger(TestsType_EmailSmsTicket.class);
	
	@BeforeClass
	public void refreshFile() throws IOException {
		DataFetch reusableD = new DataFetch();
		File f = new File(vprop.getProperty("excelSheetPath"));
		FileInputStream fis = new FileInputStream(f);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("EmailSmsTicketTest");
		sheet = reusableD.refreshStatus(sheet);
	}
	
	@Test
	public void emailSmsTicket_validtin_validemail() throws IOException {
		extentTests=extent.startTest("testCase_emailSmsTicket_validtin_validemail");
		Log.info("Start test - testCase_emailSmsTicket_validtin_validemail");
		
		DataFetch reusableD = new DataFetch();
		File f = new File(vprop.getProperty("excelSheetPath"));
		FileInputStream fis = new FileInputStream(f);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("EmailSmsTicketTest");
		//sheet = reusableD.refreshStatus(sheet);
		// TitleRow
		Row tr = sheet.getRow(0);
		Row r = sheet.getRow(1);
		HashMap<String, String> data = reusableD.getData(r, tr);

		int status = reusableD.getStatusColumn(tr);
		if (data.get("RunChoice").equalsIgnoreCase("run")) {

			String tinNo = data.get("TinNo"), email = data.get("Email");

			//Though the format of both ticket no and email is valid but not actually booked. Therefore unchecked case for now. 
			//String tinNo="TNAM45625380", email="pujaarora.980@gmail.com";
			
			HomePage hp = new HomePage(driver);
			hp.click_manageBooking();
			utils.Waits.hardWait();
			extentTests.log(LogStatus.PASS,"navigated to home page");
			Log.info("navigated to home page");
			hp.click_emailSms();
			utils.Waits.hardWait();
			EmailSmsTicketPage estp = new EmailSmsTicketPage(driver);
			Assert.assertTrue(estp.validatePageTitle());
			extentTests.log(LogStatus.PASS,"navigated to EmailSmsTicket page");
			Log.info("navigated to EmailSmsTicket page");
			utils.Waits.hardWait();
			estp.fill_ticketNo(tinNo);
			estp.fill_email(email);
			estp.click_submitBtn();
			estp.validateNavigationToPrintTicketPage();
			extentTests.log(LogStatus.PASS,"details filled submit clicked");
			Log.info("details filled submit clicked");
			
			r.getCell(status).setCellValue("pass");

		} else {
			r.getCell(status).setCellValue("not defined");
		}
		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);
		fos.flush();
		fos.close();
		extentTests.log(LogStatus.PASS,"end test");
		Log.info("end test____________________________________________________");
	}
	
	
	@Test
	public void emailSmsTicket_invalidtin_invalidemail() throws IOException {
		extentTests=extent.startTest("testCase_emailSmsTicket_invalidtin_invalidemail");
		Log.info("Start test - testCase_emailSmsTicket_invalidtin_invalidemail");
		
		ReusableTestMethods reusableM = new ReusableTestMethods();
		DataFetch reusableD = new DataFetch();
		File f = new File(vprop.getProperty("excelSheetPath"));
		FileInputStream fis = new FileInputStream(f);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("EmailSmsTicketTest");
		//sheet = reusableD.refreshStatus(sheet);
		// TitleRow
		Row tr = sheet.getRow(0);
		Row r = sheet.getRow(2);
		HashMap<String, String> data = reusableD.getData(r, tr);

		int status = reusableD.getStatusColumn(tr);
		if (data.get("RunChoice").equalsIgnoreCase("run")) {

			String tinNo = data.get("TinNo"), email = data.get("Email");

			//Format of ticket no and email both are invalid 
			//String tinNo="TNAM45", email="pujaarora";
			
			driver=reusableM.emailSmsTicketTest(driver, vprop, tinNo, email);
			extentTests.log(LogStatus.PASS,"navigated to emailSmsTicket page and details filled and submit clicked");
			Log.info("navigated to emailSmsTicket page and details filled and submit clicked");
			EmailSmsTicketPage estp = new EmailSmsTicketPage(driver);
			Assert.assertTrue(estp.validate_errormsg_invalidTicketNo_invalidEmail());
			extentTests.log(LogStatus.PASS,"warning validated");
			Log.info("warning validated");

			r.getCell(status).setCellValue("pass");

		} else {
			r.getCell(status).setCellValue("not defined");
		}
		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);
		fos.flush();
		fos.close();
		extentTests.log(LogStatus.PASS,"end test");
		Log.info("end test____________________________________________________");
	}
	
	@Test
	public void emailSmsTicket_invalidtin_validemail() throws IOException {
		extentTests=extent.startTest("testCase_emailSmsTicket_invalidtin_validemail");
		Log.info("Start test - testCase_emailSmsTicket_invalidtin_validemail");
		
		ReusableTestMethods reusableM = new ReusableTestMethods();
		DataFetch reusableD = new DataFetch();
		File f = new File(vprop.getProperty("excelSheetPath"));
		FileInputStream fis = new FileInputStream(f);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("EmailSmsTicketTest");
		//sheet = reusableD.refreshStatus(sheet);
		// TitleRow
		Row tr = sheet.getRow(0);
		Row r = sheet.getRow(3);
		HashMap<String, String> data = reusableD.getData(r, tr);

		int status = reusableD.getStatusColumn(tr);
		if (data.get("RunChoice").equalsIgnoreCase("run")) {

			String tinNo = data.get("TinNo"), email = data.get("Email");

			//Format of ticket no is invalid and email is valid 
			//String tinNo="TNAM45", email="pujaarora.980@gmail.com";
			
			driver=reusableM.emailSmsTicketTest(driver, vprop, tinNo, email);
			extentTests.log(LogStatus.PASS,"navigated to emailSmsTicket page and details filled and submit clicked");
			Log.info("navigated to emailSmsTicket page and details filled and submit clicked");
			EmailSmsTicketPage estp = new EmailSmsTicketPage(driver);
			Assert.assertTrue(estp.validate_errormsg_invalidTicketNo_validEmail());	
			extentTests.log(LogStatus.PASS,"warning validated");
			Log.info("warning validated");

			r.getCell(status).setCellValue("pass");

		} else {
			r.getCell(status).setCellValue("not defined");
		}
		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);
		fos.flush();
		fos.close();
		extentTests.log(LogStatus.PASS,"end test");
		Log.info("end test____________________________________________________");	
	}
	
	@Test
	public void emailSmsTicket_validtin_invalidemail() throws IOException {
		extentTests=extent.startTest("testCase_emailSmsTicket_validtin_invalidemail");
		Log.info("Start test - testCase_emailSmsTicket_validtin_invalidemail");
		
		ReusableTestMethods reusableM = new ReusableTestMethods();
		DataFetch reusableD = new DataFetch();
		File f = new File(vprop.getProperty("excelSheetPath"));
		FileInputStream fis = new FileInputStream(f);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("EmailSmsTicketTest");
		//sheet = reusableD.refreshStatus(sheet);
		// TitleRow
		Row tr = sheet.getRow(0);
		Row r = sheet.getRow(4);
		HashMap<String, String> data = reusableD.getData(r, tr);

		int status = reusableD.getStatusColumn(tr);
		if (data.get("RunChoice").equalsIgnoreCase("run")) {

			String tinNo = data.get("TinNo"), email = data.get("Email");

			//Format of ticket no is valid and email is invalid 
			//String tinNo="TNAM45625380", email="pujaarora";
			
			driver=reusableM.emailSmsTicketTest(driver, vprop, tinNo, email);
			extentTests.log(LogStatus.PASS,"navigated to emailSmsTicket page and details filled and submit clicked");
			Log.info("navigated to emailSmsTicket page and details filled and submit clicked");
			EmailSmsTicketPage estp = new EmailSmsTicketPage(driver);
			Assert.assertTrue(estp.validate_errormsg_validTicketNo_invalidEmail());	
			extentTests.log(LogStatus.PASS,"warning validated");
			Log.info("warning validated");
			
			r.getCell(status).setCellValue("pass");

		} else {
			r.getCell(status).setCellValue("not defined");
		}
		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);
		fos.flush();
		fos.close();
		extentTests.log(LogStatus.PASS,"end test");
		Log.info("end test____________________________________________________");
	}

}
