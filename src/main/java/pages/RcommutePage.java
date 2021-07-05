package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class RcommutePage {
	WebDriver driver;

	public RcommutePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	String pageTitle="rcommute".toLowerCase();
	
	public boolean validatePageTitle() {
		if(driver.getCurrentUrl().toLowerCase().contains(pageTitle))
			return true;
		else
			return false;
	}
	
	@FindBy(how = How.ID, using ="rcommute_request_call_back") 
	 public WebElement rcommute_request_call_back;
	public void click_rcommute_request_call_back() {
		rcommute_request_call_back.click();
	}
	 
	 @FindBy(how = How.XPATH, using ="//input[@placeholder='YOUR NAME']") 
	 public WebElement nameIP;
	 public void fill_name(String name) {
		 nameIP.sendKeys(name);
	 }
	 
	 @FindBy(how = How.XPATH, using ="//input[@placeholder='YOUR CONTACT NUMBER']") 
	 public WebElement contactNoIP;
	 public void fill_contactNoIP(String contactNo) {
		 contactNoIP.sendKeys(contactNo);
	 }
	 
	 @FindBy(how = How.XPATH, using ="//input[@placeholder='YOUR EMAIL ID']") 
	 public WebElement emailIP;
	 public void fill_emailIP(String email) {
		 emailIP.sendKeys(email);
	 }
	 
	 @FindBy(how = How.XPATH, using ="//input[@placeholder='ORGANISATION NAME']") 
	 public WebElement organizationIP;
	 public void fill_organizationIP(String organization) {
		 organizationIP.sendKeys(organization);
	 }
	
	 
	 @FindBy(how = How.ID, using ="rcommute_form_submit") 
	 public WebElement submit;
	 public void click_submit() {
		 submit.click();
	 }
	 
	 
	 @FindBy(how = How.XPATH, using ="//*[text()='Name can not be empty']") 
	 public WebElement errorBlankName;	 
	 public boolean validateErrorMsg_BlankNameField() {
		 return errorBlankName.isDisplayed();
	 }
	 @FindBy(how = How.XPATH, using ="//div[contains(text(),'Phone number can not be empty')]") 
	 public WebElement errorBlankContact;	 
	 public boolean validateErrorMsg_BlankContactField() {
		 return errorBlankContact.isDisplayed();
	 }
	 @FindBy(how = How.XPATH, using ="//div[contains(text(),'Email ID can not be empty')]") 
	 public WebElement errorBlankEmail;	 
	 public boolean validateErrorMsg_BlankEmailField() {
		 return errorBlankEmail.isDisplayed();
	 }
	 @FindBy(how = How.XPATH, using ="//div[contains(text(),'Organisation Name can not be empty')]") 
	 public WebElement errorBlankOrganization;	 
	 public boolean validateErrorMsg_BlankOrganizationField() {
		 return errorBlankOrganization.isDisplayed();
	 }
	 @FindBy(how = How.XPATH, using ="//div[contains(text(),'Please verify captcha')]") 
	 public WebElement errorBlankCaptcha;	 
	 public boolean validateErrorMsg_BlankCaptchaField() {
		 return errorBlankCaptcha.isDisplayed();
	 }
	 @FindBy(how = How.XPATH, using ="//div[text()='Please enter a valid mobile number.']") 
	 public WebElement errorInvalidPhnNo;	 
	 public boolean validateErrorMsg_errorInvalidPhnNo() {
		 return errorInvalidPhnNo.isDisplayed();
	 }
	 @FindBy(how = How.XPATH, using ="//div[text()='Please enter a valid email.']") 
	 public WebElement errorInvalidEmail;	 
	 public boolean validateErrorMsg_errorInvalidEmail() {
		 return errorInvalidEmail.isDisplayed();
	 }
	 
	 
	 
	 


}
