package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ShowMyTicketPage {
	WebDriver driver;

	public ShowMyTicketPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	String pageTitle="PrintTicket".toLowerCase();
	
	public boolean validatePageTitle() {
		if(driver.getCurrentUrl().toLowerCase().contains(pageTitle))
			return true;
		else
			return false;
	}
	
	@FindBy(how = How.XPATH, using ="//input[@id='searchTicketTIN']") 
	 public WebElement ticketNoIp;
	public void fill_ticketNo(String ticketNo) {
		ticketNoIp.sendKeys(ticketNo);
	}
	 @FindBy(how = How.XPATH, using ="//input[@id='searchTicketEmail']") 
	 public WebElement emailIp;
	 public void fill_email(String email) {
		 emailIp.sendKeys(email);
	 }
	 
	 @FindBy(how = How.XPATH, using ="//input[@id='ticketSearch']") 
	 public WebElement submitBtn;
	 public void click_submitBtn() {
		 submitBtn.click();
	 }
	 
	 @FindBy(how = How.ID, using ="nf_error") 
	 public WebElement errormsg_invalidTicketNo_invalidEmail;
	 public boolean validate_errormsg_invalidTicketNo_invalidEmail() {
			if(errormsg_invalidTicketNo_invalidEmail.getText().equalsIgnoreCase("Something went wrong, please try again later!"))
				return true;
			else
				return false;
		}
	 
	 @FindBy(how = How.ID, using ="nf_error") 
	 public WebElement errormsg_validTicketNo_invalidEmail;
	 public boolean validate_errormsg_validTicketNo_invalidEmail() {
			if(errormsg_validTicketNo_invalidEmail.getText().equalsIgnoreCase("Oops. Looks like you used the incorrect Email ID. Please enter the Email ID which was used during ticket booking"))
				return true;
			else
				return false;
		}
	 
	 @FindBy(how = How.ID, using ="nf_error") 
	 public WebElement errormsg_invalidTicketNo_validEmail;
	 public boolean validate_errormsg_invalidTicketNo_validEmail() {
			if(errormsg_invalidTicketNo_validEmail.getText().equalsIgnoreCase("Something went wrong, please try again later!"))
				return true;
			else
				return false;
		}
}
