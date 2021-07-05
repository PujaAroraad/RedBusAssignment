//This file contains prerequisites for tests and suites
package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import utils.ScreenShots;

public class Test_BaseTest {
	
	//Logger accessing
	private static Logger Log = (Logger) LogManager.getLogger(Test_BaseTest.class);

	//driver for browser
	public WebDriver driver;
	
	//for report generation
	public static ExtentReports extent;
	public static ExtentTest extentTests;

	// file for page elements locators and values
	public static File valueProperties = new File(".\\Resources\\config.properties");
	public static FileInputStream vfis = null;
	public static Properties vprop = new Properties();
	static {
		try {
			vfis = new FileInputStream(valueProperties);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			vprop.load(vfis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// file for particular browser's driver attribute name and locator
	public static File driverProperties = new File(".\\\\Resources\\\\driver.properties");
	public static FileInputStream dfis = null;
	public static Properties dprop = new Properties();
	static {
		try {
			dfis = new FileInputStream(driverProperties);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			dprop.load(dfis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@BeforeSuite
	public void setExtent() {
		//Initiating logs
		Log.info("_____________________NEW SUITE_____________________");
		//Initiating extent reports
		extent = new ExtentReports(vprop.getProperty("extendReportPath"));
	}

	@AfterSuite
	public void endReport() throws IOException {
		//closing report
		extent.flush();
		extent.close();
	}
		
	@BeforeMethod
	public void initializeWebDriver()  {
		
		if ((dprop.getProperty("browser").toLowerCase()).contains("chrome".toLowerCase())) {
			System.setProperty(dprop.getProperty("chromeDriver"), dprop.getProperty("chromeDriverPath"));
			ChromeOptions options = new ChromeOptions();
			options.addArguments("test-type");
            options.addArguments("--start-maximized");
            options.addArguments("--disable-web-security");
            options.addArguments("--allow-running-insecure-content");
			options.addArguments("--window-size=1200,800");
			options.addArguments("--disable-notifications");
			if((dprop.getProperty("browser").toLowerCase()).contains("headless".toLowerCase())) {
				options.addArguments("--headless");
				options.addArguments("--user-agent=Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.50 Safari/537.36");
			}
			driver = new ChromeDriver(options);			
		} 
		else if (dprop.getProperty("browser").equalsIgnoreCase("firefox")) {
			System.setProperty(dprop.getProperty("firefoxDriver"), dprop.getProperty("firefoxDriverPath"));
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("test-type");
            options.addArguments("--start-maximized");
            options.addArguments("--disable-web-security");
            options.addArguments("--allow-running-insecure-content");
			options.addArguments("--window-size=1200,800");
			options.addArguments("--disable-notifications");
			if((dprop.getProperty("browser").toLowerCase()).contains("headless".toLowerCase())) {
				options.addArguments("--headless");
				options.addArguments("--user-agent=Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.50 Safari/537.36");
			}
			driver = new FirefoxDriver(options);			
		} 
		else if (dprop.getProperty("browser").equalsIgnoreCase("ie")) {
			System.setProperty(dprop.getProperty("internetExplorerDriver"), dprop.getProperty("internetExplorerDriverPath"));			
			driver = new InternetExplorerDriver();
		}

		driver.manage().window().maximize();
		
		// implicit wait
		driver.manage().timeouts().implicitlyWait(Long.parseLong(vprop.getProperty("timeOutValueSec")), TimeUnit.SECONDS);
		driver.get(vprop.getProperty("siteUrl"));
		
	}

	@AfterMethod
	public void endTestAndCloseBrowser(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) 
		{
			//the method below is for path plus file name generation.It exists in utils package under class ScreenShots. 
			String screenshotPath = ScreenShots.takeScreenShot(driver, result.getName());
			System.out.println(screenshotPath);
			//in case of failed test add screen shot in extent report 
			extentTests.log(LogStatus.FAIL, extentTests.addScreenCapture(screenshotPath));
		}
		else if (result.getStatus() == ITestResult.SUCCESS) 
		{
			extentTests.log(LogStatus.PASS, "Test case passed successfully");
		}
		extent.endTest(extentTests);
		
		//All browser windows are closed 
		driver.quit();
	}
}
