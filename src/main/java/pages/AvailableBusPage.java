package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AvailableBusPage {
	WebDriver driver;

	public AvailableBusPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public boolean pageTitleVerify(String src, String dest) {
		src=src.toLowerCase();
		dest=dest.toLowerCase();
		String pageTitle=driver.getTitle().toLowerCase();
		int indexOfTo=pageTitle.indexOf("to");
		if((pageTitle.substring(0, indexOfTo)).contains(src) && (pageTitle.substring(indexOfTo, pageTitle.length())).contains(dest))
			return true;
		else
			return false;
	}
	
	 @FindBy(how = How.XPATH, using ="//body[1]/section[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[2]/div[7]/a[1]") 
	 public WebElement seatsavailable;	 
	 
	 @FindBy(how = How.XPATH, using ="//body[1]/section[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[2]/div[6]/a[1]") 
	 public WebElement fare;
	 
	 
	 @FindBy(how = How.XPATH, using ="//body[1]/section[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[2]/div[5]/a[1]") 
	 public WebElement ratings;
	 
	 
	 @FindBy(how = How.XPATH, using ="//body[1]/section[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[2]/div[4]/a[1]") 
	 public WebElement arrival;
	 
	 
	 @FindBy(how = How.XPATH, using ="//body[1]/section[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[2]/div[3]/a[1]") 
	 public WebElement duration;
	 
	 
	 @FindBy(how = How.XPATH, using ="//body[1]/section[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[2]/div[2]/a[1]") 
	 public WebElement departure;
	
	 
	 @FindBy(how = How.XPATH, using ="//div[contains(text(),'View Seats')]") 
	 public WebElement viewSeats;
	 public void click_viewSeats() {
		 viewSeats.click();
	 }
	 
	 @FindBy(how = How.XPATH, using ="//span[contains(text(),'Click on an Available seat to proceed with your tr')]") 
	 public WebElement viewSeatsMsg;
	 public boolean validate_viewSeat() {
		 if(viewSeatsMsg.getText().equalsIgnoreCase("Click on an Available seat to proceed with your transaction."))
			 return true;
		 else
			 return false;
	 }
	 
	 @FindBy(how = How.XPATH, using ="//iframe[@id='restStopIframe']")
	 public WebElement loginFrame;
	 public void switchToLoginFrame() {
		 driver.switchTo().frame(loginFrame);
	 }
	 
	 @FindBy(how = How.XPATH, using ="//*[@id=\"root\"]/div/div[3]/div[1]/i") 
	 public WebElement closePopup;
	 public void click_closePopUp() {
		 closePopup.click();
	 }
	 
	 public void click_seat() {
		 Actions act= new Actions(driver);
		 act.moveByOffset(617, 381);
		 act.clickAndHold();
		 act.release();
		 act.perform();
	 }
	 
	 @FindBy(how = How.CSS, using ="div[class='modal-body oa-y'] li:nth-child(1) div:nth-child(2) span:nth-child(1)")
	 WebElement availabletripTime1stOption;
	 public String get_availabletripTime1stOption() {
		 //as choosing first option of time therefore fetching the contents on of time displayed on screen in 1st option
		 return availabletripTime1stOption.getText();
	 }
	 
	 @FindBy(how = How.XPATH, using ="//div[@class='modal-body oa-y']//li[1]//div[1]//div[1]")
	 WebElement tripTime;
	 public void click_tripTime() {		
		 //the radio button for 1st option is checked.
		 tripTime.click();
	 }
	 
	 @FindBy(how = How.XPATH, using ="//button[normalize-space()='continue']")
	 WebElement continuebtnToBookTrip;
	 public void click_continuebtnToBookTrip() {
		 continuebtnToBookTrip.click();
	 }
	 
	 @FindBy(how = How.CSS, using ="div[class='colBpDp-css'] span[class='bpDpName-Lbl']")
	 WebElement srcBustandInfo;
	 @FindBy(how = How.CSS, using ="div[class='colBpDp-css'] span[class='bpDpSummaryTm-Lbl']")
	 WebElement choosedTimeInfo;
	 public boolean validateTripDetails(String src,String time) {
		 //the below are text displayed elements on screen. 
		 if( srcBustandInfo.getText().toLowerCase().contains(src.toLowerCase())&&
			 srcBustandInfo.getText().toLowerCase().contains("bus stand")&&
			 choosedTimeInfo.getText().contains(time))return true;
		 else return false;
	 }
	 
	 @FindBy(how = How.XPATH, using ="//button[normalize-space()='Proceed to book']")
	 WebElement proceedToBookTrip;
	 public void click_proceedToBookTrip() {
		 proceedToBookTrip.click();
	 }
	 
	 @FindBy(how = How.XPATH, using ="//h4[normalize-space()='Passenger Details']")
	 WebElement passengerPageTitle;
	 public boolean validate_passengerPageTitle() {
		 return passengerPageTitle.isDisplayed();
	 }	 
}
