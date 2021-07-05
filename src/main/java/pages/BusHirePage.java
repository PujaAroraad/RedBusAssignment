package pages;

import java.util.ArrayList;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class BusHirePage {

	WebDriver driver;

	public BusHirePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	String pageTitle="Bus Hire: Rent Volvo, AC buses, Mini Buses, Tempo Travellers & Innova Cars - Book Online";
	
	public boolean validatePageTitle() {
		if(pageTitle.equalsIgnoreCase(driver.getTitle()))
			return true;
		else
			return false;
	}	
	
	
	@FindBy(how = How.XPATH, using ="//object") 
	 public WebElement frame;	
	public void switchToFrame() {	
		driver.switchTo().frame(frame);
	}
	
	
	
	
	 @FindBy(how = How.XPATH, using ="//div[contains(text(),'Outstation')]") 
	 public WebElement outstation;
	 public void click_outstation() {
		 outstation.click();
	 }
	 @FindBy(how = How.ID, using ="outstation_back_btn") 
	 public WebElement outstation_back_btn;
	 public void click_outstation_back_btn() {
		 outstation_back_btn.click();
	 }
	 
	 
	 
	 
	 @FindBy(how = How.XPATH, using ="//div[contains(text(),'Local')]") 
	 public WebElement local;
	 public void click_local() {
		 local.click();
	 }
	 @FindBy(how = How.ID, using ="local_back_btn") 
	 public WebElement local_back_btn;
	 public void click_local_back_btn() {
		 local_back_btn.click();
	 }	
	 
	 
	 
	 
	 @FindBy(how = How.XPATH, using ="//div[contains(text(),'Airport')]") 
	 public WebElement airport;
	 public void click_airport() {
		 airport.click();
	 }
	 @FindBy(how = How.ID, using ="airport_back_btn") 
	 public WebElement airport_back_btn;
	 public void click_airport_back_btn() {
		 airport_back_btn.click();
	 }	 
	 
	 
	 
	 
	 @FindBy(how = How.XPATH, using ="//div[contains(text(),'KNOW MORE')]") 
	 public WebElement employeeTransportKnowMore;
	 String pw_beforeKnowMoreClick;
	 public void click_employeeTransportKnowMore() {
		 pw_beforeKnowMoreClick=driver.getWindowHandle();
		 employeeTransportKnowMore.click();
	 }
	 
	 //switch to window
	 public void switchWindow_toRcommute() {
		 ArrayList<String> wh=new ArrayList<String>(driver.getWindowHandles());
		 if(wh.get(0).equals(pw_beforeKnowMoreClick))driver.switchTo().window(wh.get(1));
			else driver.switchTo().window(wh.get(0));
	 }
}
