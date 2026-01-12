package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(css = "ul[class='nav navbar-nav']>li:nth-child(4)>a")
	WebElement SigninBtn;
	@FindBy(name = "email")
	WebElement emailIn;
	@FindBy(name = "password")
	WebElement passIn;
	@FindBy(xpath = "//form[@action=\"/login\"]//button")
	WebElement Submit;

	public String gettitle() {
		return driver.getTitle();
	}
	
	public void clickonsiginlink() {
		SigninBtn.click();
	}
	public String getsigninbtntext() {
		return SigninBtn.getText();
	}

	public void enterusername(String str) {
		emailIn.sendKeys(str);
	}
	
	public Boolean isusernamevisible() {
		return emailIn.isDisplayed();
	}

	public void enterpass(String pass) {
		passIn.sendKeys(pass);
	}

	public void clickonsubmit() {
		Submit.click();
	}

}
