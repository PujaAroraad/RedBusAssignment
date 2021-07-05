package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ChangeTravelDatePage {
	WebDriver driver;

	public ChangeTravelDatePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	String pageTitle="Reschedule".toLowerCase();
	
	public boolean validatePageTitle() {
		if(driver.getCurrentUrl().toLowerCase().contains(pageTitle))
			return true;
		else
			return false;
	}
	
	@FindBy(how = How.XPATH, using ="//input[@id='searchTicket']") 
	 public WebElement ticketNoIp;
	public void fill_ticketNo(String ticketNo) {
		ticketNoIp.sendKeys(ticketNo);
	}
	 @FindBy(how = How.XPATH, using ="//input[@id='searchEmail']") 
	 public WebElement emailIp;
	 public void fill_email(String email) {
		 emailIp.sendKeys(email);
	 }
	 
	 @FindBy(how = How.XPATH, using ="//input[@id='ticketSearch']") 
	 public WebElement search;
	 public void click_search() {
		 search.click();
	 }
	 
	 @FindBy(how = How.XPATH, using ="//div[contains(text(),'Please enter valid EmailID')]") 
	 public WebElement errormsg_invalidTicketNo_invalidEmail;
	 public boolean validate_errormsg_invalidTicketNo_invalidEmail() {
			if(errormsg_invalidTicketNo_invalidEmail.getText().equalsIgnoreCase("Please enter valid EmailID"))
				return true;
			else
				return false;
		}
	 
	 @FindBy(how = How.XPATH, using ="//div[contains(text(),'Please enter valid EmailID')]") 
	 public WebElement errormsg_validTicketNo_invalidEmail;
	 public boolean validate_errormsg_validTicketNo_invalidEmail() {
			if(errormsg_validTicketNo_invalidEmail.getText().equalsIgnoreCase("Please enter valid EmailID"))
				return true;
			else
				return false;
		}
	 
	 @FindBy(how = How.XPATH, using ="//span[@id='nf_error']") 
	 public WebElement errormsg_invalidTicketNo_validEmail;
	 public boolean validate_errormsg_invalidTicketNo_validEmail() {
			if(errormsg_invalidTicketNo_validEmail.getText().equalsIgnoreCase("Cannot Fetch Ticket details at the moment."))
				return true;
			else
				return false;
		}
}
