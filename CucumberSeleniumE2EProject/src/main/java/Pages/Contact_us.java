package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import freemarker.core.ReturnInstruction.Return;

public class Contact_us {

	WebDriver driver;

	public Contact_us(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//ul[@class='nav navbar-nav']//li[8]//a")
	WebElement contactbutton;

	@FindBy(css = "div[class='contact-form']>h2")
	WebElement getintouch;

	@FindBy(css = "input[name='name']")
	WebElement nameinp;

	@FindBy(css = "input[name='email']")
	WebElement emailinp;

	@FindBy(css = "input[name='subject']")
	WebElement subjectinp;

	@FindBy(css = "textarea[id='message']")
	WebElement messageinp;

	@FindBy(css = "input[name='upload_file']")
	WebElement uploadbutton;

	@FindBy(css = "input[name='submit']")
	WebElement submit;

	@FindBy(xpath = "//ul[@class='nav navbar-nav']//li[1]//a")
	WebElement homebutton;

	@FindBy(css = "div[class='status alert alert-success']")
	WebElement successmesage;

	public void clickoncontactbutton() throws InterruptedException {
		Thread.sleep(2000);
		contactbutton.click();
	}

	public String getintouchtext() throws InterruptedException {
		Thread.sleep(2000);
		String text = getintouch.getText();
		return text;
	}

	public void sendusernamesubjectmessage(String name, String email, String subject, String message)
			throws InterruptedException {
		Thread.sleep(2000);
		nameinp.sendKeys(name);
		emailinp.sendKeys(email);
		subjectinp.sendKeys(subject);
		messageinp.sendKeys(message);
	}

	public void clickonupload() {
		uploadbutton.sendKeys("D:\\rohit\\Education\\Final Resume\\follow up mail.txt");
	}

	public void clickonsubmit() throws InterruptedException {
		Thread.sleep(2000);
		submit.click();

	}

	public void suceessalert() throws InterruptedException {
		Thread.sleep(2000);
		String text = driver.switchTo().alert().getText();
		System.out.println(text);
		driver.switchTo().alert().accept();
		System.out.println();
		Thread.sleep(2000);
		System.out.println(successmesage.getText());
		
	}

	public void clickonhomebutton() throws InterruptedException {
		Thread.sleep(2000);
		homebutton.click();
	}

}
