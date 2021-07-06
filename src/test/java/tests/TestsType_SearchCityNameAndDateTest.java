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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import pages.AvailableBusPage;
import pages.HomePage;
import reusables.DataFetch;


public class TestsType_SearchCityNameAndDateTest extends Test_BaseTest {
	private static Logger Log = (Logger) LogManager.getLogger(TestsType_SearchCityNameAndDateTest.class);
	
	@BeforeClass
	public void refreshFile() throws IOException {
		DataFetch reusable = new DataFetch();
		File f = new File(vprop.getProperty("excelSheetPath"));
		FileInputStream fis = new FileInputStream(f);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("CancelTicketTest");
		sheet = reusable.refreshStatus(sheet);
	}

	//23
	@Test
	public void searchtest() throws IOException {
		extentTests=extent.startTest("testCase_SearchCityNameAndDateTest_searchtest");
		Log.info("Start test - testCase_SearchCityNameAndDateTest_searchtest");
		
		if(test_run.get("searchtest").equals("y")) {
			//_________________________________________________
			initializeWebDriver();
			
			DataFetch reusable = new DataFetch();		
			File f = new File(vprop.getProperty("excelSheetPath"));
			FileInputStream fis = new FileInputStream(f);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheet("SearchTest");
			
			//Row count i.e. rc
			int rc = sheet.getLastRowNum();
			// TitleRow i.e. tr
			Row tr = sheet.getRow(0);

			//stores the column index of status title 
			//it is used to define whether status is pass or fail.
			int status=reusable.getStatusColumn(tr);
			for (int i = 1; i <= rc; i++) {
				Row r = sheet.getRow(i);
				HashMap<String, String> data = reusable.getData(r, tr);			
				if (data.get("RunChoice").equalsIgnoreCase("run")) {
					String src = data.get("Src"), dest = data.get("Dest");
					int dd = Integer.parseInt(data.get("Date")), mm = Integer.parseInt(data.get("Month")), yyyy = Integer.parseInt(data.get("Year"));

					try {
						HomePage hp = new HomePage(driver);
						hp.validatePageTitle();
						extentTests.log(LogStatus.INFO,"navigate to home page");
						Log.info("navigate to home page");
						hp.fill_source(src);
						System.out.print(hp.match_autofilled_source_content());
						hp.fill_destination(dest);
						System.out.print(hp.match_autofilled_destination_content());
						if(hp.enter_date(dd, mm, yyyy)!=true)throw new Exception();
						utils.Waits.hardWait();
						utils.Waits.hardWait();
						hp.clickSearch();
						utils.Waits.hardWait();
						utils.Waits.hardWait();
						System.out.print(driver.getTitle());
						AvailableBusPage abp = new AvailableBusPage(driver);
						if(abp.pageTitleVerify(src, dest)!=true)throw new Exception();
						extentTests.log(LogStatus.INFO,"filled details src,dest,date are"+src+" "+dest+" "+dd+"-"+mm+"-"+yyyy);
						Log.info("filled details src,dest,date are"+src+" "+dest+" "+dd+"-"+mm+"-"+yyyy);
						driver.get(vprop.getProperty("siteUrl"));
						r.getCell(status).setCellValue("pass");
					} catch (Exception e) {
						r.getCell(status).setCellValue("fail");
					}
					extentTests.log(LogStatus.INFO,"SearchCityNameAndDateTest_searchtest_"+src+" "+dest+" "+dd+"-"+mm+"-"+yyyy+" test ends");
					Log.info("SearchCityNameAndDateTest_searchtest_"+src+" "+dest+" "+dd+"-"+mm+"-"+yyyy+" test ends");
				} else {
					r.getCell(status).setCellValue("not defined");
				} 
			}

			FileOutputStream fos = new FileOutputStream(f);
			wb.write(fos);
			fos.flush();
			fos.close();
						
			driver.quit();
			//_________________________________________________
			testsheet.getRow(23).getCell(2).setCellValue("pass");
		}
		else {
			testsheet.getRow(23).getCell(2).setCellValue("not defined");
		}
		
		extentTests.log(LogStatus.PASS,"testCase_SearchCityNameAndDateTest_searchtest test ends");
		Log.info("test ends__________________________");
	}

}
