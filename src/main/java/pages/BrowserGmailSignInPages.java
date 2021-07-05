package pages;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class BrowserGmailSignInPages {
	WebDriver driver;
	
	public BrowserGmailSignInPages(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void launchGoogleAccountUrl(Properties vprop) {
		driver.get(vprop.getProperty("googleLoginUrl"));
	}
	
	@FindBy(how = How.XPATH, using ="//input[@id='identifierId']") 
	 public WebElement emailIp;
	public void fillEmail(String email) {
		emailIp.sendKeys(email);
	}
	
	@FindBy(how = How.XPATH, using ="//*[@id=\"identifierNext\"]/div/button/span") 
	 public WebElement email_next;
	public void click_email_next() {
		email_next.click();
	}
	
	@FindBy(how = How.XPATH, using ="//*[@id=\"password\"]/div[1]/div/div[1]/input") 
	 public WebElement passwordIp;
	public void fillPassword(String password) {
		passwordIp.sendKeys(password);
	}
	
	@FindBy(how = How.XPATH, using ="//span[contains(text(),'Next')]") 
	 public WebElement password_next;
	public void click_password_next() {
		password_next.click();
	}
}
