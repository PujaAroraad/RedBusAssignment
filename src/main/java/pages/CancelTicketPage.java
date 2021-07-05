package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CancelTicketPage {
	WebDriver driver;

	public CancelTicketPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	String pageTitle="Cancel Ticket - redBus";
	
	public boolean validatePageTitle() {
		if(pageTitle.equalsIgnoreCase(driver.getTitle()))
			return true;
		else
			return false;
	}
	
	@FindBy(how = How.XPATH, using ="//input[@name='tin']") 
	 public WebElement ticketNoIp;
	public void fill_ticketNo(String ticketNo) {
		ticketNoIp.sendKeys(ticketNo);
	}
	 @FindBy(how = How.XPATH, using ="//input[@placeholder='Enter Email']") 
	 public WebElement emailIp;
	 public void fill_email(String email) {
		 emailIp.sendKeys(email);
	 }
	 
	 @FindBy(how = How.XPATH, using ="//div[contains(text(),'Select Passengers')]") 
	 public WebElement selectPassengersBtn;
	 public void click_selectPassengersBtn() {
		 selectPassengersBtn.click();
	 }
	
	 @FindBy(how = How.XPATH, using ="//div[contains(text(),'Please enter correct ticket number (TIN from your ')]") 
	 public WebElement errormsg_invalidTicketNo_invalidEmail;
	 public boolean validate_errormsg_invalidTicketNo_invalidEmail() {
			if(errormsg_invalidTicketNo_invalidEmail.getText().equalsIgnoreCase("Please enter correct ticket number (TIN from your ticket)"))
				return true;
			else
				return false;
		}
	 
	 @FindBy(how = How.XPATH, using ="//div[contains(text(),'Please enter correct email id')]") 
	 public WebElement errormsg_validTicketNo_invalidEmail;
	 public boolean validate_errormsg_validTicketNo_invalidEmail() {
			if(errormsg_validTicketNo_invalidEmail.getText().equalsIgnoreCase("Please enter correct email id"))
				return true;
			else
				return false;
		}
	 
	 @FindBy(how = How.XPATH, using ="//div[contains(text(),'Please enter correct ticket number (TIN from your ')]") 
	 public WebElement errormsg_invalidTicketNo_validEmail;
	 public boolean validate_errormsg_invalidTicketNo_validEmail() {
			if(errormsg_invalidTicketNo_validEmail.getText().equalsIgnoreCase("Please enter correct ticket number (TIN from your ticket)"))
				return true;
			else
				return false;
		}

}
