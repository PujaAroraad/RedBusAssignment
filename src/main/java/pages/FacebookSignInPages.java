package pages;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class FacebookSignInPages {
WebDriver driver;
	
	public FacebookSignInPages(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void launchFacebookUrl(Properties vprop) {
		driver.get(vprop.getProperty("facebookLoginUrl"));
	}
	
	@FindBy(how = How.XPATH, using ="//input[@id='email']") 
	 public WebElement emailIp;
	public void fillEmail(String email) {
		emailIp.sendKeys(email);
	}
	
	@FindBy(how = How.XPATH, using ="//input[@id='pass']") 
	 public WebElement passwordIp;
	public void fillPassword(String password) {
		passwordIp.sendKeys(password);
	}
	
	@FindBy(how = How.XPATH, using ="//button[@id='loginbutton']") 
	 public WebElement loginBtn;
	public void click_loginBtn() {
		loginBtn.click();
	}
}
