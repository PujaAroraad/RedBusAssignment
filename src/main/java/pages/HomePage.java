package pages;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	//page title
	public String pageTitle = "Book Bus Travels, AC Volvo Bus, rPool & Bus Hire - redBus India";
	public boolean validatePageTitle() {
		if(pageTitle.equalsIgnoreCase(driver.getTitle()))
			return true;
		else
			return false;
	}

	//src input
	@FindBy(how = How.XPATH, using = "//input[@id='src']")
	public WebElement source;
	String src;

	public void fill_source(String src) {
		this.src = src.toLowerCase();
		source.sendKeys(Keys.CONTROL+"a");
		source.sendKeys(src);
		utils.Waits.hardWait();
		source.sendKeys(Keys.ENTER);
	}

	public boolean match_autofilled_source_content() {
		if ((source.getText().toLowerCase()).contains(this.src))
			return true;
		else
			return false;
	}
	
	//Destination input
	@FindBy(how = How.XPATH, using = "//input[@id='dest']")
	public WebElement destination;
	String dest;

	public void fill_destination(String dest) {
		this.dest = dest.toLowerCase();
		destination.sendKeys(Keys.CONTROL+"a");
		destination.sendKeys(dest);
		utils.Waits.hardWait();
		destination.sendKeys(Keys.ENTER);
	}

	public boolean match_autofilled_destination_content() {
		if ((destination.getText().toLowerCase()).contains(this.dest))
			return true;
		else
			return false;
	}
	
	//calendar field
	@FindBy(how = How.XPATH, using = "//input[@id='onward_cal']")
	public WebElement date;
	@FindBy(how = How.XPATH, using = "//*[@id=\\\"rb-calendar_onward_cal\\\"]/table/tbody/tr[1]/td[1]/button")
	public WebElement previous_month;
	@FindBy(how = How.XPATH, using = "//*[@id=\"rb-calendar_onward_cal\"]/table/tbody/tr[1]/td[3]/button")
	public WebElement next_month;
	//month array
	String[] monthList = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "July", "Aug", "Sept", "Oct", "Nov", "Dec" };
	//ml is month list
	ArrayList<String> ml = new ArrayList<String>(Arrays.asList(monthList));

	public boolean enter_date(int d, int m, int y) {
		date.click();
		LocalDate currentDate = LocalDate.parse(LocalDate.now().toString());
		try {
			if (y >= currentDate.getYear()) {
				if (m < currentDate.getMonthValue() && y == currentDate.getYear()) {
					//previous month .click will always generate exception in case its a past date 
					previous_month.click();
				} else {
					//the below commented code displays actual data value of month year provided by test method
					//uncomment below code to see working in console.
					//System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"+ (ml.get(m - 1) + " " + y)+"@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
					int i=0;
					while (true) {
						//in order to avoid infinite loop the iteration of while loop is restricted to 20 months movement.
						//for this variable i is used.
						if(i==20) {
							return false;
						}
						//the below code displays each value of month year achieved after next_month.click() 
						//the while loop continues till user defined month year achieved.
						//uncomment below code to see working in console
						//System.out.println("*****************************"+driver.findElement(By.className("monthTitle")).getText()+"*****************************");
						if ((ml.get(m - 1) + " " + y).equals(driver.findElement(By.className("monthTitle")).getText()))
							break;
						next_month.click();
						utils.Waits.hardWait();
						i++;
					}
					driver.findElement(By.xpath("//td[contains(text(),'" + Integer.toString(d) + "')]")).click();
				}
			} 
			else {
				previous_month.click();
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	//search button
	@FindBy(how = How.XPATH, using = "//button[@id='search_btn']")
	public WebElement search;
	public void clickSearch() {
		search.click();
	}

	//getting to home page
	public void launchHomePageUrl(Properties vprop) {
		driver.get(vprop.getProperty("siteUrl"));
	}
	
	//sign in block 
	 @FindBy(how = How.XPATH, using ="//div[@id='signin-block']") 
	 public WebElement signInBlock;
	 public void click_signInBlock() {
		 signInBlock.click();
	 }
	 
	 //pop down displayed whwn sign in block clicked
	 @FindBy(how = How.ID, using ="signInLink") 
	 public WebElement signInLink;
	 public void click_signInLink() {
		 signInLink.click();
	 }
	 
	 //login frame appears on sign in click
	 @FindBy(how = How.XPATH, using ="//body/div[6]/div[1]/div[2]/div[1]/div[1]/div[3]/iframe[1]") 
	 public WebElement loginFrame;
	 public void switchTo_loginFrame() {
		 driver.switchTo().frame(loginFrame);
	 }
	
	@FindBy(how = How.XPATH, using ="//iframe[@title='Sign in with Google Button']") 
	 public WebElement signInWithGoogle;
	//Parent window i.e. window before Sign In With Google is clicked
	String parentWindowBeforeSignInWithGoogleClicked;
	public void clickSignInWithGoogle() {
		parentWindowBeforeSignInWithGoogleClicked=driver.getWindowHandle();
		signInWithGoogle.click();
	}
	
	public void windowSwitchToAcceptBrowserLogin() {
		String popw = null;
		utils.Waits.hardWait();
		ArrayList<String> wh= new ArrayList<String>(driver.getWindowHandles());
		Iterator<String> i = wh.iterator();
		while(i.hasNext()) {
			String temp=i.next();
			if(parentWindowBeforeSignInWithGoogleClicked.equalsIgnoreCase(temp)) {}
			else {
				popw=temp;break;}
		}
		driver.switchTo().window(popw);
		//Google pop up window to accept browser sign in... 1st email is clicked below
		driver.findElement(By.xpath("//body/div[@id='container']/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]")).click();
		utils.Waits.hardWait();
		driver.switchTo().window(parentWindowBeforeSignInWithGoogleClicked);
	}
		 
	 @FindBy(how = How.XPATH, using ="//li[@id='signOutLink']") 
	 public WebElement signOutLink;
	 public boolean signOutLinkVisibility() {
		 if(signOutLink.getText().equalsIgnoreCase("Sign Out"))
			 return true;
		 else 
			 return false;
	 }

	 @FindBy(how = How.ID, using ="mobileNoInp") 
	 public WebElement loginByPhnNoIp;
	 public void fill_loginByPhnNoIp(String number) {
		 loginByPhnNoIp.sendKeys(number);
	 }
	 @FindBy(how = How.XPATH, using ="//span[@class='error-message-fixed error-message-full top-fix']") 
	 public WebElement errorMsgInvalidNo;
	 String errorMsg="Please enter valid mobile number";
	 public boolean validate_errorMsgInvalidNo() {
		 if(errorMsgInvalidNo.getText().equals(errorMsg))
			 return true;
		 else 
			 return false;					 
	 }
	 @FindBy(how = How.XPATH, using ="//div[@id='recaptchaElement']") 
	 public WebElement captchaBox;
	 public boolean validateCaptchaBoxdisplayed() {
		 return captchaBox.isDisplayed();
	 }	 
	 
	 @FindBy(how = How.XPATH, using ="//div[@id='newFbId']")
	 public WebElement facebookOption;
	 public void click_facebookOption() {
		 facebookOption.click();
	 }
	 
	 @FindBy(how = How.XPATH, using ="//i[@class='icon-close']")
	 public WebElement closeSignInPopUp;
	 public void click_closeSignInPopUp() {
		 closeSignInPopUp.click();
	 }
	 
	 //manage booking on click shows pop down window 
	 @FindBy(how = How.ID, using ="manageHeaderdd") 
	 public WebElement manageBooking;
	 public void click_manageBooking() {
		 manageBooking.click();
	 }
	 
	//cancel ticket page navigation in pop down window of manage booking
	 @FindBy(how = How.XPATH, using ="//span[contains(text(),'Cancel')]") 
	 public WebElement cancelTicket;
	 public void click_cancelTicket() {
		 cancelTicket.click();
	 }
	 
	//change travel date page navigation in pop down window of manage booking
	 @FindBy(how = How.XPATH, using ="//span[contains(text(),'Change Travel Date')]") 
	 public WebElement changeTravelDate;
	 public void click_changeTravelDate() {
		 changeTravelDate.click();
	 }
	 
	//show my ticket page navigation in pop down window of manage booking
	 @FindBy(how = How.XPATH, using ="//span[contains(text(),'Show My Ticket')]") 
	 public WebElement showMyTicket;
	 public void click_showMyTicket() {
		 showMyTicket.click();
	 }
	 
	 //emailsms page navigation in pop down window of manage booking
	 @FindBy(how = How.XPATH, using ="//span[contains(text(),'Email/SMS')]") 
	 public WebElement emailSms;
	 public void click_emailSms() {
		 emailSms.click();
	 }
	 
	 //bus hire page navigation
	 @FindBy(how = How.XPATH, using ="//a[@id='redBus Bus Hire']") 
	 public WebElement busHire;	 
	 public void click_busHire() {
		 busHire.click();
	 }
	 
	 //help page navigation 
	 @FindBy(how = How.XPATH, using ="//a[contains(text(),'Help')]") 
	 public WebElement help; 
	 String pw_beforeHelp;
	 public void click_help() {
		 pw_beforeHelp=driver.getWindowHandle();
		 help.click();
	 }	 
	 public void switch_helpWindow() {
		 ArrayList<String> wh= new ArrayList<String>(driver.getWindowHandles());
			if(wh.get(0).equals(pw_beforeHelp))driver.switchTo().window(wh.get(1));
			else driver.switchTo().window(wh.get(0));
	 }
	 
}
