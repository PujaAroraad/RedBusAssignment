package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HelpPage {

	WebDriver driver;

	public HelpPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public String pageTitle = "red:Care";
	public boolean validatePageTitle() {
		if(pageTitle.equalsIgnoreCase(driver.getTitle()))
			return true;
		else
			return false;
	}
	 @FindBy(how = How.XPATH, using ="//body/section[@id='rh_main']/div[@id='mBWrapper']/div[@id='content']/div[1]/div[1]/iframe[1]") 
	 public WebElement f;
	public void switchFrame() {
		driver.switchTo().frame(f);
	}
	@FindBy(how = How.XPATH, using ="//body/div[@id='reactContentMount']/div[1]/div[1]/div[1]/div[1]") 
	 public WebElement language_popup;
	public void click_language_popup() {
		language_popup.click();
	}
	@FindBy(how = How.XPATH, using ="//*[@id=\"reactContentMount\"]/div[1]/div[2]/div[3]/div[2]/div[1]") 
	 public WebElement newBusBookingHelp;
	public void click_newBusBookingHelp() {
		newBusBookingHelp.click();
	}
	 @FindBy(how = How.XPATH, using ="//body/div[@id='reactContentMount']/div[1]/div[2]/div[3]/div[2]/div[2]") 
	 public WebElement covid19TravelAdvisoryHelp;
	 public void click_covid19TravelAdvisoryHelp() {
		 covid19TravelAdvisoryHelp.click();
		}
	 @FindBy(how = How.XPATH, using ="//*[@id=\"reactContentMount\"]/div[1]/div[2]/div[3]/div[2]/div[3]") 
	 public WebElement safetyPlusFeatureHelp;
	 public void click_safetyPlusFeatureHelp() {
		 safetyPlusFeatureHelp.click();
		}
	 @FindBy(how = How.XPATH, using ="//*[@id=\"reactContentMount\"]/div[1]/div[2]/div[3]/div[2]/div[4]") 
	 public WebElement technicalIssuesHelp;
	 public void click_technicalIssuesHelp() {
		 technicalIssuesHelp.click();
		}
	 @FindBy(how = How.XPATH, using ="//*[@id=\"reactContentMount\"]/div[1]/div[2]/div[3]/div[2]/div[5]") 
	 public WebElement redbusReferralHelp;
	 public void click_redbusReferralHelp() {
		 redbusReferralHelp.click();
		}
	 @FindBy(how = How.XPATH, using ="//*[@id=\"reactContentMount\"]/div[1]/div[2]/div[3]/div[2]/div[6]") 
	 public WebElement offershelp;
	 public void click_offershelp() {
		 offershelp.click();
		}
	 @FindBy(how = How.XPATH, using ="//*[@id=\"reactContentMount\"]/div[1]/div[2]/div[3]/div[2]/div[7]") 
	 public WebElement redBusWalletHelp;
	 public void click_redBusWalletHelp() {
		 redBusWalletHelp.click();
		}
	 @FindBy(how = How.XPATH, using ="//*[@id=\"reactContentMount\"]/div[1]/div[2]/div[3]/div[2]/div[8]") 
	 public WebElement rpoolHelp;
	 public void click_rpoolHelp() {
		 rpoolHelp.click();
		}
	 
	 @FindBy(how = How.XPATH, using ="//div[contains(text(),'view all chats')]")
	 public WebElement viewAllChats;
	 public void click_viewAllChats() {
		 viewAllChats.click();
	 }
	 
	 @FindBy(how = How.XPATH, using ="//*[@id=\"reactContentMount\"]/div/div[2]/div[2]/div")
	 public WebElement viewLastChat;
	 public void click_viewLastChat() {
		 viewLastChat.click();
	 }
	 
	 @FindBy(how = How.XPATH, using ="//*[@id=\"reactContentMount\"]/div/div[3]/div[2]")
	 public WebElement viewPreviousChat;
	 public void click_viewPreviousChat() {
		 viewPreviousChat.click();
	 }
	 
	 
	 @FindBy(how = How.XPATH, using ="//div[@class='ripple']")
	 public WebElement backBtn;
	 public void click_backBtn() {
		 backBtn.click();
	 }
	
	 @FindBy(how = How.XPATH, using ="//body/div[@id='reactContentMount']/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/input[1]") 
	 public WebElement chooseEnglishOpt;
	 public void click_chooseEnglishOpt() {
		 chooseEnglishOpt.click();
	 }
	 
	 @FindBy(how = How.XPATH, using ="//button[contains(text(),'SET LANGUAGE')]") 
	 public WebElement setLanguage;
	 public void click_setLanguage() {
		 setLanguage.click();
	 }
}
